package passwordmanager.utils;

import passwordmanager.filemanager.TextFile;

import java.io.File;
import java.io.IOException;

public class Database {

    private Database() {}

    public static void initialize() {
        try {
            new File(TextFile.ACCOUNT.getFilename()).createNewFile();
        } catch (SecurityException e) {
            System.out.println("Error: OS prohibits creation of file");
        } catch (IOException e) {
            System.out.println("Error: Error initializing database");
        }
    }

    public static boolean isInitialized() {
        return new File(TextFile.ACCOUNT.getFilename()).exists();
    }
}
