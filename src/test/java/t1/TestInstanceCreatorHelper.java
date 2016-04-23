package t1;

import t1.interfaces.SimpleCheckerTestInterface;

import java.lang.reflect.Constructor;

/**
 * Created by linux on 23.04.16.
 */
public class TestInstanceCreatorHelper {
    public static SimpleCheckerTestInterface getTestInstance(String className, int runNumber, String caseFilename ){
        try {
            Constructor<?> constructor = Class.forName(className).getConstructor(Integer.class, String.class);
            SimpleCheckerTestInterface simpleCheckerTestInterface =
                    (SimpleCheckerTestInterface)constructor.newInstance(runNumber,caseFilename );
            return simpleCheckerTestInterface;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Can not instantiate object for class: " + className);
        }
    }
}