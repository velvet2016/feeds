package feeds.abstractClasses;


import feeds.*;
import feeds.interfaces.ActualDataInitializerInterface;
import feeds.interfaces.SimpleCheckerTestInterface;
import feeds.interfaces.TestDataInitializerInterface;
import feeds.services.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * Created by linux on 23.04.16.
 */
public abstract class AbstractTest extends LoggedClass implements SimpleCheckerTestInterface {
    public AbstractTest(Integer runNumber, String tag, Map<String, String> vendorDataFiles, Map<String, String> expectedDataFiles, Boolean isPublishingByDirectUpdateNeeded) {
        this.runNumber = runNumber;
        this.vendorDataFiles = vendorDataFiles;
        this.expectedDataFiles = expectedDataFiles;
        this.dbService = DbServiceSpring.getInstance();
        this.fileService = FileService.getInstance();
        this.unixService = UnixService.getInstance();
        this.idStorageService = IdStorageService.getInstance();
        this.tag = tag;
        this.publishingInfo = isPublishingByDirectUpdateNeeded;


    }

    public int gerRunNumber() {
        return runNumber;
    }


    protected DbServiceSpring dbService;
    protected FileService fileService;
    protected UnixService unixService;
    protected IdStorageService idStorageService;
    protected List<String> vendorIds;
    protected TestDataInitializerInterface testDataInitializer;
    protected ActualDataInitializerInterface actualDataInitializer;
    protected File expectedCaseFie;
    protected List<DataProviderInput> dataForDataProvider;
    protected boolean publishingInfo;


    protected Map<String, String> vendorDataFiles;
    protected Map<String, String> expectedDataFiles;
    protected int runNumber;
    protected String tag;



    @Override
    public List<DataProviderInput> getDataForDataProvider(List<TestDataEntry> exp, List<TestDataEntry> act) {
            return new ArrayList<DataProviderInput>();
    }
    protected void setUp() throws Exception {
        System.out.println("\n");
        logger.info(this.getClass()+" setUp runNumber " +runNumber);
        List<TestDataEntry> expected = testDataInitializer.getExpectedData(expectedCaseFie);
        List<TestDataEntry> actual = actualDataInitializer.getActualData(this.vendorIds);
        dataForDataProvider = getDataForDataProvider(expected,actual);
    }
    protected void check(){
        logger.info(this.getClass()+" setUp runNumber " +runNumber);
    }
    protected Object[][] getDataProvider(){
        return new Object[][]{
                {1,1},
                {1,1}
        };
    }
}
