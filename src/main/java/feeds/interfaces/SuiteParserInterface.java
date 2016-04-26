package feeds.interfaces;

import feeds.RunInfo;

import java.util.List;

/**
 * Created by linux on 25.04.16.
 */
public interface SuiteParserInterface {
    List<RunInfo> parse(String path);
}
