package hr.fer.pi.config;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import hr.fer.pi.model.embedded.DimCinjId;
import hr.fer.pi.model.embedded.TabAtributAgrFunId;
import hr.fer.pi.model.embedded.TabAtributId;
import hr.fer.pi.model.entity.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by Igor Farszky on 5.12.2017..
 */

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "sqlEntityManager",
        transactionManagerRef = "sqlTransactionManager",
        basePackages = {"hr.fer.pi", "hr.fer.pi.model.entity",
            "hr.fer.pi.model.embedded",
            "hr.fer.pi.repository"}
)
public class DatabaseConfig {

    private String driverClassName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private String url = "jdbc:sqlserver://localhost:1433;databaseName=pi_dz4";
    private String username = "****";
    private String password = "****";
    private String databaseName = "pi_dz4";
    private String host_port = "localhost:1433";

    public DatabaseConfig() {
        String jdbc_config_path = System.getProperty("user.home") + "/Desktop/jdbc_config.txt";
        System.out.println(jdbc_config_path);
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File(jdbc_config_path)));
            String line = "";
            while ((line = reader.readLine()) != null) {
                if (line.contains("url=")) { url = line.replace("url=", "").trim(); }
                if (line.contains("driverClassName=")) { driverClassName = line.replace("driverClassName=", "").trim(); }
                if (line.contains("user=")) { username = line.replace("user=", "").trim(); }
                if (line.contains("password=")) { password = line.replace("password=", "").trim(); }
                if (line.contains("databaseName=")) { databaseName = line.replace("databaseName=", "").trim(); }
                if (line.contains("host_port=")) { host_port = line.replace("host_port=", "").trim(); }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setDatasourceParams(String driverClassName, String url, String username, String password) {
        this.driverClassName = driverClassName;
        this.url = url;
        this.username = username;
        this.password = password;
    }

    @Primary
    @Bean
    public DataSource datasource() {
        return DataSourceBuilder
                .create()
                .driverClassName(driverClassName)
                .url(url)
                .username(username)
                .password(password)
                .build();
    }

    @Primary
    @Bean(name = "sqlEntityManager")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(datasource())
                .properties(hibernateProperties())
                .packages(AgrFun.class, DimCinj.class, TabAtribut.class, TabAtributAgrFun.class, Tablica.class,
                        TipAtrib.class, TipTablica.class, DimCinjId.class, TabAtributAgrFunId.class, TabAtributId.class)
                .persistenceUnit("sqlPU")
                .build();
    }

    @Primary
    @Bean(name = "sqlTransactionManager")
    public PlatformTransactionManager mysqlTransactionManager(@Qualifier("sqlEntityManager") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }

    private Map hibernateProperties() {

        Resource resource = new ClassPathResource("hibernate.properties");

        try {
            Properties properties = PropertiesLoaderUtils.loadProperties(resource);

            return properties.entrySet().stream()
                    .collect(Collectors.toMap(
                            e -> e.getKey().toString(),
                            e -> e.getValue())
                    );
        } catch (IOException e) {
            return new HashMap();
        }
    }

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDatabaseName() {
        return databaseName;
    }

    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }

    public String getHost_port() {
        return host_port;
    }

    public void setHost_port(String host_port) {
        this.host_port = host_port;
    }
}
