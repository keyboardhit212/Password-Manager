package passwordmanager.cli;

import passwordmanager.account.Account;
import passwordmanager.storagemanager.AccountStorageManager;
import passwordmanager.storagemanager.StorageManager;
import passwordmanager.utils.Screen;
import java.nio.file.NoSuchFileException;
import java.util.List;
import java.util.Scanner;

public class ViewEntry {

    private ViewEntry() {}

    public static void main() {
        Screen.clear();
        System.out.println(".....ENTRIES\n");
        Scanner console = new Scanner(System.in);
        try {
            StorageManager<Account> storageManager = new AccountStorageManager();
            List<Account> accounts = storageManager.getAll();
            System.out.printf("%-20s %-35s %-35s %-10s%n%n", "NAME", "USERNAME", "PASSWORD", "DATE ADDED");
            for (Account account : accounts) {
                formatDisplay(account);
            }
            System.out.print("\nPress Enter to continue");
            console.nextLine();
        } catch (NoSuchFileException e) {
            System.out.println("Error: Database files do not exist!");
        }
    }

    private static void formatDisplay(Account account) {
        System.out.printf("%-20s %-35s %-35s %-10s%n", account.getName(), account.getDecryptedUsername(), account.getDecryptedPassword(), account.getFormattedDate());
    }


}
