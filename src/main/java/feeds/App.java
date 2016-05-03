package feeds;


import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App  {

    public static void main(String[] args) {
        System.out.println();

/*        Logger logger = Logger.getLogger("App");
        ArrayList<Integer> l = new ArrayList();
        l.add(79078);
        l.add(79079);
        HashMap<String, Object> params = new HashMap<>();
        params.put("ids", l);
        //params.put("name", "Microsoft");
        DbServiceSpring dbService = DbServiceSpring.getInstance();
        List<Map<String, String>> parties = dbService.getParties(params);
        System.out.println(parties);
        logger.trace("trace");
        logger.debug("debug");
        logger.info("info");
        logger.warn("warn");
        logger.error("error");
        logger.fatal("fatal");*/




      /*  ArrayList<Integer> l = new ArrayList();
        l.add(79078);
        l.add(79079);
        HashMap<String, Object> params = new HashMap<>();
        params.put("id", 79078);
        params.put("name", "Microsoft");
        DbService dbService = DbService.getInstance();

        dbService.select("select * from party where id =:id  \n" +
                " and name = :name", params);*/

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