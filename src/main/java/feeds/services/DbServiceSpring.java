package feeds.services;

import feeds.Config;
import feeds.rowMappers.GenericRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

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
        dboTemplate = new SimpleJdbcTemplate(Config.dboDataSource);
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
