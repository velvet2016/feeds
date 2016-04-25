package t1;

import org.testng.annotations.*;
import t1.abstractClasses.AbstractFeedTest;
import t1.actualDataInitializers.ActualDataInitializerTr;
import t1.runners.RunnerTr;
import t1.testDataInitializers.TestDataInitializerTr;
import t1.vendorFilePreparators.VendorFilePreparatorTr;

import java.util.List;

import static org.testng.Assert.assertEquals;

/**
 * Created by linux on 23.04.16.
 */
@Listeners(TestClassesSorter.class)
public class Tr extends AbstractFeedTest {

    public Tr(Integer runNumber, List<String> caseFileNames, String tag) {
        super(runNumber, caseFileNames, tag);
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
