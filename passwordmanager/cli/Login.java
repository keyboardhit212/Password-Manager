package passwordmanager.cli;

import passwordmanager.passwordmanager.PasswordManager;
import passwordmanager.utils.Screen;

import java.io.Console;
import java.io.IOException;

public class Login {

    private Login() {}

    public static void main(PasswordManager passwordManager) {
        Screen.clear();
        Console console = System.console();
        try {
            for (int i = 1; i <= 3; i++) {
                Banner.display();
                char[] password = console.readPassword("Enter Password: ");
                passwordManager.login(new String(password));
                if (passwordManager.isActive())
                    break;
                else {
                    System.out.println("\nINVALID PASSWORD!\n");
                    Screen.pause();
                    Screen.clear();
                }
            }
        } catch (IOException e) {
            System.out.println("Error: No system password found!");
        }
    }
}
