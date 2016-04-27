package feeds;

import org.testng.annotations.Factory;
import feeds.interfaces.FeedTestInterface;
import feeds.interfaces.SimpleCheckerTestInterface;

import java.util.List;

/**
 * Created by linux on 23.04.16.
 */
public class TestFactory {
    @Factory
    public Object[] factoryMethod()
    {
        List<RunInfo> suiteConfig = new SuiteParser().parse("suites/suite1.xml");
        Object[] obs = new Object[suiteConfig.size()];
        int runNumber = 0;
        for (RunInfo runInfo : suiteConfig) {
            SimpleCheckerTestInterface testClassInstance = TestInstanceCreatorHelper.getTestInstance(
                    runInfo.getClassName(),
                    runNumber,
                    runInfo.getTag(),
                    runInfo.getVendorFileTypesToFiles(),
                    runInfo.getExpectedFileTypesToFiles(),
                    runInfo.getPublishingInfo()
                    );
            obs[runNumber++] = (testClassInstance instanceof FeedTestInterface) ? (FeedTestInterface) testClassInstance : testClassInstance;
        }

        return obs;
    }
}
