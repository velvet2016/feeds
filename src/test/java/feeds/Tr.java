package feeds;

import org.testng.annotations.*;
import feeds.abstractClasses.AbstractFeedTest;
import feeds.actualDataInitializers.ActualDataInitializerTr;
import feeds.runners.RunnerTr;
import feeds.testDataInitializers.TestDataInitializerTr;
import feeds.vendorFilePreparators.VendorFilePreparatorTr;

import java.util.Map;

import static org.testng.Assert.assertEquals;

/**
 * Created by linux on 23.04.16.
 */
@Listeners(TestClassesSorter.class)
public class Tr extends AbstractFeedTest {

    public Tr(Integer runNumber, String tag, Map<String, String> vendorDataFiles, Map<String, String> expectedDataFiles) {
        super(runNumber, tag, vendorDataFiles, expectedDataFiles);
        vendorInfo = PropertyReader.getVendorInfoFromPropertyFile(Profile.TR);
        this.runner = new RunnerTr();
        this.actualDataInitializer = new ActualDataInitializerTr();
        this.testDataInitializer = new TestDataInitializerTr();
        this.vendorFilePreparator = new VendorFilePreparatorTr();
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
