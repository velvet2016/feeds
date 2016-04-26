package feeds.actualDataInitializers;

import feeds.LoggedClass;
import feeds.TestDataEntry;
import feeds.interfaces.ActualDataInitializerInterface;

import java.util.List;

/**
 * Created by linux on 24.04.16.
 */
public abstract class ActualDataInitializer extends LoggedClass implements ActualDataInitializerInterface{

    @Override
    public List<TestDataEntry> getActualData(List<String> vendorIds) {
        logger.info("getting Actual Data...");
        return null;
    }
}
