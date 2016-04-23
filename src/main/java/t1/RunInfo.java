package t1;

/**
 * Created by linux on 23.04.16.
 */
public class RunInfo {
    String className;
    String casesFileName;

    public RunInfo(String className, String casesFileName) {
        this.className = className;
        this.casesFileName = casesFileName;
    }

    public String getClassName() {
        return className;
    }

    public String getCasesFileName() {
        return casesFileName;
    }
}
