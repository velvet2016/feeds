package feeds;

import org.testng.annotations.Factory;
import feeds.interfaces.FeedTestInterface;
import feeds.interfaces.SimpleCheckerTestInterface;

import java.util.List;

/**
 * Created by linux on 23.04.16.
 */
public class SuiteRunner extends LoggedClass {
    @Factory
    public Object[] factoryMethod()
    {
        List<RunInfo> suiteConfig = new SuiteParser().parse(Config.SUITE);
        Object[] obs = new Object[suiteConfig.size()];
        int runNumber = 0;
        for (RunInfo runInfo : suiteConfig) {
            SimpleCheckerTestInterface testClassInstance = InstanceFactory.getTestInstance(
                    runInfo.getClassName(),
                    runNumber,
                    runInfo.getTag(),
                    runInfo.getVendorFileTypesToFiles(),
                    runInfo.getExpectedFileTypesToFiles(),
                    runInfo.isPublishingByDirectUpdateNeeded()
                    );
            obs[runNumber++] = (testClassInstance instanceof FeedTestInterface) ? (FeedTestInterface) testClassInstance : testClassInstance;
        }
        logger.debug("Actually instantiated  test clasess sequence:");
        for (Object ob : obs) {
            logger.debug(ob.getClass());
        }
        return obs;
    }
}
