package t1;

import org.testng.annotations.Test;
import t1.abstractClasses.AbstractFeedTest;

import java.io.File;
import java.util.Arrays;
import java.util.List;

/**
 * Created by linux on 23.04.16.
 */
public class Bbg extends AbstractFeedTest {
    public Bbg(Integer runNumber, List<String> caseFileName) {
        super(runNumber, caseFileName);
        vendorInfo = PropertyReader.getVendorInfoFromPropertyFile(Profile.BBG);
    }

    public TestData initializeTestData() {
        logger.info("loading BBG test data...");
        return new TestData();
    }

    public List<File> createVendorFiles(TestData cs) {
        logger.info("creating BBG vendor file...");
        fileService.writingFile();
        return  Arrays.asList(new File("BBG"));
    }

    public TestData getActualData(List<String> vendorIds) {
        logger.info("getting actual BBG data...");
        dbService.queryDb();
        return new TestData();
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
