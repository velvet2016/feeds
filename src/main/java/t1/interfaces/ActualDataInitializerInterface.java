package t1.interfaces;

import t1.TestDataEntry;

import java.util.List;

/**
 * Created by linux on 24.04.16.
 */
public interface ActualDataInitializerInterface {
   public List<TestDataEntry> getActualData(List<String> vendorIds);
}
