package passwordmanager.filemanager;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TextFileManager implements FileManager {

    public final static String LOGIN_FILE = "login.txt";
    public final static String ACCOUNT_FILE = "account.txt";
    private String filename;
    private Scanner reader;
    private FileWriter writer;

    public TextFileManager(TextFile storageFile) throws IOException {
        this.filename = storageFile.getFilename();
        this.reader = new Scanner(new File(this.filename));
        this.writer = new FileWriter(this.filename, true);
    }

    @Override
    public void writeLine(String text) throws IOException {
        writer.write(text + "\n");
    }

    @Override
    public String readLine() {
        return reader.nextLine();
    }

    public void close() {
        try {
            this.writer.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
