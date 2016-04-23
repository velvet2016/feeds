package t1.abstractClasses;

import org.apache.logging.log4j.LogManager;

import org.apache.logging.log4j.Logger;
import t1.interfaces.SimpleCheckerTestInterface;
import t1.services.DbService;
import t1.services.FileService;
import t1.services.UnixService;

import java.util.List;



/**
 * Created by linux on 23.04.16.
 */
public abstract class AbstractTest implements SimpleCheckerTestInterface {
    public AbstractTest(Integer runNumber, List<String> casesFileNames) {
        this.runNumber = runNumber;
        this.caseFileName = casesFileNames;
        this.dbService = DbService.getInstance();
        this.fileService = FileService.getInstance();
        this.unixService = UnixService.getInstance();
        this.logger = LogManager.getLogger(this.getClass().getName());

    }

    protected Logger logger;
    protected DbService dbService;
    protected FileService fileService;
    protected UnixService unixService;

    protected List<String> caseFileName;
    protected int runNumber;

}
