package feeds.services;

import feeds.Config;
import feeds.LoggedClass;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by linux on 23.04.16.
 */
public class DbService extends LoggedClass {
    private static volatile DbService instance;
    private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
    private Connection connection;


    public static DbService getInstance() {
        DbService localInstance = instance;
        if (localInstance == null) {
            synchronized (DbService.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new DbService();
                }
            }
        }
        return localInstance;
    }

    public CustomResultSet select(String sql) {
        connect();
        ArrayList<List<String>> rows = new ArrayList<>();
        ArrayList<String> columnNames = new ArrayList<>();
        try (Statement statement = connection.createStatement();) {
            System.out.println(sql);
            ResultSet rs = statement.executeQuery(sql);
            boolean firstRow = true;
            while (rs.next()) {
                List<String> row = new ArrayList<>();
                for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                    if (firstRow) {
                        columnNames.add(rs.getMetaData().getColumnName(i));
                    }
                    row.add(rs.getString(i));
                }
                firstRow = false;
                rows.add(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
        CustomResultSet resultSet = new CustomResultSet(columnNames, rows);
        logger.debug(resultSet.toString());
        return resultSet;
    }


    private void connect() {
        try {
            if (connection != null && !connection.isClosed() && connection.isValid(0)) {
                return;
            }
            connection = DriverManager.getConnection(Config.DB_URL, Config.DB_USER, Config.DB_PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }

    public static class CustomResultSet{
        private ArrayList<String> columnNames;
        private ArrayList<List<String>> rows;

        public CustomResultSet(ArrayList<String> columnNames, ArrayList<List<String>> rows) {
            this.columnNames = columnNames;
            this.rows = rows;
        }

        public ArrayList<String> getColumnNames() {
            return columnNames;
        }

        public ArrayList<List<String>> getRows() {
            return rows;
        }

        @Override
        public String toString() {
            String formatPattern = "%1$15s";
            StringBuilder sb =  new StringBuilder();
            sb.append("CustomResultSet:\n");
            for (String columnName : columnNames) {
                String formatted = String.format(formatPattern, columnName);
                sb.append(formatted+", ");
            }
            sb.deleteCharAt(sb.length()-1);
            sb.deleteCharAt(sb.length()-1);
            sb.append("\n");
            for (List<String> row : rows) {
                for (String columnValue : row) {
                    String formatted = String.format(formatPattern, columnValue);
                    sb.append(formatted+", ") ;
                }
                sb.deleteCharAt(sb.length()-1);
                sb.deleteCharAt(sb.length()-1);
                sb.append("\n");
            }
            return sb.toString();
        }
    }
    public void queryDb() {
        System.out.println("querying db...");
    }

}
