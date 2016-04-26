package feeds;

/**
 * Created by linux on 23.04.16.
 */
public enum Profile {
    TR("tr.properties") ,
    BBG("bbg.properties");

    Profile(String propertyFileName) {
        this.propertyFileName = propertyFileName;
    }
    String propertyFileName;

    public String getPropertyFileName() {
        return propertyFileName;
    }

}
