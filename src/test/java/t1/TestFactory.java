package t1;

import org.testng.annotations.Factory;
import t1.interfaces.FeedTestInterface;
import t1.interfaces.SimpleCheckerTestInterface;

import java.util.List;

/**
 * Created by linux on 23.04.16.
 */
public class TestFactory {
    @Factory
    public Object[] factoryMethod()
    {
        List<RunInfo> suiteConfig = PropertyReader.getSuiteConfig();
        Object[] obs = new Object[suiteConfig.size()];
        int runNumber = 0;
        for (RunInfo runInfo : suiteConfig) {
            String className = runInfo.getClassName();
            List<String> caseFileName = runInfo.getCasesFileNames();
            SimpleCheckerTestInterface testClassInstance = TestInstanceCreatorHelper.getTestInstance("t1."+className, runNumber, caseFileName);
            obs[runNumber++] = (testClassInstance instanceof FeedTestInterface) ? (FeedTestInterface) testClassInstance : testClassInstance;
        }

        return obs;
    }
}
