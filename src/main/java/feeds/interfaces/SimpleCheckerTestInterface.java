package feeds.interfaces;

import feeds.DataProviderInput;
import feeds.TestDataEntry;
import feeds.VendorInfo;

import java.util.List;

/**
 * Created by linux on 23.04.16.
 */
public interface SimpleCheckerTestInterface  {
    public List<DataProviderInput> getDataForDataProvider(List<TestDataEntry> exp, List<TestDataEntry> act);
    public List<String> getVendorIds(List<TestDataEntry> testData, VendorInfo vendorInfo);
    public int gerRunNumber();
}
