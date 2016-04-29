package feeds;


import feeds.services.DbService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

            DbService dbService = DbService.getInstance();
            dbService.select("select id from party");


    }



}
 /*   public static void g(){
        *//*Properties commonConfig = PropertyReader.getCommonConfig();
        System.out.println(commonConfig.getProperty("suite"));
        System.out.println(commonConfig.getProperty("env"));*//*


        *//*Parameters params = new Parameters();
        FileBasedConfigurationBuilder<FileBasedConfiguration> builder =
                new FileBasedConfigurationBuilder<FileBasedConfiguration>(PropertiesConfiguration.class)
                        .configure(params.properties()
                                .setFileName("common.properties"));
        try
        {
            Configuration config = builder.getConfiguration();
            String env = config.getString("env");
            System.out.println(env);
            String suite = config.getString("suite");
            System.out.println(suite);

        }
        catch(ConfigurationException cex)
        {
            cex.printStackTrace();
            // loading of the configuration file failed
        }*//*
    }
}
*/