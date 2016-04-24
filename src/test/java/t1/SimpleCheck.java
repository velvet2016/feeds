package t1;

import org.testng.annotations.Test;
import t1.abstractClasses.AbstractTest;
import t1.actualDataInitializers.ActualDataInitializerSimpleCheck;
import t1.testDataInitializers.TestDataInitializerSimpleCheck;

import java.util.List;

/**
 * Created by linux on 23.04.16.
 */
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

    @Test
    public void test1() throws Exception {
        testLemTables();
    }
}
