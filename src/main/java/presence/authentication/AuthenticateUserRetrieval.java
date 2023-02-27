package um.presence.authentication;

/**
 The AuthenticateUserRetrieval class encapsulates the
 username and password for authenticating a user.
 */
public class AuthenticateUserRetrieval {
    /**
     * @username Private field to store the username
     * @password Private field to store the password
     */
    private final String username;
    private final String password;
    /**
     Constructs a new AuthenticateUserRetrieval object with the given username and password.
     @param username the username for the authentication request
     @param password the password for the authentication request
     */
    public AuthenticateUserRetrieval(String username, String password) {
        this.username = username;
        this.password = password;
    }
    /**

     Gets the username associated with this authentication request.
     @return the username for the authentication request
     */
    public String getUsername() {
        return username;
    }
    /**

     Gets the password associated with this authentication request.
     @return the password for the authentication request
     */
    public String getPassword() {
        return password;
    }
}

