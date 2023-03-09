package presence.authentication;

import java.io.*;
import java.util.HashMap;

public abstract class AuthenticateFunction implements SignIn, Register {
    /**
     * @Description This class provides methods for managing and authenticating user accounts. It has a private field 'USER_HASHMAP'
     * that stores the registered users as key-value pairs, with the username as the key and the password as the value.
     *
     * @readUsersFromFile reads user information from a file and stores it in the 'USER_HASHMAP' map. The
     * `saveUsersToFile` method writes the user information from the 'USER_HASHMAP' map to a file.
     *
     * @userExists checks if a user with the given username exists in the 'USER_HASHMAP' map.
     *
     * @registerUser registers a new user with the given username and password. It takes an `AuthenticateUserRetrieval` object
     * as input parameter containing the user's information.
     *
     * @authenticateUser authenticates a user with the given username and password. It checks if the 'USER_HASHMAP'
     * map contains the given username, and if so, compares the stored password with the provided password.
     *
     * @intent By encapsulating user authentication and management functionality into a separate class, this promotes code
     * modularity and maintainability by separating this functionality from the rest of the program's logic.
     *
     *
     * @USER_HASHMAPS Private field to store the registered users
     */

    private static final HashMap<String, String> USER_HASHMAP = new HashMap<>();
    private final String filePath;
    public AuthenticateFunction(String userFilePath) {
        this.filePath = userFilePath;
    }

    /**

     Reads user information from a file and stores it in the users map.
     @param filePath the path to the file containing USER_HASHMAP information
     */
    public static void readUsersFromFile(String filePath) {
        File file = new File(filePath);
        if (file.length() == 0) {
            System.out.println("Database is empty. Please register.");
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String rowLineUserInformation;
            br.readLine();
            while ((rowLineUserInformation = br.readLine()) != null) {
                String[] sessionToken = rowLineUserInformation.split(",");
                USER_HASHMAP.put(sessionToken[0], sessionToken[1]);
            }
        } catch (IOException e) {
            System.out.println("FROM: readUsersFromFile MSG: Failed to read users from file. READS");
            e.printStackTrace();
        }
    }
    /**

     Writes user information from the USER_HASHMAP map to a file.
     @param filePath the path to the file to write USER_HASHMAP information to
     */
    @Override
    public void saveUsersToFile(String filePath) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, true))) {
            for (String username : USER_HASHMAP.keySet()) {
                bw.write(username + "," + USER_HASHMAP.get(username));
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("FROM: saveUsersToFile MSG: Failed to save users to file.");
            e.printStackTrace();
        }
    }
    /**

     Checks if a user with the given username exists in the USER_HASHMAP map.
     @param username the username to check for
     @return true if the user exists, false otherwise
     */
    @Override
    public boolean userExists(String username) {
        return USER_HASHMAP.containsKey(username);
    }
    /**

     Registers a new user with the given username and password.
     @param user an AuthenticateUserRetrieval object containing the user's information
     */
    @Override
    public void registerUser(AuthenticateProfessorRetrieve user) {
        USER_HASHMAP.put(user.getUsername(), user.getPassword());
    }
    /**

     Authenticates a user with the given username and password.
     @param username the username of the user to authenticate
     @param password the password of the user to authenticate
     @return true if the user is authenticated, false otherwise
     */
    @Override
    public boolean authenticateUser(String username, String password) {
        String storedPassword = USER_HASHMAP.get(username);
        return storedPassword != null && storedPassword.equals(password);
    }

    public static void createFileIfNotExists(String filePath) {
        File file = new File(filePath);
        if (!file.exists()) {
            try {
                file.createNewFile();
                System.out.println("File created: " + filePath);
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                    writer.write("ADMIN EMAIL,ADMIN PASSWORD\n");
                    writer.flush();
                }

            } catch (IOException e) {
                System.out.println("Failed to create file: " + filePath);
                e.printStackTrace();
            }
        }
    }
}


