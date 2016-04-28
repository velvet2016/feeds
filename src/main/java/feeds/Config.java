package feeds;

/**
 * Created by linux on 28.04.16.
 */
public class Config  {
    public static final String SUITE = PropertyReader.getProperties("common.properties").getProperty("suite");
    private static final String ENV_PROPERTIES = PropertyReader.getProperties("common.properties").getProperty("env.property.file");
    public static final String ENV = PropertyReader.getProperties(ENV_PROPERTIES).getProperty("env");
    public static final String DB_URL = PropertyReader.getProperties(ENV_PROPERTIES).getProperty("db.url");
    public static final String DB_USER = PropertyReader.getProperties(ENV_PROPERTIES).getProperty("db.user");
    public static final String DB_PASSWORD = PropertyReader.getProperties(ENV_PROPERTIES).getProperty("db.password");


    static{
        System.out.println("\n\n");
        System.out.println("------------------------------------------------------------");
        System.out.println("   Common config:\n");
        System.out.println("   envProperties: "+ ENV_PROPERTIES);
        System.out.println("   env: "+ ENV);
        System.out.println("   dbUrl: "+DB_URL);
        System.out.println("   dbUser: "+DB_USER);
        System.out.println("------------------------------------------------------------");
        System.out.println("\n\n");
    }

}
