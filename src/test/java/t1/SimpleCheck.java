package t1;

import org.testng.annotations.*;
import t1.abstractClasses.AbstractTest;
import t1.actualDataInitializers.ActualDataInitializerSimpleCheck;
import t1.testDataInitializers.TestDataInitializerSimpleCheck;

import java.util.List;

import static org.testng.Assert.assertEquals;

/**
 * Created by linux on 23.04.16.
 */
@Listeners(TestClassesSorter.class)
public  class SimpleCheck extends AbstractTest {
    public SimpleCheck(Integer runNumber, List<String> caseFileName, String tag) {
        super(runNumber, caseFileName, tag);
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
