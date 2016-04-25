package t1.abstractClasses;


import t1.*;
import t1.interfaces.FeedTestInterface;
import t1.interfaces.VendorFilePreparatorInterface;
import t1.runners.Runner;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Created by linux on 23.04.16.
 */
public abstract class AbstractFeedTest extends AbstractTest implements FeedTestInterface {

    public AbstractFeedTest(Integer runNumber, List<String> caseFileName, String tag) {
        super(runNumber, caseFileName, tag);
        this.vendorDataCaseFie = new File(caseFileName.get(1));
    }

    protected VendorInfo vendorInfo;
    protected List<String> vendorIds;
    protected VendorFilePreparatorInterface vendorFilePreparator;
    protected File vendorDataCaseFie;
    protected Runner runner;






    public List<String> getVendorIds(List<TestDataEntry> testData, VendorInfo vendorInfo) {
        return Arrays.asList("123");
    }

    public void uploadVendorFiles(Map<File, String> fileToPathMap, VendorInfo vf) {
        logger.info("uploading vendor files...");
        unixService.uploadFile();
    }


    protected void setUp() throws Exception {
        logger.info("\n"+this.getClass()+" setUp runNumber " +runNumber);
        VendorData vendorData = testDataInitializer.getVendorData(vendorDataCaseFie);
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
