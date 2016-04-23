package t1;

import t1.abstractClasses.AbstractTest;

import java.util.List;

/**
 * Created by linux on 23.04.16.
 */
public  class SimpleCheck extends AbstractTest {
    public SimpleCheck(Integer runNumber, List<String> caseFileName) {
        super(runNumber, caseFileName);
    }

    @Override
    public TestData initializeTestData() {
        return null;
    }

    @Override
    public TestData getActualData(List<String> vendorIds) {
        return null;
    }

    @Override
    public void verify(TestData exp, TestData act) {

    }
}
