package passwordmanager.passwordmanager;

import java.io.IOException;

public interface Loggable {

    boolean login(String password) throws IOException;
    void logout();
}
