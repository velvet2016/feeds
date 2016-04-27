package feeds;

import java.util.Map;

/**
 * Created by linux on 23.04.16.
 */
public class VendorInfo {
    String staticDataCode;
    String  alacraMappingCode;
    String alacraMappingName;
    Map<String, String> fileTypesToUnixPaths;

    public VendorInfo(String staticDataCode, String alacraMappingCode, String alacraMappingName, Map<String, String> fileTypesToUnixPaths) {
        this.staticDataCode = staticDataCode;
        this.alacraMappingCode = alacraMappingCode;
        this.alacraMappingName = alacraMappingName;
        this.fileTypesToUnixPaths = fileTypesToUnixPaths;
    }

    public String getStaticDataCode() {
        return staticDataCode;
    }

    public String getAlacraMappingCode() {
        return alacraMappingCode;
    }

    public String getAlacraMappingName() {
        return alacraMappingName;
    }

    public Map<String, String> getFileTypesToUnixPaths() {
        return fileTypesToUnixPaths;
    }
}
