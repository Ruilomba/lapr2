package lapr.project.utils;

import java.util.Properties;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;
import lapr.project.model.User;

/**
 *
 * @author inesmartins
 */
public class EncryptionService {

    public static boolean encryptAndSavePassword(String username, String originalPassword)
            throws FileNotFoundException, IOException {

        int userShift = generateRandomShift();
        String encryptedPassword = encrypt(originalPassword, userShift);

        Properties properties = new Properties();
        properties.setProperty("Username", username);
        properties.setProperty("Password", encryptedPassword);
        properties.setProperty("Shift", String(userShift));

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

    public static boolean checkIfPasswordIsValid(User user, String encryptedPassword) {
        try {
            String filename = user.getUsername() + ".properties";
            File file = new File(filename);
            if ((file.exists() && !file.isDirectory())) {
                Properties properties = new Properties();
                InputStream input = new FileInputStream(filename);
                properties.load(input);
                String usrName = properties.getProperty("Username");
                String password = properties.getProperty("Password");
                String shift = properties.getProperty("Shift");
                try {
                    int intShift = Integer.parseInt(shift);
                    String decryptedPassword = decrypt(encryptedPassword, intShift);
                    return decryptedPassword.equals(user.getPassword());
                }
                catch (NumberFormatException e) {
                    System.out.println("\"Unable to parse user shift");
                    return false;
                }
            }
            return false;
        } catch (Exception e) {
            System.out.println("Unable to save properties in file");
            return false;
        }
    }

    private static int generateRandomShift() {
        int min = 1;
        int max = 25;
        int randomNumber = ThreadLocalRandom.current().nextInt(min, max + 1);
        return randomNumber;
    }

    private static String encrypt(String originalMessage, int shift) {
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

    private static String decrypt(String password, int shift) {
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

    private static String String(int userShift) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
