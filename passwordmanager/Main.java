package passwordmanager;

import passwordmanager.cli.Home;
import passwordmanager.cli.Login;
import passwordmanager.passwordmanager.PasswordManager;
import passwordmanager.utils.Database;

import java.nio.file.NoSuchFileException;

public class Main {

    public static void main(String[] args) {
        checkDatabaseInitialization();
        PasswordManager passwordManager = null;
        try {
            passwordManager = PasswordManager.getInstance();
            Login.main(passwordManager);
        } catch (NoSuchFileException e) {
            System.out.println("No configuration files provided! Please provide the account.txt and login.txt files!");
        }

        if (passwordManager.isActive())
            Home.main(args);
        else
            System.exit(0);
    }

    private static void checkDatabaseInitialization() {
        if (!Database.isInitialized()) {
            Database.initialize();
        }

    }


}
