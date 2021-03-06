package feeds.abstractClasses;


import feeds.*;
import feeds.interfaces.FeedTestInterface;
import feeds.interfaces.VendorFilePreparatorInterface;
import feeds.runners.Runner;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Created by linux on 23.04.16.
 */
public abstract class AbstractFeedTest extends AbstractTest implements FeedTestInterface {

    public AbstractFeedTest(Integer runNumber, String tag, Map<String, String> vendorDataFiles, Map<String, String> expectedDataFiles, Boolean isPublishingByDirectUpdateNeeded) {
        super(runNumber, tag, vendorDataFiles, expectedDataFiles, isPublishingByDirectUpdateNeeded);
    }

    protected VendorInfo vendorInfo;
    protected List<String> vendorIds;
    protected VendorFilePreparatorInterface vendorFilePreparator;
    protected Runner runner;






    public List<String> getVendorIds(List<TestDataEntry> testData, VendorInfo vendorInfo) {
        return Arrays.asList("123");
    }

    public void uploadVendorFiles(Map<File, String> fileToPathMap, VendorInfo vf) {
        logger.info("uploading vendor files...");
        unixService.uploadFile();
    }


    protected void setUp() throws Exception {
        System.out.println("\n");
        logger.info(this.getClass()+" setUp runNumber " +runNumber);
        Map<String,VendorData> vendorData = testDataInitializer.getVendorData(vendorDataFiles);
        Map<File, String> vendorFileToPathMap = vendorFilePreparator.prepareVendorFiles(vendorInfo, vendorData);
        List<TestDataEntry> expected = testDataInitializer.getExpectedData(expectedCaseFie);

        vendorIds = getVendorIds(expected, vendorInfo);
        uploadVendorFiles(vendorFileToPathMap, vendorInfo);
        runner.run();
        List<TestDataEntry> actual = actualDataInitializer.getActualData(this.vendorIds);
        getDataForDataProvider(expected,actual);
    }


    protected void testOraViews() throws Exception {
        logger.info(this.getClass()+" testOraViews runNumber " +runNumber);
       // logger.info("Orator check..");
    }


}
