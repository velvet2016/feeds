package t1;

/**
 * Created by linux on 24.04.16.
 */
public  class TestDataEntry<T> {
    public TestDataEntry(String testId) {
        this.testId = testId;
    }

    public TestDataEntry(String testId, T dataUnit) {
        this.testId = testId;
        this.dataUnit = dataUnit;
    }

    private String testId;
    private T dataUnit;


    public String getTestId() {
        return testId;
    }

    public T getDataUnit() {
        return dataUnit;
    }
    public void setDataUnit(T dataUnit) {
        this.dataUnit = dataUnit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TestDataEntry testDataEntry = (TestDataEntry) o;

        return testId != null ? testId.equals(testDataEntry.testId) : testDataEntry.testId == null;

    }

    @Override
    public int hashCode() {
        return testId != null ? testId.hashCode() : 0;
    }
}
