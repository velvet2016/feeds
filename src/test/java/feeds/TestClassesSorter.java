package feeds;

import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;
import feeds.interfaces.SimpleCheckerTestInterface;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by linux on 25.04.16.
 */
public class TestClassesSorter implements IMethodInterceptor {
    public List<IMethodInstance> intercept(List<IMethodInstance> list, ITestContext iTestContext) {
        Collections.sort(list, new Comparator<IMethodInstance>() {
            @Override
            public int compare(IMethodInstance o1, IMethodInstance o2) {
                SimpleCheckerTestInterface test1 = (SimpleCheckerTestInterface) o1.getInstance();
                SimpleCheckerTestInterface test2 = (SimpleCheckerTestInterface) o2.getInstance();
                return test1.gerRunNumber()-test2.gerRunNumber();
            }
        });
        return list;
    }
}
