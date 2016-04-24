package t1;

import org.testng.annotations.Test;
import t1.abstractClasses.AbstractFeedTest;
import t1.actualDataInitializers.ActualDataInitializerBbg;
import t1.runners.RunnerTr;
import t1.testDataInitializers.TestDataInitializerBbg;
import t1.vendorFilePreparators.VendorFilePreparatorBbg;


import java.util.List;

/**
 * Created by linux on 23.04.16.
 */
public class Bbg extends AbstractFeedTest {
    public Bbg(Integer runNumber, List<String> caseFileName, String tag) {
        super(runNumber, caseFileName, tag);
        this.vendorInfo = PropertyReader.getVendorInfoFromPropertyFile(Profile.BBG);
        this.runner = new RunnerTr();
        this.actualDataInitializer = new ActualDataInitializerBbg();
        this.testDataInitializer = new TestDataInitializerBbg();
        this.vendorFilePreparator = new VendorFilePreparatorBbg();
    }



    @Test
    public void test1() throws Exception {
        testLemTables();
    }

    @Test(dependsOnMethods = "test1")
    public void test2() throws Exception {
        testOraViews();
    }
}
