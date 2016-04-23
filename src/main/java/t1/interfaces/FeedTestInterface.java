package t1.interfaces;

import t1.TestData;
import t1.VendorInfo;

import java.io.File;
import java.util.List;

/**
 * Created by linux on 23.04.16.
 */
public interface FeedTestInterface extends SimpleCheckerTestInterface {
    public List<String> getVendorIds(TestData testData, VendorInfo vendorInfo);
    public List<File> createVendorFiles(TestData cs);
    public void uploadVendorFiles(List<File> files, VendorInfo vf);
    public void run(VendorInfo vf);

}
