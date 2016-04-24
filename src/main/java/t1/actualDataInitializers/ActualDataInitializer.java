package t1.actualDataInitializers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import t1.LoggedClass;
import t1.TestDataEntry;
import t1.interfaces.ActualDataInitializerInterface;

import java.util.List;

/**
 * Created by linux on 24.04.16.
 */
public abstract class ActualDataInitializer extends LoggedClass implements ActualDataInitializerInterface{

    @Override
    public List<TestDataEntry> getActualData(List<String> vendorIds) {

        return null;
    }
}
