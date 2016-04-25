package t1;

import org.testng.annotations.*;
import t1.abstractClasses.AbstractFeedTest;
import t1.actualDataInitializers.ActualDataInitializerBbg;
import t1.runners.RunnerTr;
import t1.testDataInitializers.TestDataInitializerBbg;
import t1.vendorFilePreparators.VendorFilePreparatorBbg;


import java.util.List;

import static org.testng.Assert.assertEquals;

/**
 * Created by linux on 23.04.16.
 */
@Listeners(TestClassesSorter.class)
public class Bbg extends AbstractFeedTest {
    public Bbg(Integer runNumber, List<String> caseFileName, String tag) {
        super(runNumber, caseFileName, tag);
        this.vendorInfo = PropertyReader.getVendorInfoFromPropertyFile(Profile.BBG);
        this.runner = new RunnerTr();
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
