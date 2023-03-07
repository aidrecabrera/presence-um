package presence.authentication;

import presence.Database;

import java.util.HashMap;

public interface SignIn {
    Database importData = new Database();
    HashMap<String, String> USER_HASHMAP = new HashMap<>();
    void readUsersFromFile(String filePath);

    boolean userExists(String username);

    boolean authenticateUser(String username, String password);
}
