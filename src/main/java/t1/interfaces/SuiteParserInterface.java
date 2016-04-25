package t1.interfaces;

import t1.RunInfo;

import java.io.InputStream;
import java.util.List;

/**
 * Created by linux on 25.04.16.
 */
public interface SuiteParserInterface {
    List<RunInfo> parse(String path);
}
