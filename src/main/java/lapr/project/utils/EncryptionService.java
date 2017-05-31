package lapr.project.utils;

import java.util.Properties;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

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
        }
        catch(Exception e) {
            System.out.println("Unable to save properties in file");
            return false;
        }
        return false;
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

    private static String decrypt(String originalMessage, int shift) {
        String cypher = "";
        int messageLength = originalMessage.length();
        for (int x = 0; x < messageLength; x++) {
            char charWithShift = (char) (originalMessage.charAt(x) - shift);
            if (charWithShift > 'a') {
                cypher += (char) (originalMessage.charAt(x) - shift);
            } else {
                cypher += (char) (originalMessage.charAt(x) + (26 - shift));
            }
        }
        return cypher;
    }

    private static String String(int userShift) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
