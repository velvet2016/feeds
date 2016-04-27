package feeds;

import java.util.Map;

/**
 * Created by linux on 23.04.16.
 */
public class RunInfo {
    String className;
    Map<String,String> vendorFileTypesToFiles;
    Map<String,String> expectedFileTypesToFiles;
    String tag;
    PublishingInfo publishingInfo;

    public RunInfo(String className,
                   Map<String, String> vendorFileTypesToFiles,
                   Map<String, String> expectedFileTypesToFiles,
                   String tag,
                   PublishingInfo publishingInfo) {
        this.className = className;
        this.vendorFileTypesToFiles = vendorFileTypesToFiles;
        this.expectedFileTypesToFiles = expectedFileTypesToFiles;
        this.tag = tag;
        this.publishingInfo = publishingInfo;
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

    public PublishingInfo getPublishingInfo() {
        return publishingInfo;
    }
}
