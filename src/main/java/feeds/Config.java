package feeds;


import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;

/**
 * Created by linux on 28.04.16.
 */
public class Config  {
    public static final String SUITE = PropertyReader.getProperties("common.properties").getProperty("suite");
    public static final String JDBC_DRIVER = PropertyReader.getProperties("common.properties").getProperty("jdbc.driver.class");
    private static final String ENV_PROPERTIES = PropertyReader.getProperties("common.properties").getProperty("env.property.file");
    public static final String ENV = PropertyReader.getProperties(ENV_PROPERTIES).getProperty("env");
    public static final String DB_DBO_URL = PropertyReader.getProperties(ENV_PROPERTIES).getProperty("db.dbo.url");
    public static final String DB_DBO_USER = PropertyReader.getProperties(ENV_PROPERTIES).getProperty("db.dbo.user");
    public static final String DB_DBO_PASSWORD = PropertyReader.getProperties(ENV_PROPERTIES).getProperty("db.dbo.password");
    public static final String TEST_CASES_FILE_ENCODING = PropertyReader.getProperties("common.properties").getProperty("test.cases.file.encoding");


    static{
        System.out.println("\n------------------------------------------------------------");
        System.out.println("   Config:\n");
        System.out.println("   suite:         "+ SUITE);
        System.out.println("   envProperties: "+ ENV_PROPERTIES);
        System.out.println("   env:           "+ ENV);
        System.out.println("   db_dbo_Url:    "+ DB_DBO_URL);
        System.out.println("   db_dbo_User:   "+ DB_DBO_USER);
        System.out.println("------------------------------------------------------------\n");
        System.out.println("------------------------------------------------------------");
        System.out.println("   Suite to run:\n");
        CommonMethods.printFile(SUITE,TEST_CASES_FILE_ENCODING);
        System.out.println("------------------------------------------------------------\n");

    }
}
