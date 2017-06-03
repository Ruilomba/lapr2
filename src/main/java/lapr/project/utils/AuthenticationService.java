package lapr.project.utils;

import java.io.*;
import java.util.concurrent.ThreadLocalRandom;
import lapr.project.model.User;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author softwareadapttech
 */
public class AuthenticationService {

    private final static String USER_DATA_FILE_PATH = "userData.txt";
    private static String authenticatedUser;

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
        String userdata = "username=" + user.getUsername() +
                ";name=" + user.getName() + 
                ";email=" + user.getEmail() + 
                ";password=" + encryptedPassword + 
                ";shift=" + String.valueOf(userShift) + "\n";

        File file = new File(USER_DATA_FILE_PATH);
        if ((file.exists() && !file.isDirectory()) || (!file.exists() && file.createNewFile())) {
            try (FileWriter fw = new FileWriter(USER_DATA_FILE_PATH, true)) {
                fw.write(userdata);
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
        try (BufferedReader br = new BufferedReader(new FileReader(USER_DATA_FILE_PATH))) {
            StringBuilder sb;
            sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                String userData = sb.toString();
                userData = userData.split("\n")[0]; // cleans breakline from data
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
                        if (decryptedPassword.equals(storedPassword)) {
                            setAuthenticatedUser(storedUsername);
                            return true;
                        }
                    }
                }
            }
        }
        catch (IOException e) {
            System.out.println("Unable to read " + USER_DATA_FILE_PATH + " file");
            return false;
        }
        return false;
    }

    public static String getAuthenticatedUser() {
        return authenticatedUser;
    }

    public static void setAuthenticatedUser(String username) {
        authenticatedUser = username;
    }

    /**
     * generates random shift < 26
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
}
