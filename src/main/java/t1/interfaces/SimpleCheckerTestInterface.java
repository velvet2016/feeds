package t1.interfaces;

import t1.TestData;

import java.util.List;

/**
 * Created by linux on 23.04.16.
 */
public interface SimpleCheckerTestInterface {
    public TestData initializeTestData();
    public TestData getActualData(List<String> vendorIds);
    public void verify(TestData exp, TestData act);

}
