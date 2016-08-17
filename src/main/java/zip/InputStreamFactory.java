package zip;

import java.io.InputStream;

public interface InputStreamFactory {
    InputStream getInputStreamFromFile(String fileName);
}