package hr.fer.pi.model.custom_sql_model;

import com.microsoft.sqlserver.jdbc.SQLServerResultSet;

import javax.persistence.Column;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Igor Farszky on 2.12.2017..
 */
public class ResultSQLQuery {

    private RowSQL cols;
    private List<RowSQL> rows;
    private Integer colSize;

    public ResultSQLQuery() {
        this.rows = new ArrayList<>();
        this.cols = new RowSQL();
        this.colSize = 0;
    }

    public ResultSQLQuery(List<RowSQL> rows) {
        this.rows = rows;
    }

    public RowSQL getCols() {
        return cols;
    }

    public void setCols(RowSQL cols) {
        this.cols = cols;
    }

    public void setCols(ResultSet rs) {
        this.cols = new RowSQL();
        try {
            this.colSize = rs.getMetaData().getColumnCount();
            for (int i=1; i<=colSize; i++) {
                this.cols.getRow().add(rs.getMetaData().getColumnName(i));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<RowSQL> getRows() {
        return rows;
    }

    public void setRows(List<RowSQL> rows) {
        this.rows = rows;
    }

    public Integer getColSize() {
        return colSize;
    }

    public void setColSize(Integer colSize) {
        this.colSize = colSize;
    }
}

