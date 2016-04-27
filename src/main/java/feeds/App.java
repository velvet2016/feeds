package feeds;

import java.io.File;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {



        File file = new TextReader().getFile("tr.properties");
        System.out.println(file);

        SuiteParser suiteParser = new SuiteParser();
        List<RunInfo> ri = suiteParser.parse("suites/suite1.xml");
        System.out.println(ri);


    }
}
