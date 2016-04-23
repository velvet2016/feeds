package t1;

import org.testng.annotations.Test;
import t1.abstractClasses.AbstractFeedTest;

import java.io.File;
import java.util.Arrays;
import java.util.List;

/**
 * Created by linux on 23.04.16.
 */
public class Tr extends AbstractFeedTest {

    public Tr(Integer runNumber, String caseFileName) {
        super(runNumber, caseFileName);
        vendorInfo = PropertyReader.getVendorInfoFromPropertyFile(Profile.TR);
    }

    public TestData initializeTestData() {
        System.out.println("loading TR test data...");
        return new TestData();
    }

    public List<File> createVendorFiles(TestData cs) {
        System.out.println("creating TR vendorfile...");
        return  Arrays.asList(new File("TR"));
    }


    public TestData getActualData(List<String> vendorIds) {
        System.out.println("getting actual TR data...");
        return new TestData();
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
