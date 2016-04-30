package feeds.services;

import feeds.Config;
import feeds.rowMappers.GenericRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.List;
import java.util.Map;

/**
 * Created by linux on 30.04.16.
 */
public class DbServiceSpring {
    private static volatile DbServiceSpring instance;
    private SimpleJdbcTemplate dboTemplate;
    private static final GenericRowMapper RM = new GenericRowMapper();

    public DbServiceSpring() {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName(Config.JDBC_DRIVER);
        ds.setUrl(Config.DB_DBO_URL);
        ds.setUsername(Config.DB_DBO_USER);
        ds.setPassword(Config.DB_DBO_PASSWORD);
        dboTemplate = new SimpleJdbcTemplate(ds);

        //if needed, template for another schemas can be initialized here
    }
    public static DbServiceSpring getInstance() {
        DbServiceSpring localInstance = instance;
        if (localInstance == null) {
            synchronized (DbServiceSpring.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new DbServiceSpring();
                }
            }
        }
        return localInstance;
    }

    public List<Map<String, String>> getParties(Map params){
      return  dboTemplate.query("select * from party", RM);
    }

}
