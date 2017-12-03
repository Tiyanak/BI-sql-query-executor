package hr.fer.pi.model.custom_sql_model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Igor Farszky on 2.12.2017..
 */
public class RowSQL {

    private List<String> row;

    public RowSQL() {
        this.row = new ArrayList<>();
    }

    public RowSQL(List<String> row) {
        this.row = row;
    }

    public RowSQL(ResultSet resultSet, Integer colSize) {
        this.row = new ArrayList<>();
        for (int i=1; i<=colSize; i++) {
            try {
                row.add(resultSet.getString(i));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public List<String> getRow() {
        return row;
    }

    public void setRow(List<String> row) {
        this.row = row;
    }
}
