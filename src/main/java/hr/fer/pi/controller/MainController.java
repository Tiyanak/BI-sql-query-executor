package hr.fer.pi.controller;

import hr.fer.pi.config.DatabaseConfig;
import hr.fer.pi.model.ajax.SqlQueryResponse;
import hr.fer.pi.model.ajax.TreeNode;
import hr.fer.pi.model.custom_sql_model.DimenzijeSQL;
import hr.fer.pi.model.custom_sql_model.MjereSQL;
import hr.fer.pi.model.custom_sql_model.ResultSQLQuery;
import hr.fer.pi.model.custom_sql_model.RowSQL;
import hr.fer.pi.model.entity.DimCinj;
import hr.fer.pi.model.entity.TabAtribut;
import hr.fer.pi.model.entity.Tablica;
import hr.fer.pi.model.form.Login;
import hr.fer.pi.model.form.Query;
import hr.fer.pi.service.MetadataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Igor Farszky on 1.12.2017..
 */

@Controller
public class MainController {

    @Autowired
    private DatabaseConfig databaseConfig;

    private final MetadataService metadataService;
    private final JdbcTemplate jdbcTemplate;

    private Map<String, String> select = new HashMap<>();
    private Map<Integer, String> fromDim = new HashMap<>();
    private Map<String, String> where = new HashMap<>();
    private Map<String, String> groupby = new HashMap<>();
    private Map<Integer, String> fromCinj = new HashMap<>();
    private String sqlQuery = "";
    private String connectionUrlDefault = "jdbc:sqlserver://localhost:1433;databaseName=pi_dz4;user=****;password=****";
    private String jdbcDefault =  "com.microsoft.sqlserver.jdbc.SQLServerDriver";

    private String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=pi_dz4;user=****;password=****";
    private String jdbc =  "com.microsoft.sqlserver.jdbc.SQLServerDriver";

    @Autowired
    public MainController(MetadataService metadataService, JdbcTemplate jdbcTemplate) {
        this.metadataService = metadataService;
        this.jdbcTemplate = jdbcTemplate;
    }

    @RequestMapping(value = "/sql", method = RequestMethod.GET)
    public ModelAndView query(@ModelAttribute("query") Query query) {

        select.clear();
        fromDim.clear();
        where.clear();
        groupby.clear();
        fromCinj.clear();

        ModelAndView mv = new ModelAndView("index");
        mv.addObject("query", query);
        mv.addObject("cinjenice", metadataService.getAllCinjenice());
        mv.addObject("sqlResult", jdbcQuery(query.getQuery()));
        mv.addObject("connectionUrl", this.connectionUrl.replaceAll("password=.*", "password=*********;"));

        return mv;

    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView login() {
        ModelAndView mv = new ModelAndView("login");
        mv.addObject("login", new Login("jdbc:sqlserver://", databaseConfig.getHost_port(),
                databaseConfig.getDatabaseName(), databaseConfig.getUsername(), databaseConfig.getPassword(), databaseConfig.getDriverClassName(), ""));

        return mv;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ModelAndView login(@ModelAttribute("login") Login login) {
        if (!login.getConnectionUrl().isEmpty()) {
            this.connectionUrl = login.getConnectionUrl();
        } else {
            Connection con = null;
            try {
                this.connectionUrl = login.getJdbc_url() + login.getHost_port() + ";databaseName=" + login.getDatabase() + ";user=" +
                        login.getUser() + ";password=" + login.getPassword() + ";";
                this.jdbc = login.getJdbc();

                Class.forName(this.jdbc);
                con = DriverManager.getConnection(connectionUrl);

            } catch (Exception e) {
                e.printStackTrace();
                this.connectionUrl = this.connectionUrlDefault;
                this.jdbc = this.jdbcDefault;
            } finally {
                if (con != null) try { con.close(); } catch(Exception e) {}
            }
        }

        select.clear();
        fromDim.clear();
        where.clear();
        groupby.clear();
        fromCinj.clear();

        ModelAndView mv = new ModelAndView("index");
        mv.addObject("query", new Query());
        mv.addObject("cinjenice", metadataService.getAllCinjenice());
        mv.addObject("sqlResult", jdbcQuery(""));
        mv.addObject("connectionUrl", this.connectionUrl.replaceAll("password=.*", "password=*********;"));

        return mv;

    }

    @PostMapping("/dimmjere")
    public ResponseEntity<?> getDimMjereAjax(@RequestBody String currentCinjSif) {

        select.clear(); fromCinj.clear(); fromDim.clear(); where.clear(); groupby.clear();

        List<TreeNode> tree = new ArrayList<>();

        Tablica cinjTablica = metadataService.getTablicaBySif(Integer.parseInt(currentCinjSif));
        fromCinj.put(cinjTablica.getSifTablica(), cinjTablica.getNazSQLTablica().trim());

        List<MjereSQL> mjereSQL = metadataService.getMjereBySifTablica(Integer.parseInt(currentCinjSif));
        List<TreeNode> mjere = mjereSQL.stream()
                .map(m -> new TreeNode(m.getImeAtrib(), m.getSifTablica().toString(), m.getNazSQLTablica(),
                        m.getSifTipTablica().toString(), m.getImeSQLAtrib(), m.getImeAtribNoAgrFun(), m.getNazAgrFun(),
                        m.getImeAtrib(), true, null))
                .collect(Collectors.toList());

        List<DimenzijeSQL> dimenzijeSQL = metadataService.getDimenzijeBySifTablica(Integer.parseInt(currentCinjSif));
        List<TreeNode> dimenzije = dimenzijeSQL.stream()
                .map(d -> new TreeNode(d.getNazTablicaDim(),
                        dimenzijeSQL.stream().filter(da -> da.getNazTablicaDim().equals(d.getNazTablicaDim()))
                                .map(m -> new TreeNode(m.getImeAtrib(), m.getSifTablica().toString(), m.getNazSQLTablicaDim(),
                                        m.getSifTipTablicaDim().toString(), m.getImeSQLAtrib(), m.getImeAtrib(),
                                        "", "", false, null)).collect(Collectors.toList())))
                .distinct()
                .collect(Collectors.toList());
        tree.add(new TreeNode("Mjere", mjere));
        tree.add(new TreeNode("Dimenzije", dimenzije));

        return ResponseEntity.ok(tree);

    }

    @PostMapping("/clear")
    public ResponseEntity<?> clearSqlQuery() {
        sqlQuery = "";
        select.clear();
        fromDim.clear();
        where.clear();
        groupby.clear();

        return ResponseEntity.ok("");
    }

    @PostMapping("/selectedNode")
    public ResponseEntity<?> selectedNode(@RequestBody TreeNode node) {

        if (node.isMjera) {
            select.put(node.getText().trim(), node.getNazAgrFun().trim() + "(" + node.getNazSQLTablica().trim() + "."
            + node.getImeSQLAtrib().trim() + ") AS '" + node.getImeAtribAgrFun().trim() + "'");
        } else {
            if (!node.getText().trim().equals("Mjere") && !node.getText().trim().contains("Dimenzije") && !node.getText().contains(node.getNazSQLTablica())) {
                select.put(node.getText().trim(), node.getNazSQLTablica().trim() + "." + node.getImeSQLAtrib().trim() +
                " AS '" + node.getImeSQLAtrib().trim() + "'");
                fromDim.put(Integer.parseInt(node.getSifTablica()), node.getNazSQLTablica().trim());
                groupby.put(node.getText().trim(), node.getNazSQLTablica().trim() + "." + node.getImeSQLAtrib().trim());
            }
        }

        this.sqlQuery = parseQuery();

        return ResponseEntity.ok(new SqlQueryResponse(this.sqlQuery));

    }

    @PostMapping("/unselectedNode")
    public ResponseEntity<?> unselectedNode(@RequestBody TreeNode node) {

        select.remove(node.getText().trim());
        List<Integer> fromDimKeysToRemove = new ArrayList<>();
        for (Map.Entry<Integer, String> fromDimEntry : fromDim.entrySet()) {
            boolean nemaVise = true;
            for (Map.Entry<String, String> selectEntry : select.entrySet()) {
                if (selectEntry.getValue().contains(fromDimEntry.getValue())) {
                    nemaVise = false;
                    break;
                }
            }

            if (nemaVise) {
                fromDimKeysToRemove.add(fromDimEntry.getKey());
            }

        }

        for (Integer keyRemoval : fromDimKeysToRemove) {
            fromDim.remove(keyRemoval);
        }

        List<String> groupbyKeysToRemove = new ArrayList<>();
        for (Map.Entry<String, String> groupbuEntry : groupby.entrySet()) {
            boolean nemaVise = true;
            for (Map.Entry<String, String> selectEntry : select.entrySet()) {
                if (selectEntry.getValue().contains(groupbuEntry.getValue())) {
                    nemaVise = false;
                    break;
                }
            }

            if (nemaVise) {
                groupbyKeysToRemove.add(groupbuEntry.getKey());
            }
        }

        for (String keyRemoval : groupbyKeysToRemove) {
            groupby.remove(keyRemoval);
        }

        this.sqlQuery = parseQuery();

        return ResponseEntity.ok(new SqlQueryResponse(this.sqlQuery));

    }

    public ResultSQLQuery jdbcQuery(String query) {

        // Create a variable for the connection string.
        String connectionUrl = this.connectionUrl;

        // Declare the JDBC objects.
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        ResultSQLQuery resultSql = new ResultSQLQuery();

        try {
            // Establish the connection.
            Class.forName(this.jdbc);
            con = DriverManager.getConnection(connectionUrl);

            // Create and execute an SQL statement that returns some data.
            String SQL = query;
            stmt = con.createStatement();
            rs = stmt.executeQuery(SQL);

            resultSql.setCols(rs);

            while (rs.next()) {
                resultSql.getRows().add(new RowSQL(rs, resultSql.getColSize()));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) try { rs.close(); } catch(Exception e) {}
            if (stmt != null) try { stmt.close(); } catch(Exception e) {}
            if (con != null) try { con.close(); } catch(Exception e) {}
        }

        return resultSql;

    }

    public String parseQuery() {

        String selectString = "SELECT";
        String fromString = "FROM";
        String whereString = "WHERE";
        String groupbyString = "GROUP BY";

        String query = "";

        for (Map.Entry<String, String> entry : select.entrySet()) {
            if (selectString.equals("SELECT")) {
                selectString += " " + entry.getValue();
            } else {
                selectString += ",\n\t " + entry.getValue();
            }
        }
        query += selectString;

        for (Map.Entry<Integer, String> entry : fromCinj.entrySet()) {
            if (fromString.equals("FROM")) {
                fromString += " " + entry.getValue();
            } else {
                fromString += ", " + entry.getValue();
            }
        }
        for (Map.Entry<Integer, String> entry : fromDim.entrySet()) {
            if (fromString.equals("FROM")) {
                fromString += " " + entry.getValue();
            } else {
                fromString += ", " + entry.getValue();
            }
        }
        query += "\n" + fromString;

        query += whereString = parseWhere();

        for (Map.Entry<String, String> entry : groupby.entrySet()) {
            if (groupbyString.equals("GROUP BY")) {
                groupbyString += " " + entry.getValue();
            } else {
                groupbyString += ", " + entry.getValue();
            }
        }
        if (!groupbyString.equals("GROUP BY")) {
            query += "\n" + groupbyString;
        }

        return query;

    }

    public String parseWhere() {

        String whereString = "";

        Integer sifCinjTab = 0; String nazivSqlCinjTab = "";
        for (Map.Entry<Integer, String> entry : fromCinj.entrySet()) {
            sifCinjTab = entry.getKey();
            nazivSqlCinjTab = entry.getValue();
        }

        for (Map.Entry<Integer, String> entry : fromDim.entrySet()) {
            Integer sifDimTab = entry.getKey(); String nazivSqlDimTab = entry.getValue();

            List<DimCinj> dimCinjList = metadataService.getDimCinjFK(sifCinjTab, sifDimTab);
            for (DimCinj dimCinj : dimCinjList) {
                TabAtribut whereTabAtributCinj = metadataService.getTabAtributBySifTablicaByRbrAtrib(dimCinj.getDimCinjId().getSifCinjTablica(), dimCinj.getDimCinjId().getRbrCinj());
                TabAtribut whereTabAtributDim = metadataService.getTabAtributBySifTablicaByRbrAtrib(dimCinj.getDimCinjId().getSifDimTablica(), dimCinj.getDimCinjId().getRbrDim());
                if (whereTabAtributCinj != null && whereTabAtributDim != null) {
                    if (whereString.isEmpty()) {
                        whereString += "\nWHERE " + nazivSqlCinjTab.trim() + "." + whereTabAtributCinj.getImeSQLAtrib().trim()
                        + " = " + nazivSqlDimTab.trim() + "." + whereTabAtributDim.getImeSQLAtrib().trim();
                    } else {
                        whereString += "\n\tAND " + nazivSqlCinjTab.trim() + "." + whereTabAtributCinj.getImeSQLAtrib().trim()
                                + " = " + nazivSqlDimTab.trim() + "." + whereTabAtributDim.getImeSQLAtrib().trim();
                    }
                }
            }
        }

        return whereString;
    }

}
