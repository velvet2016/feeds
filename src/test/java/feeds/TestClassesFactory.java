package feeds;

import feeds.interfaces.SimpleCheckerTestInterface;

import java.lang.reflect.Constructor;
import java.util.List;
import java.util.Map;

/**
 * Created by linux on 23.04.16.
 */
public class TestClassesFactory {
    public static SimpleCheckerTestInterface getTestInstance(
            String className,
            int runNumber,
            String tag,
            Map<String, String> vendorDataFiles,
            Map<String, String> expectedDataFiles,
            Boolean isPublishingByDirectUpdateNeeded
    ){
        try {
            Constructor<?> constructor = Class.forName(className).getConstructor(
                    Integer.class,
                    String.class,
                    Map.class,
                    Map.class,
                    Boolean.class);
            return (SimpleCheckerTestInterface)constructor.newInstance(
                    runNumber,
                    tag,
                    vendorDataFiles,
                    expectedDataFiles,
                    isPublishingByDirectUpdateNeeded);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Can not instantiate object for class: " + className);
        }
    }
}
