package t1.abstractClasses;


import t1.TestData;
import t1.interfaces.FeedTestInterface;
import t1.VendorInfo;

import java.io.File;
import java.util.Arrays;
import java.util.List;

/**
 * Created by linux on 23.04.16.
 */
public abstract class AbstractFeedTest extends AbstractTest implements FeedTestInterface {

    public AbstractFeedTest(Integer runNumber, List<String> caseFileName) {
        super(runNumber, caseFileName);
    }

    protected VendorInfo vendorInfo;
    protected List<String> vendorIds;



    public List<String> getVendorIds(TestData testData, VendorInfo vendorInfo) {
        return Arrays.asList("123");
    }

    public void uploadVendorFiles(List<File> files, VendorInfo vf) {
        logger.info("uploading vendor files...");
        unixService.uploadFile();
    }


    public void verify(TestData exp, TestData act) {
        logger.info("verifying...");
    }

    public void run(VendorInfo vf) {
        logger.info("running "+vf.getName()+"...");
        logger.info("waiting "+vf.getName()+"...");

    }

    protected void testLemTables() throws Exception {
        logger.info("runNumber " +runNumber);
        TestData testData = initializeTestData();
        vendorIds = getVendorIds(testData, vendorInfo);
        List<File> vendorFiles = createVendorFiles(testData);
        uploadVendorFiles(vendorFiles, vendorInfo);
        run(vendorInfo);
        TestData actualData = getActualData(this.vendorIds);
        verify(testData,actualData);
    }


    protected void testOraViews() throws Exception {
        logger.info("runNumber " +runNumber);
        logger.info("Orator check..");
    }


}
