package t1;

import java.util.List;

/**
 * Created by linux on 23.04.16.
 */
public class RunInfo {
    String className;
    List<String> casesFileNames;

    public RunInfo(String className, List<String> casesFileNames) {
        this.className = className;
        this.casesFileNames = casesFileNames;
    }

    public String getClassName() {
        return className;
    }

    public List<String> getCasesFileNames() {
        return casesFileNames;
    }
}
