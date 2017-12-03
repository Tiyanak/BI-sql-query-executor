package hr.fer.pi.model.ajax;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * Created by Igor Farszky on 3.12.2017..
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public class SqlQueryResponse {

    private String query;

    public SqlQueryResponse() {
    }

    public SqlQueryResponse(String query) {
        this.query = query;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }
}
