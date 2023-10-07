package passwordmanager.storagemanager;

import passwordmanager.account.Account;

import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class AccountStorageManager extends StorageManager<Account>{

    public AccountStorageManager() throws NoSuchFileException {
        super();
    }

    @Override
    public void save(Account entry) {
        try {
            fileManager.writeLine(entry.getWriteState());
            fileManager.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Account> getAll() {
        List<Account> list = new ArrayList<>();
        try {
            while (true) {
                String entry = fileManager.readLine();
                list.add(new Account(entry));
            }
        } catch (NoSuchElementException | IOException e) {
            //Exits the loop
        }
        return list;
    }
}
