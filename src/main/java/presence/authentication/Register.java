package presence.authentication;

interface Register {
    void saveUsersToFile(String filePath);

    void registerUser(AuthenticateProfessorRetrieve user);
}
