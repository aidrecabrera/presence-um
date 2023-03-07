package presence.authentication;

import presence.API_Database;

import java.util.HashMap;

public interface SignIn {
    API_Database importData = new API_Database();
    HashMap<String, String> USER_HASHMAP = new HashMap<>();
    void readUsersFromFile(String filePath);

    boolean userExists(String username);

    boolean authenticateUser(String username, String password);
}
