package passwordmanager.filemanager;

import java.io.IOException;
import java.util.NoSuchElementException;

public interface FileManager {

    void writeLine(String text) throws IOException;
    String readLine() throws IOException, NoSuchElementException, IllegalStateException;
    void close();
}
