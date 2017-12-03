package hr.fer.pi.model.form;

/**
 * Created by Igor Farszky on 3.12.2017..
 */
public class Login {

    private String jdbc_url;
    private String host_port;
    private String database;
    private String user;
    private String password;
    private String jdbc;
    private String connectionUrl;

    public Login() {
    }

    public Login(String jdbc_url, String host_port, String database, String user, String password, String jdbc, String connectionUrl) {
        this.jdbc_url = jdbc_url;
        this.host_port = host_port;
        this.database = database;
        this.user = user;
        this.password = password;
        this.jdbc = jdbc;
        this.connectionUrl = connectionUrl;
    }

    public String getJdbc_url() {
        return jdbc_url;
    }

    public void setJdbc_url(String jdbc_url) {
        this.jdbc_url = jdbc_url;
    }

    public String getHost_port() {
        return host_port;
    }

    public void setHost_port(String host_port) {
        this.host_port = host_port;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getJdbc() {
        return jdbc;
    }

    public void setJdbc(String jdbc) {
        this.jdbc = jdbc;
    }

    public String getConnectionUrl() {
        return connectionUrl;
    }

    public void setConnectionUrl(String connectionUrl) {
        this.connectionUrl = connectionUrl;
    }
}
