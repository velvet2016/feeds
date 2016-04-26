package feeds;

import org.testng.annotations.*;
import feeds.abstractClasses.AbstractTest;
import feeds.actualDataInitializers.ActualDataInitializerSimpleCheck;
import feeds.testDataInitializers.TestDataInitializerSimpleCheck;

import java.util.List;
import java.util.Map;

import static org.testng.Assert.assertEquals;

/**
 * Created by linux on 23.04.16.
 */
@Listeners(TestClassesSorter.class)
public  class NonFeedCheck extends AbstractTest {
    public NonFeedCheck(Integer runNumber, String tag, Map<String, String> vendorDataFiles, Map<String, String> expectedDataFiles) {
        super(runNumber, tag, vendorDataFiles, expectedDataFiles);
        this.actualDataInitializer = new ActualDataInitializerSimpleCheck();
        this.testDataInitializer = new TestDataInitializerSimpleCheck();
    }
    @Override
    public List<String> getVendorIds(List<TestDataEntry> testData, VendorInfo vendorInfo) {
        return null;
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
