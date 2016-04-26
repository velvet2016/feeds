package feeds.interfaces;

import feeds.TestDataEntry;

import java.util.List;

/**
 * Created by linux on 24.04.16.
 */
public interface ActualDataInitializerInterface {
   public List<TestDataEntry> getActualData(List<String> vendorIds);
}
