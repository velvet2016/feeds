package t1.interfaces;

import t1.VendorData;
import t1.VendorInfo;

import java.io.File;
import java.util.List;
import java.util.Map;

/**
 * Created by linux on 24.04.16.
 */
public interface VendorFilePreparatorInterface {
                    //path on Unix machine
    public Map<File,String> prepareVendorFiles(VendorInfo vendorInfo, VendorData vfd);
}
