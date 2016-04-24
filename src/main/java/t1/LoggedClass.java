package t1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by linux on 24.04.16.
 */
public class LoggedClass {
    protected Logger logger = LogManager.getLogger(this.getClass().getName());
}
