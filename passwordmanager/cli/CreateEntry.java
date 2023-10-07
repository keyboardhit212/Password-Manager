package passwordmanager.cli;

import passwordmanager.account.Account;
import passwordmanager.storagemanager.AccountStorageManager;
import passwordmanager.storagemanager.StorageManager;
import passwordmanager.utils.Screen;
import java.io.Console;
import java.nio.file.NoSuchFileException;
import java.util.Scanner;

public class CreateEntry {

    private CreateEntry() {}

    public static void main() {
        Screen.clear();
        System.out.println(".....CREATE ENTRY\n");
        try {
            StorageManager<Account> storageManager = new AccountStorageManager();
            Account entry = inputEntry();
            storageManager.save(entry);
            System.out.println("\nSUCCESSFULLY SAVED!");
            Screen.pause();
        } catch (NoSuchFileException e) {
            System.out.println("Error: Database files do not exist!");
        }
    }

    private static Account inputEntry() {
        Scanner console = new Scanner(System.in);
        Console passwordConsole = System.console();
        System.out.print("ACCOUNT NAME: ");
        String accountName = console.nextLine();
        System.out.print("USERNAME: ");
        String accountUsername = console.nextLine();
        String accountPassword = "";
        while (true) {
            accountPassword = String.valueOf(passwordConsole.readPassword("ACCOUNT PASSWORD: "));
            if (confirmPassword(accountPassword))
                break;
            else
                System.out.println("Password does not match or empty");
        }
        return new Account(accountName, accountUsername, accountPassword);
    }

    private static boolean confirmPassword(String password) {
        Console passwordConsole = System.console();
        String passwordToMatch = String.valueOf(passwordConsole.readPassword("CONFIRM PASSWORD: "));
        return password.equals(passwordToMatch) && !password.isEmpty() && !passwordToMatch.isEmpty();
    }
}
