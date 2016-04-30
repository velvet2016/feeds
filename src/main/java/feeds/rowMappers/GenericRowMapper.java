package feeds.rowMappers;

import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by linux on 30.04.16.
 */
public class GenericRowMapper implements ParameterizedRowMapper<Map<String, String>> {
    @Override
    public Map<String, String> mapRow(ResultSet rs, int rowNum) throws SQLException {
        HashMap<String, String> map = new HashMap<>();
        ResultSetMetaData metaData = rs.getMetaData();
        int columnCount = metaData.getColumnCount();
        for (int i = 0; i < columnCount; i++) {
            map.put(metaData.getColumnName(i + 1), rs.getString(i + 1));
        }
        return map;
    }
}
