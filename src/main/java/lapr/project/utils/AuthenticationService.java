package lapr.project.utils;

import java.io.*;
import java.util.concurrent.ThreadLocalRandom;
import lapr.project.model.User;

/**
 *
 * @author inesmartins
 */
public class AuthenticationService {

    private final static String USER_DATA_FILE_PATH = "userData.txt";
    private static User authenticatedUser;

    /**
     * registers new user
     *
     * @param user
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static boolean registerUser(User user)
            throws FileNotFoundException, IOException {

        int userShift = generateRandomShift();
        String encryptedPassword = encryptWithCeaserCypher(user.getPassword(), userShift);
        user.setPassword(encryptedPassword);
        String userdata;
        userdata = buildUserDataString(user, userShift);

        File file = new File(USER_DATA_FILE_PATH);
        if ((file.exists() && !file.isDirectory()) || (!file.exists() && file.createNewFile())) {
            try (FileWriter fw = new FileWriter(USER_DATA_FILE_PATH, true)) {
                fw.write(userdata);
                fw.close();
            } catch (Exception e) {
                System.out.println("Unable to write user info to file");
                return false;
            }
        }
        return true;
    }

    /**
     * authenticates user
     *
     * @param usernameOrEmail
     * @param password
     * @return
     * @throws java.io.IOException
     */
    public static boolean loginUser(String usernameOrEmail, String password) throws IOException {
        try (BufferedReader file = new BufferedReader(new FileReader(USER_DATA_FILE_PATH))) {
            String line;
            StringBuilder sb = new StringBuilder();
            while((line = file.readLine()) != null) {
                sb.append(line);
                sb.append("\n");
            }
            String[] lines = sb.toString().split("\n");
            for (String userData : lines) {
                String[] fields = userData.split(";");
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
                    String decryptedPassword = decryptWithCeaserCypher(storedPassword, intShift);
                    if (storedUsername.equals(usernameOrEmail) || storedEmail.equals(usernameOrEmail)) {
                        if (decryptedPassword.equals(password)) {
                            User registeredUser = new User();
                            registeredUser.setName(storedName);
                            registeredUser.setUsername(storedUsername);
                            registeredUser.setEmail(storedEmail);
                            registeredUser.setPassword(decryptedPassword);
                            setAuthenticatedUser(registeredUser);
                            file.close();
                            return true;
                        }
                    }
                }
            }
            file.close();
            return false;
        } catch (IOException e) {
            System.out.println("Unable to read " + USER_DATA_FILE_PATH + " file");
            return false;
        }
    }

    /**
     * updates current user data in userData file
     *
     * @param currentUser
     * @return true if user data is successfully updated
     * @throws java.io.IOException
     */
    public static boolean updateUserDataInFile(User currentUser) throws IOException {
        try (BufferedReader file = new BufferedReader(new FileReader(USER_DATA_FILE_PATH))) {
            String line;
            StringBuilder inputString = new StringBuilder();
            while((line = file.readLine()) != null) {
                inputString.append(line);
                inputString.append("\n");
            }
            String[] lines = inputString.toString().split("\n");
            for (String userData : lines) {
                String[] fields = userData.split(";");
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
                        }
                        else {
                            newUserData.setUsername(storedUsername);
                        }
                        // updates name
                        if (currentUser.getName() != null && !currentUser.getName().isEmpty()) {
                            newUserData.setName(currentUser.getName());
                        }
                        else {
                            newUserData.setName(storedName);
                        }
                        // updates email
                        if (currentUser.getEmail() != null && !currentUser.getEmail().isEmpty()) {
                            newUserData.setEmail(currentUser.getEmail());
                        }
                        else {
                            newUserData.setEmail(storedEmail);
                        }
                        // updates password
                        if (currentUser.getPassword() != null && !currentUser.getPassword().isEmpty()) {
                            newUserData.setPassword(encryptWithCeaserCypher(currentUser.getPassword(), intShift));
                        }
                        else {
                            newUserData.setPassword(storedPassword);
                        }
                        String newUserDataString = buildUserDataString(newUserData, intShift);
                        // TODO: COMPLETE
                    }
                }
            }
            file.close();
            return false;
        } catch (IOException e) {
            System.out.println("Unable to read " + USER_DATA_FILE_PATH + " file");
            return false;
        }
    }

    /**
     * returns authenticated user data
     *
     * @return
     */
    public static User getAuthenticatedUser() {
        return authenticatedUser;
    }

    /**
     * sets authenticated user
     *
     * @param user
     */
    public static void setAuthenticatedUser(User user) {
        authenticatedUser = user;
    }

    /**
     * generates random shift
     *
     * @return
     */
    private static int generateRandomShift() {
        int min = 1;
        int max = 25;
        int randomNumber = ThreadLocalRandom.current().nextInt(min, max + 1);
        return randomNumber;
    }

    /**
     * encrypt password with "Ceaser cypher"
     *
     * @param originalMessage
     * @param shift
     * @return
     */
    private static String encryptWithCeaserCypher(String password, int shift) {
        String cypher = "";
        for (int x = 0; x < password.length(); x++) {
            cypher += (char) (password.charAt(x) - shift);
        }
        return cypher;
    }

    /**
     * decrypts password with "Ceaser cypher"
     *
     * @param password
     * @param shift
     * @return
     */
    private static String decryptWithCeaserCypher(String password, int shift) {
        String cypher = "";
        for (int x = 0; x < password.length(); x++) {
            cypher += (char) (password.charAt(x) + shift);
        }
        return cypher;
    }
    
    private static String buildUserDataString(User user, int shift) {
        return "username=" + user.getUsername()
                + ";name=" + user.getName()
                + ";email=" + user.getEmail()
                + ";password=" + user.getPassword()
                + ";shift=" + String.valueOf(shift) + "\n";
    }
}
