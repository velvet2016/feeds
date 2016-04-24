package t1.interfaces;

import t1.TestDataEntry;
import t1.VendorData;
import t1.VendorInfo;

import java.io.File;
import java.util.List;
import java.util.Map;

/**
 * Created by linux on 23.04.16.
 */
public interface FeedTestInterface extends SimpleCheckerTestInterface {

    public void uploadVendorFiles(Map<File, String> fileToPathMap, VendorInfo vf);
}
