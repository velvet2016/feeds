package feeds;

/**
 * Created by linux on 28.04.16.
 */
public class Config  {
    private static final String suite = PropertyReader.getCommonConfig().getProperty("suite");
    private static final String env = PropertyReader.getCommonConfig().getProperty("env");


    static{
        System.out.println("\n\n");
        System.out.println("------------------------------");
        System.out.println("   Common config:\n");
        System.out.println("   env: "+env);
        System.out.println("   suite: "+suite);
        System.out.println("------------------------------");
        System.out.println("\n\n");
    }

    public static String getSuite() {
        return suite;
    }

    public static String getEnv() {
        return env;
    }
}
