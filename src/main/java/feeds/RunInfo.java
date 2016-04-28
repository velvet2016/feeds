package feeds;

import java.util.Map;

/**
 * Created by linux on 23.04.16.
 */
public class RunInfo {
    private String className;
    private Map<String,String> vendorFileTypesToFiles;
    private Map<String,String> expectedFileTypesToFiles;
    private String tag;
    private boolean isPublishingByDirectUpdateNeeded;

    public RunInfo(String className,
                   Map<String, String> vendorFileTypesToFiles,
                   Map<String, String> expectedFileTypesToFiles,
                   String tag,
                   boolean isPublishingByDirectUpdateNeeded) {
        this.className = className;
        this.vendorFileTypesToFiles = vendorFileTypesToFiles;
        this.expectedFileTypesToFiles = expectedFileTypesToFiles;
        this.tag = tag;
        this.isPublishingByDirectUpdateNeeded = isPublishingByDirectUpdateNeeded;
    }


    public String getClassName() {
        return className;
    }

    public Map<String,String> getVendorFileTypesToFiles() {
        return vendorFileTypesToFiles;
    }

    public String getTag() {
        return tag;
    }

    public Map<String, String> getExpectedFileTypesToFiles() {
        return expectedFileTypesToFiles;
    }

    public boolean isPublishingByDirectUpdateNeeded() {
        return isPublishingByDirectUpdateNeeded;
    }
}
