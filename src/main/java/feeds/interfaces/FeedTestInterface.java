package feeds.interfaces;

import feeds.VendorInfo;

import java.io.File;
import java.util.Map;

/**
 * Created by linux on 23.04.16.
 */
public interface FeedTestInterface extends SimpleCheckerTestInterface {

    public void uploadVendorFiles(Map<File, String> fileToPathMap, VendorInfo vf);
}
