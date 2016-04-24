package t1.vendorFilePreparators;

import t1.VendorData;
import t1.VendorInfo;

import java.io.File;
import java.util.Map;

/**
 * Created by linux on 24.04.16.
 */
public  class VendorFilePreparatorTr extends VendorFilePreparator {
    @Override
    public Map<File, String> prepareVendorFiles(VendorInfo vendorInfo, VendorData vfd) {
        logger.info("preparing TR files...");
        return null;
    }
}
