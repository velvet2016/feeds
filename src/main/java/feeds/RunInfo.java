package feeds;

import java.util.Map;

/**
 * Created by linux on 23.04.16.
 */
public class RunInfo {
    String className;
    Map<String,String> vendorDataFiles;
    Map<String,String> expectedDataFiles;
    String tag;

    public RunInfo(String className, Map<String,String> vendorDataFiles, Map<String,String> expectedDataFiles, String tag) {
        this.className = className;
        this.vendorDataFiles  = vendorDataFiles;
        this.expectedDataFiles  = expectedDataFiles;
        this.tag = tag;
    }

    public String getClassName() {
        return className;
    }

    public Map<String,String> getVendorDataFiles() {
        return  vendorDataFiles;
    }

    public String getTag() {
        return tag;
    }
}
