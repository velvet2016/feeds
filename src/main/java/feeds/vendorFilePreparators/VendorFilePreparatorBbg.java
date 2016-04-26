package feeds.vendorFilePreparators;

import feeds.VendorData;
import feeds.VendorInfo;

import java.io.File;
import java.util.Map;

/**
 * Created by linux on 24.04.16.
 */
public  class VendorFilePreparatorBbg extends VendorFilePreparator {
    @Override
    public Map<File, String> prepareVendorFiles(VendorInfo vendorInfo, Map<String,VendorData> typeToVendorData) {
        logger.info("preparing BBG files...");
        return null;
    }
}
