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

    public AbstractFeedTest(Integer runNumber, String caseFileName) {
        super(runNumber, caseFileName);
    }

    protected VendorInfo vendorInfo;
    protected List<String> vendorIds;



    public List<String> getVendorIds(TestData testData, VendorInfo vendorInfo) {
        return Arrays.asList("123");
    }

    public void uploadVendorFiles(List<File> files, VendorInfo vf) {
        System.out.println("uploading vendor files...");
        unixService.uploadFile();
    }


    public void verify(TestData exp, TestData act) {
        System.out.println("verifying...");
    }

    public void run(VendorInfo vf) {
        System.out.println("running "+vf.getName()+"...");
        System.out.println("waiting "+vf.getName()+"...");

    }

    protected void testLemTables() throws Exception {
        System.out.println("runNumber " +runNumber);
        TestData testData = initializeTestData();
        vendorIds = getVendorIds(testData, vendorInfo);
        List<File> vendorFiles = createVendorFiles(testData);
        uploadVendorFiles(vendorFiles, vendorInfo);
        run(vendorInfo);
        TestData actualData = getActualData(this.vendorIds);
        verify(testData,actualData);
    }


    protected void testOraViews() throws Exception {
        System.out.println("runNumber " +runNumber);
        System.out.println("Orator check..");
    }


}
