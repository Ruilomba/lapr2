package lapr.project.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;
import java.util.concurrent.ThreadLocalRandom;

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

    /**
     * registers new user
     *
     * @param username
     * @param password
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static boolean registerUser(String username, String password)
            throws FileNotFoundException, IOException {

        int userShift = generateRandomShift();
        String encryptedPassword = encryptWithCeaserCypher(password, userShift);

        Properties properties = new Properties();
        properties.setProperty("Username", username);
        properties.setProperty("Password", encryptedPassword);
        properties.setProperty("Shift", String.valueOf(userShift));

        try {
            File file = new File(username + ".properties");
            if ((file.exists() && !file.isDirectory()) || (!file.exists() && file.createNewFile())) {
                OutputStream out = new FileOutputStream(file);
                properties.store(out, null);
            }
        } catch (Exception e) {
            System.out.println("Unable to save properties in file");
            return false;
        }
        return true;
    }

    /**
     * authenticates user
     *
     * @param username
     * @param password
     * @return
     * @throws java.io.IOException
     */
    public static boolean loginUser(String username, String password) throws IOException {
        if (passwordIsValid(username, password)) {
            saveUsernameAsGlobalVariable();
            return true;
        }
        return false;
    }
    
    private static void saveUsernameAsGlobalVariable() {
        // TODO: COMPLETE
        throw new UnsupportedOperationException();
    }

    /**
     * checks if password entered by user is valid
     * @param username
     * @param userPassword
     * @return
     * @throws FileNotFoundException
     * @throws IOException 
     */
    private static boolean passwordIsValid(String username, String password) throws FileNotFoundException, IOException {
        String filename = username + ".properties";
        try {
            File file = new File(filename);
            if ((file.exists() && !file.isDirectory())) {
                Properties properties = new Properties();
                InputStream input = new FileInputStream(filename);
                properties.load(input);
                String storedPassword = properties.getProperty("Password");
                String storedShift = properties.getProperty("Shift");
                int intShift = 0;
                try {
                    intShift = Integer.parseInt(storedShift);
                } catch (NumberFormatException e) {
                    System.out.println("\"Unable to parse user shift");
                    return false;
                }
                if (intShift > 0) {
                    String decryptedPassword = decryptWithCeaserCypher(storedPassword, intShift);
                    return decryptedPassword.equals(password);                    
                }
            }
            return false;
        }
        catch (FileNotFoundException e) {
            System.out.println("Unable to read from file " + filename + ": " + e.getMessage());            
        }
        catch (IOException e) {
            System.out.println("Unable to read user data from properties file: " + e.getMessage());
        }
        return false;
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
    private static String encryptWithCeaserCypher(String originalMessage, int shift) {
        String cypher = "";
        int messageLength = originalMessage.length();
        for (int x = 0; x < messageLength; x++) {
            char charWithShift = (char) (originalMessage.charAt(x) + shift);
            if (charWithShift < 'z') {
                cypher += (char) (originalMessage.charAt(x) + shift);
            } else {
                cypher += (char) (originalMessage.charAt(x) - (26 - shift));
            }
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
        int messageLength = password.length();
        for (int x = 0; x < messageLength; x++) {
            char charWithShift = (char) (password.charAt(x) - shift);
            if (charWithShift > 'a') {
                cypher += (char) (password.charAt(x) - shift);
            } else {
                cypher += (char) (password.charAt(x) + (26 - shift));
            }
        }
        return cypher;
    }
}
