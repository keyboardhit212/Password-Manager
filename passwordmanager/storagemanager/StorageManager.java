package passwordmanager.storagemanager;

import passwordmanager.account.Account;
import passwordmanager.account.Storable;
import passwordmanager.filemanager.FileManager;
import passwordmanager.filemanager.TextFile;
import passwordmanager.filemanager.TextFileManager;


import java.nio.file.NoSuchFileException;
import java.util.List;

public abstract class StorageManager<T extends Storable> {

    FileManager fileManager;

    public StorageManager() throws NoSuchFileException {
        try {
            fileManager = new TextFileManager(TextFile.ACCOUNT);
        } catch (Exception e) {
            throw new NoSuchFileException("There is a problem with the file. It may not exist");
        }
    }
    public abstract void save(T entry);
    public abstract List<T> getAll();


}
