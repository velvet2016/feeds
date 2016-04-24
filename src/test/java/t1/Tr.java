package t1;

import org.testng.annotations.Test;
import t1.abstractClasses.AbstractFeedTest;
import t1.actualDataInitializers.ActualDataInitializerTr;
import t1.runners.RunnerTr;
import t1.testDataInitializers.TestDataInitializerTr;
import t1.vendorFilePreparators.VendorFilePreparatorTr;

import java.util.List;

/**
 * Created by linux on 23.04.16.
 */
public class Tr extends AbstractFeedTest {

    public Tr(Integer runNumber, List<String> caseFileNames, String tag) {
        super(runNumber, caseFileNames, tag);
        vendorInfo = PropertyReader.getVendorInfoFromPropertyFile(Profile.TR);
        this.runner = new RunnerTr();
        this.actualDataInitializer = new ActualDataInitializerTr();
        this.testDataInitializer = new TestDataInitializerTr();
        this.vendorFilePreparator = new VendorFilePreparatorTr();
    }


    @Test
    public void test1() throws Exception {
        testLemTables();
    }

    @Test
    public void test2() throws Exception {
        testOraViews();
    }

}
