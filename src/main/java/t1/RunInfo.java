package t1;

import java.util.List;

/**
 * Created by linux on 23.04.16.
 */
public class RunInfo {
    String className;
    List<String> casesFileNames;
    String tag;

    public RunInfo(String className, List<String> casesFileNames, String tag) {
        this.className = className;
        this.casesFileNames = casesFileNames;
        this.tag = tag;
    }

    public String getClassName() {
        return className;
    }

    public List<String> getCasesFileNames() {
        return casesFileNames;
    }

    public String getTag() {
        return tag;
    }
}
