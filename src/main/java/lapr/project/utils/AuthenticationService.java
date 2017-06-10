package lapr.project.utils;

import java.io.*;
import lapr.project.model.User;

/**
 *
 * @author inesmartins
 */
public class AuthenticationService {

    private final static String USER_DATA_FILE_PATH = "userData.txt";
    private final static String userDataFieldDividerChar = "\t";

    private static User authenticatedUser;
    private static EncryptionService encryption;

    public AuthenticationService() {
        encryption = new EncryptionService();
    }

    /**
     * returns authenticated user data
     *
     * @return
     */
    public User getAuthenticatedUser() {
        return authenticatedUser;
    }

    /**
     * sets authenticated user
     *
     * @param user
     */
    public void setAuthenticatedUser(User user) {
        authenticatedUser = user;
    }

    /**
     * registers new user
     *
     * @param user
     * @return
     * @throws java.io.IOException
     */
    public boolean registerUser(User user) throws IOException {
        int userShift = encryption.generateRandomShift();
        String encryptedPassword = encryption.encryptWithCeaserCipher(user.getPassword(), userShift);
        user.setPassword(encryptedPassword);
        String userdata;
        userdata = buildUserDataString(user, userShift);
        return addUserInfoToUserDataFile(userdata);
    }

    /**
     * authenticates user
     *
     * @param usernameOrEmail
     * @param password
     * @return
     * @throws java.io.IOException
     */
    public boolean loginUser(String usernameOrEmail, String password) throws IOException {
        String[] savedUserData = getDecryptedUserData();
        if (savedUserData != null) {
            for (String userData : savedUserData) {
                String[] fields = userData.split(userDataFieldDividerChar);

                if (fields.length == 5) {
                    String storedUsernameField = fields[0];
                    String storedNameField = fields[1];
                    String storedEmailField = fields[2];
                    String storedPasswordField = fields[3];
                    String storedShiftValue = fields[4];
                    String storedUsername, storedName, storedEmail, storedPassword, storedShift;
                    if (storedUsernameField.contains("=") && 
                            storedNameField.contains("=") &&
                            storedEmailField.contains("=") &&
                            storedPasswordField.contains("=") &&
                            storedShiftValue.contains("=")) {

                        storedUsername = storedUsernameField.split("=")[1];
                        storedName = storedNameField.split("=")[1];
                        storedEmail = storedEmailField.split("=")[1];
                        storedPassword = storedPasswordField.split("=")[1];
                        storedShift = storedShiftValue.split("=")[1];

                        int intShift;
                        try {
                            intShift = Integer.parseInt(storedShift);
                        } catch (NumberFormatException e) {
                            System.out.println("Unable to parse user shift");
                            return false;
                        }
                        if (intShift > 0) {
                            String decryptedPassword = encryption.decryptWithCeaserCipher(storedPassword, intShift);
                            if (storedUsername.equals(usernameOrEmail) || storedEmail.equals(usernameOrEmail)) {
                                if (decryptedPassword.equals(password)) {
                                    User registeredUser = new User();
                                    registeredUser.setName(storedName);
                                    registeredUser.setUsername(storedUsername);
                                    registeredUser.setEmail(storedEmail);
                                    registeredUser.setPassword(decryptedPassword);
                                    setAuthenticatedUser(registeredUser);
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    /**
     * updates current user data in userData file
     *
     * @param currentUser
     * @return true if user data is successfully updated
     * @throws java.io.IOException
     */
    public boolean updateUserDataInFile(User currentUser) throws IOException {
        String[] savedUserData = getDecryptedUserData();
        if (savedUserData != null) {
            for (int i = 0; i < savedUserData.length; i++) {
                String[] fields = savedUserData[i].split(userDataFieldDividerChar);
                String storedUsernameField = fields[0];
                String storedNameField = fields[1];
                String storedEmailField = fields[2];
                String storedPasswordField = fields[3];
                String storedShiftValue = fields[4];
                String storedUsername = storedUsernameField.split("=")[1];
                String storedName = storedNameField.split("=")[1];
                String storedEmail = storedEmailField.split("=")[1];
                String storedPassword = storedPasswordField.split("=")[1];
                String storedShift = storedShiftValue.split("=")[1];
                int intShift;
                try {
                    intShift = Integer.parseInt(storedShift);
                } catch (NumberFormatException e) {
                    System.out.println("Unable to parse user shift");
                    return false;
                }
                if (intShift > 0) {
                    if (storedUsername.equals(currentUser.getUsername()) || storedEmail.equals(currentUser.getEmail())) {
                        User newUserData = new User();
                        // updates username
                        if (currentUser.getUsername() != null && !currentUser.getUsername().isEmpty()) {
                            newUserData.setUsername(currentUser.getUsername());
                        } else {
                            newUserData.setUsername(storedUsername);
                        }
                        // updates name
                        if (currentUser.getName() != null && !currentUser.getName().isEmpty()) {
                            newUserData.setName(currentUser.getName());
                        } else {
                            newUserData.setName(storedName);
                        }
                        // updates email
                        if (currentUser.getEmail() != null && !currentUser.getEmail().isEmpty()) {
                            newUserData.setEmail(currentUser.getEmail());
                        } else {
                            newUserData.setEmail(storedEmail);
                        }
                        // updates password
                        if (currentUser.getPassword() != null && !currentUser.getPassword().isEmpty()) {
                            newUserData.setPassword(encryption.encryptWithCeaserCipher(currentUser.getPassword(), intShift));
                        } else {
                            newUserData.setPassword(storedPassword);
                        }
                        String newUserDataString = buildUserDataString(newUserData, intShift);
                        savedUserData[i] = newUserDataString;
                        return encryption.writeDataToUserDataFile(savedUserData);
                    }
                }
            }
        }
        return false;
    }

    /**
     * adds user info to user data file
     *
     * @param userData
     * @return
     */
    private boolean addUserInfoToUserDataFile(String userData) throws IOException {
        String[] savedUserData;
        try {
            savedUserData = getDecryptedUserData();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return false;
        }
        if (savedUserData != null) {
            String[] fullUserData;
            if (savedUserData.length > 0) {
                int count = 0;
                fullUserData = new String[(savedUserData.length + 1)];
                for (String u : savedUserData) {
                    fullUserData[count] = u;
                    count++;
                }
                fullUserData[count] = userData;
            } else {
                fullUserData = new String[1];
                fullUserData[0] = userData;
            }
            try {
                return encryption.writeDataToUserDataFile(fullUserData);
            } catch (IOException e) {
                System.out.println(e.getMessage());
                return false;
            }
        }
        return false;
    }

    /**
     * @return decrypted data divided by user
     * @throws IOException
     */
    private String[] getDecryptedUserData() throws IOException {
        File userDataFile;
        userDataFile = new File(USER_DATA_FILE_PATH);
        if (userDataFile.exists()) {
            BufferedReader br;
            try {
                br = new BufferedReader(new FileReader(USER_DATA_FILE_PATH));
            } catch (IOException e) {
                System.out.println("Unable to write decrypted data to tmp file: " + e.getMessage());
                return null;
            }

            String line;
            StringBuilder inputString = new StringBuilder();
            while ((line = br.readLine()) != null) {
                inputString.append(line);
                inputString.append("\n");
            }

            String[] encryptedLines = inputString.toString().split("\n");
            String[] decryptedLines = new String[encryptedLines.length];
            int count = 0;
            for (String l : encryptedLines) {
                String decryptedLine = encryption.decryptLineWithRailFenceTranspositionCipher(l);
                decryptedLines[count] = decryptedLine;
                count++;
            }
            return decryptedLines;
        } else if (userDataFile.createNewFile()) {
            return new String[0];
        }
        return null;
    }

    private String buildUserDataString(User user, int shift) {
        return "username=" + user.getUsername()
                + userDataFieldDividerChar + "name=" + user.getName()
                + userDataFieldDividerChar + "email=" + user.getEmail()
                + userDataFieldDividerChar + "password=" + user.getPassword()
                + userDataFieldDividerChar + "shift=" + String.valueOf(shift) + "\n";
    }

}
