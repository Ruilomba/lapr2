package lapr.project.utils;

import java.io.*;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author inesmartins
 */
public class EncryptionService {

    private final static String USER_DATA_FILE_PATH = "userData.txt";

    public EncryptionService() {
        
    }

    /**
     * generates random shift
     *
     * @return
     */
    public int generateRandomShift() {
        int min = 1;
        int max = 25;
        int randomNumber = ThreadLocalRandom.current().nextInt(min, max + 1);
        return randomNumber;
    }

    /**
     * encrypt password with "Ceaser cipher"
     *
     * @param password
     * @param shift
     * @return
     */
    public String encryptWithCeaserCipher(String password, int shift) {
        String cipher = "";
        for (int x = 0; x < password.length(); x++) {
            cipher += (char) (password.charAt(x) - shift);
        }
        return cipher;
    }

    /**
     * decrypts password with "Ceaser cipher"
     *
     * @param password
     * @param shift
     * @return
     */
    public String decryptWithCeaserCipher(String password, int shift) {
        String cipher = "";
        for (int x = 0; x < password.length(); x++) {
            cipher += (char) (password.charAt(x) + shift);
        }
        return cipher;
    }

    /**
     * writes user data encrypted with rail fence cipher
     *
     * @param encryptedData
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     */
    public boolean writeEncryptedDataToUserDataFile(String[] encryptedData) throws FileNotFoundException, IOException {
        File userDataFile = new File(USER_DATA_FILE_PATH);
        if (userDataFile.exists() || userDataFile.createNewFile()) {
            try (FileWriter fw = new FileWriter(userDataFile, true)) {
                for (String encryptedLine : encryptedData) {
                    fw.write(encryptedLine);
                }
                //fw.close();
                return true;
            } catch (Exception e) {
                System.out.println("Unable to write user info to " + USER_DATA_FILE_PATH + " file");
                return false;
            }
        }
        return false;
    }

    private void removeTmpFile(File file) {
        if (file.exists()) {
            file.delete();
        }
    }

    /**
     * encrypts user data with rail fence transposition cipher
     *
     * @param line
     * @return
     */
    public String encryptLineWithRailFenceTranspositionCipher(String line) {
        char[] lineChars = line.toCharArray();
        char[] vector1 = new char[lineChars.length];
        char[] vector2 = new char[lineChars.length];
        char[] vector3 = new char[lineChars.length];
        int count = 0;
        for (char c : lineChars) {
            switch (count) {
                case 0:
                    vector1[vector1.length] = c;
                    count++;
                    break;
                case 1:
                    vector2[vector2.length] = c;
                    count++;
                    break;
                case 2:
                    vector3[vector3.length] = c;
                    count = 0;
                    break;
                default:
                    break;
            }
        }
        char[] encryptedLineChars = new char[lineChars.length];
        for (char c : vector1) {
            encryptedLineChars[encryptedLineChars.length] = c;
        }
        for (char c : vector2) {
            encryptedLineChars[encryptedLineChars.length] = c;
        }
        for (char c : vector3) {
            encryptedLineChars[encryptedLineChars.length] = c;
        }
        return Arrays.toString(encryptedLineChars);
    }

    /**
     * decrypts line with rail fence transposition cipher
     *
     * @param encryptedLine
     * @return
     */
    public String decryptLineWithRailFenceTranspositionCipher(String encryptedLine) {
        char[] lineChars = encryptedLine.toCharArray();
        char[] vector1 = new char[lineChars.length];
        char[] vector2 = new char[lineChars.length];
        char[] vector3 = new char[lineChars.length];

        int count = 0;
        for (char c : lineChars) {
            switch (count) {
                case 0:
                    vector1[vector1.length] = c;
                    count++;
                    break;
                case 1:
                    vector2[vector2.length] = c;
                    count++;
                    break;
                case 2:
                    vector3[vector3.length] = c;
                    count = 0;
                    break;
            }
        }
        char[] encryptedLineChars = new char[lineChars.length];
        for (char c : vector1) {
            encryptedLineChars[encryptedLineChars.length] = c;
        }
        for (char c : vector2) {
            encryptedLineChars[encryptedLineChars.length] = c;
        }
        for (char c : vector3) {
            encryptedLineChars[encryptedLineChars.length] = c;
        }
        return Arrays.toString(encryptedLineChars);
    }
}
