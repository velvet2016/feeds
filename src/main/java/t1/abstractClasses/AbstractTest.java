package t1.abstractClasses;

import org.apache.logging.log4j.LogManager;

import org.apache.logging.log4j.Logger;
import t1.*;
import t1.interfaces.ActualDataInitializerInterface;
import t1.interfaces.SimpleCheckerTestInterface;
import t1.interfaces.TestDataInitializerInterface;
import t1.services.DbService;
import t1.services.FileService;
import t1.services.IdStorageService;
import t1.services.UnixService;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


/**
 * Created by linux on 23.04.16.
 */
public abstract class AbstractTest implements SimpleCheckerTestInterface {
    public AbstractTest(Integer runNumber, List<String> casesFileNames, String tag) {
        this.runNumber = runNumber;
        this.caseFileNames = casesFileNames;
        this.dbService = DbService.getInstance();
        this.fileService = FileService.getInstance();
        this.unixService = UnixService.getInstance();
        this.idStorageService = IdStorageService.getInstance();
        this.logger = LogManager.getLogger(this.getClass().getName());
        this.tag = tag;
        this.expectedCaseFie = new File(casesFileNames.get(0));

    }

    public int gerRunNumber() {
        return runNumber;
    }

    protected Logger logger;
    protected DbService dbService;
    protected FileService fileService;
    protected UnixService unixService;
    protected IdStorageService idStorageService;
    protected List<String> vendorIds;
    protected TestDataInitializerInterface testDataInitializer;
    protected ActualDataInitializerInterface actualDataInitializer;
    protected File expectedCaseFie;
    List<DataProviderInput> dataForDataProvider;


    protected List<String> caseFileNames;
    protected int runNumber;
    protected String tag;



    @Override
    public List<DataProviderInput> getDataForDataProvider(List<TestDataEntry> exp, List<TestDataEntry> act) {
            return new ArrayList<DataProviderInput>();
    }
    protected void setUp() throws Exception {
        logger.info("\n"+this.getClass()+" setUp runNumber " +runNumber);
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
