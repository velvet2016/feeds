package feeds.interfaces;

import feeds.VendorData;
import feeds.VendorInfo;

import java.io.File;
import java.util.Map;

/**
 * Created by linux on 24.04.16.
 */
public interface VendorFilePreparatorInterface {
                    //path on Unix machine
    public Map<File,String> prepareVendorFiles(VendorInfo vendorInfo, Map<String,VendorData> typeToVendorData);
}
