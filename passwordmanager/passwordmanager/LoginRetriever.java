package passwordmanager.passwordmanager;

import passwordmanager.filemanager.FileManager;
import passwordmanager.filemanager.TextFile;
import passwordmanager.filemanager.TextFileManager;

import java.io.IOException;

public class LoginRetriever {

    private static LoginRetriever loginRetriever;

    private LoginRetriever() {}

    public static LoginRetriever getInstance() {
        if (loginRetriever == null)
            loginRetriever = new LoginRetriever();
        return loginRetriever;
    }

    public String getSystemPassword() throws IOException {
        FileManager fileManager = new TextFileManager(TextFile.LOGIN);
        return fileManager.readLine();
    }
}
