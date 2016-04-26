package feeds;

import java.io.File;
import java.net.URL;

/**
 * Created by linux on 24.04.16.
 */
public class TextReader {

    public  File getFile(String path) {
        URL url = TextReader.class.getClassLoader().getResource(path);
        return new File(url.getPath());
    }
}
