package passwordmanager.passwordmanager;

import passwordmanager.hash.MD5;
import passwordmanager.storagemanager.AccountStorageManager;
import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.security.NoSuchAlgorithmException;

public class PasswordManager implements Loggable {

    private static PasswordManager passwordManager;

    private boolean isLoggedIn = false;
    private AccountStorageManager accountStorageManager;

    public static PasswordManager getInstance() throws NoSuchFileException {
        if (passwordManager == null)
            passwordManager = new PasswordManager();
        return passwordManager;
    }

    private PasswordManager() throws NoSuchFileException {
        accountStorageManager = new AccountStorageManager();
    }

    public boolean login(String password) throws IOException {
        LoginRetriever systemLogin = LoginRetriever.getInstance();
        String hashedPassword = null;
        try {
            hashedPassword = new MD5(password).getHash();
        } catch (NoSuchAlgorithmException e) {
            System.out.println("Error with MD5 Hashing");
            return false;
        }
        if (hashedPassword.equals(systemLogin.getSystemPassword())) {
            isLoggedIn = true;
            return true;
        }
        return false;
    }

    public void logout() {
        isLoggedIn = false;
        System.exit(0);
    }

    public boolean isActive() {
        return isLoggedIn;
    }

}
