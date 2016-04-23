package t1.abstractClasses;

import t1.interfaces.SimpleCheckerTestInterface;
import t1.services.DbService;
import t1.services.FileService;
import t1.services.UnixService;

/**
 * Created by linux on 23.04.16.
 */
public abstract class AbstractTest implements SimpleCheckerTestInterface {
    public AbstractTest(Integer runNumber, String caseFileName) {
        this.runNumber = runNumber;
        this.caseFileName = caseFileName;
        this.dbService = DbService.getInstance();
        this.fileService = FileService.getInstance();
        this.unixService = UnixService.getInstance();
    }
    protected DbService dbService;
    protected FileService fileService;
    protected UnixService unixService;

    protected String caseFileName;
    protected int runNumber;

}
