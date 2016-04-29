package feeds;


import feeds.services.DbService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        ArrayList<Integer> l = new ArrayList();
        l.add(79078);
        l.add(79079);
        HashMap<String, Object> params = new HashMap<>();
        params.put("id", 79078);
        params.put("name", "Microsoft");
        DbService dbService = DbService.getInstance();

        dbService.select("select * from party where id =:id  \n" +
                " and name = :name", params);

/*
        Pattern pattern = Pattern.compile("(:.+?)([\\s\\)]|$)");
        String input = "select * from party where id =:id and name = :name) and :name country = :country";
        Matcher matcher = pattern.matcher(input);

        ArrayList<String> placeHolders = new ArrayList<>();
        while(matcher.find()){
            placeHolders.add(matcher.group(1));
        }

        HashSet<String> placeHolderSet = new HashSet<>(placeHolders);
        for (String placeHolder : placeHolderSet) {
            input = input.replaceAll(placeHolder, "?");
        }
        System.out.println(input);*/
        //System.out.println(placeHolders);


/*        String sql = "select * from party where id =:id and name = :name";

        String replaced = sql.replaceFirst(":.+?[\\s)]", "replaced");
        System.out.println(replaced);*/

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