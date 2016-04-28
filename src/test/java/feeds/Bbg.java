package feeds;

import feeds.enums.VendorProfile;
import feeds.runners.RunnerBbg;
import org.testng.annotations.*;
import feeds.abstractClasses.AbstractFeedTest;
import feeds.actualDataInitializers.ActualDataInitializerBbg;
import feeds.testDataInitializers.TestDataInitializerBbg;
import feeds.vendorFilePreparators.VendorFilePreparatorBbg;


import java.util.Map;

import static org.testng.Assert.assertEquals;

/**
 * Created by linux on 23.04.16.
 */
@Listeners(TestClassesSorter.class)
public class Bbg extends AbstractFeedTest {
    public Bbg(Integer runNumber,
               String tag,
               Map<String, String> vendorDataFiles,
               Map<String, String> expectedDataFiles,
               Boolean isPublishingByDirectUpdateNeeded) {
        super(runNumber, tag, vendorDataFiles, expectedDataFiles, isPublishingByDirectUpdateNeeded);
        this.vendorInfo = VendorInfoReader.getVendorInfo(VendorProfile.BBG, env);
        this.runner = new RunnerBbg();
        this.actualDataInitializer = new ActualDataInitializerBbg();
        this.testDataInitializer = new TestDataInitializerBbg();
        this.vendorFilePreparator = new VendorFilePreparatorBbg();
    }
    @BeforeClass
    public void preparation() throws Exception {
        setUp();
    }

    @DataProvider
    public Object[][] getDataForTest(){
        return getDataProvider();
    }

    @Test(dataProvider = "getDataForTest")
    public void test(int exp, int act) throws Exception {
        logger.info(this.getClass()+" checking...");
        assertEquals(act,exp);
    }
}
