package feeds.testDataInitializers;

import feeds.*;
import feeds.interfaces.TestDataInitializerInterface;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * Created by linux on 24.04.16.
 */
public abstract class TestDataInitializer extends LoggedClass implements TestDataInitializerInterface {

    private  static final String ENCODING = Config.TEST_CASES_FILE_ENCODING;

    @Override
    public Map<String,VendorData> getVendorData(Map<String, String> typeToFileMap) {
        return null;
    }

    @Override
    public List<TestDataEntry> getExpectedData(File file) {
        logger.info("getting Expected Data...");
        return null;
    }
    public List<LinkedHashMap> readSimpleFile(String fileFPath){
        List<String> header = null;
        List<String> currentLineValues;
        List<LinkedHashMap> rowObjectsList = new ArrayList<>();
        try (BufferedReader br = CommonMethods.getBuferedReader(fileFPath, ENCODING)) {
            String line = null;
            int lineNumber=1;
            while ((line = br.readLine()) != null) {
                List<String> values = Arrays.asList(line.split(";"));
                if (lineNumber++>1){
                    currentLineValues = values;
                    if (values.size() != header.size()){
                        throw new RuntimeException("Count of header values does not equal count of row values, line number: "+lineNumber+" File: "+fileFPath);
                    }
                    LinkedHashMap<String, String> rowObject = new LinkedHashMap<>();
                    for (int j = 0; j < header.size(); j++) {
                        rowObject.put(header.get(j), currentLineValues.get(j));
                    }
                    rowObjectsList.add(rowObject);
                }else{
                    header = values;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return rowObjectsList.size() != 0 ? rowObjectsList : null;
    }
}
