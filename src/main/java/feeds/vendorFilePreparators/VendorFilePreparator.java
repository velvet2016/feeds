package feeds.vendorFilePreparators;

import feeds.LoggedClass;
import feeds.VendorData;
import feeds.VendorInfo;
import feeds.interfaces.VendorFilePreparatorInterface;

import java.io.File;
import java.util.Map;

/**
 * Created by linux on 24.04.16.
 */
public abstract class VendorFilePreparator extends LoggedClass implements VendorFilePreparatorInterface {
    @Override
    public Map<File, String> prepareVendorFiles(VendorInfo vendorInfo, Map<String,VendorData> typeToVendorData) {
        return null;
    }
}
