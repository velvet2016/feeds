package feeds.services;

import feeds.Config;
import feeds.LoggedClass;

import java.math.BigDecimal;
import java.sql.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by linux on 23.04.16.
 */
public class DbService extends LoggedClass {
    private static volatile DbService instance;
    private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
    private Connection connection;
    private static Map<Class,Integer> typesMap;
    private static int printedColumnLenght = 20;
    static
    {
        typesMap = new HashMap<>();
        DbService.typesMap.put(String.class, Types.VARCHAR);
        DbService.typesMap.put(Integer.class, Types.NUMERIC);
        DbService.typesMap.put(BigDecimal.class, Types.NUMERIC);
    }

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

    public List<Map<String, String>> select(String sql) {
        connect();
        ArrayList<Map<String, String>> resultList;
        try (Statement statement = connection.createStatement();) {
            logger.debug("Executing query: \n"+sql+"\n");
            ResultSet rs = statement.executeQuery(sql);

            resultList = getResultList(rs);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
        return resultList;
    }

    public List<Map<String, String>> select(String sql, Map<String, Object> params) {
        connect();
        ArrayList<Map<String, String>> resultList;
        List<String> placeHolderList = getPlaceHolderList(sql);
        sql = replacePlaceHolders(sql, placeHolderList);

        try (PreparedStatement pst = connection.prepareStatement(sql);) {
            logger.debug("Executing query: \n" + sql+"\n");
            printParams(placeHolderList, params);

            for (String key : params.keySet()) {
                if (params.get(key) instanceof List ) {
                    params.get(key);
                    List list = (List) params.get(key);
                    String type = list.get(0) instanceof Number ? "NUMBER" : "VARCHAR";
                    Array arrayOf = connection.createArrayOf(type, list.toArray());
                    params.put(key, arrayOf);
                }
            }


            int paramIndex = 1;
            for (String key : placeHolderList) {
                pst.setObject(paramIndex++, params.get(key));
            }

            ResultSet rs = pst.executeQuery();
            resultList = getResultList(rs);

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
        return resultList;
    }

    private ArrayList<Map<String, String>> getResultList(ResultSet rs) throws SQLException {
        ArrayList<String> columnNames = new ArrayList<>();
        ArrayList<Map<String, String>> resultList = new ArrayList<>();
        boolean firstRow = true;
        while (rs.next()) {
            HashMap<String, String> rowMap = new HashMap<>();
            for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                if (firstRow) {
                    columnNames.add(rs.getMetaData().getColumnName(i));
                }
                rowMap.put(columnNames.get(i-1),rs.getString(i));
            }
            firstRow = false;
            resultList.add(rowMap);
        }
        logger.debug(getPrintableString(resultList, columnNames));
        return resultList;
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
    private String getPrintableString(List<Map<String, String>> rows, List<String> colNames){
        int maxNumberToShow = 50;
        int displayedRowCount = rows.size() < maxNumberToShow ? rows.size() : maxNumberToShow;
        StringBuilder sb =  new StringBuilder();
        sb.append("Querying result: \nDisplaying "+displayedRowCount+" row(s) out of "+rows.size()+" rows:\n");
        String formatPattern = "%1$"+printedColumnLenght+"s";
        if (colNames == null || colNames.size()==0) {
            sb.append("empty result set");
            return sb.toString();
        }
        for (String colName : colNames) {
            addValue(sb, formatPattern, colName);
        }
        endLine(sb);
        int i = 0;
        for (Map<String, String> row : rows) {
            if(++i>maxNumberToShow) {
                sb.append("...\n");
                break;
            }
            for (String colName : colNames) {
                addValue(sb, formatPattern, row.get(colName));
            }
            endLine(sb);
        }
        return sb.toString();
    }

    private void addValue(StringBuilder sb, String formatPattern, String str) {
        String s = str.length()>printedColumnLenght ? str.substring(0,printedColumnLenght-2)+"..": str;
        String formatted = String.format(formatPattern, s );
        sb.append(formatted+ ", ");
    }

    private void endLine(StringBuilder sb) {
        sb.deleteCharAt(sb.length()-1);
        sb.deleteCharAt(sb.length()-1);
        sb.append("\n");
    }

    public void queryDb() {
        System.out.println("querying db...");
    }

    private List<String> getPlaceHolderList(String sql){
        Pattern pattern = Pattern.compile(":(.+?)([\\s\\)]|$)");
        Matcher matcher = pattern.matcher(sql);

        ArrayList<String> placeHolders = new ArrayList<>();
        while(matcher.find()){
            placeHolders.add(matcher.group(1));
        }

        return placeHolders;
    }

    private String replacePlaceHolders(String sql, List<String> placeHolderList){
        HashSet<String> placeHolderSet = new HashSet<>(placeHolderList);
        for (String placeHolder : placeHolderSet) {
            sql = sql.replaceAll(":"+placeHolder, "?");
        }
        return sql;
    }
    private void printParams(List<String> keys, Map<String,Object> params){
        StringBuilder sb = new StringBuilder();
        sb.append("Params:\n");
        for (String key : keys) {
            sb.append(params.get(key));
            sb.append("\n");
        }
        logger.debug(sb);
    }

}
