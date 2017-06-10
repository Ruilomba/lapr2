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
     * @param decryptedData
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     */
    public boolean writeDataToUserDataFile(String[] decryptedData) throws FileNotFoundException, IOException {
        File userDataFile = new File(USER_DATA_FILE_PATH);
        if (userDataFile.exists() || userDataFile.createNewFile()) {
            FileWriter fw;
            try {
                fw = new FileWriter(userDataFile, true);
            } catch (Exception e) {
                System.out.println("Unable to write user info to " + USER_DATA_FILE_PATH + " file: " + e.getMessage());
                return false;
            }
            for (String line : decryptedData) {
                String encryptedLine = encryptLineWithRailFenceTranspositionCipher(line);
                fw.write(encryptedLine);
                fw.write("\n");
            }
            fw.close();
            return true;
        }
        return false;
    }

    /**
     * encrypts user data with rail fence transposition cipher
     *
     * @param originalLine
     * @return
     */
    public String encryptLineWithRailFenceTranspositionCipher(String originalLine) {
        
        String cleanLine = originalLine.split("\n")[0];
        char[] lineChars = cleanLine.toCharArray();

        List<String> vector1 = new ArrayList<>();
        List<String> vector2 = new ArrayList<>();
        List<String> vector3 = new ArrayList<>();

        int count = 0;
        for (char c : lineChars) {
            switch (count) {
                case 0:
                    vector1.add(String.valueOf(c));
                    count++;
                    break;
                case 1:
                    vector2.add(String.valueOf(c));
                    count++;
                    break;
                case 2:
                    vector3.add(String.valueOf(c));
                    count = 0;
                    break;
            }
        }

        String[] encryptedLineChars = new String[lineChars.length];
        int count2 = 0;
        for (String c : vector1) {
            encryptedLineChars[count2] = c;
            count2++;
        }
        for (String c : vector2) {
            encryptedLineChars[count2] = c;
            count2++;
        }
        for (String c : vector3) {
            encryptedLineChars[count2] = c;
            count2++;
        }
        String encryptedLineString = "";
        for (String encryptedChar : encryptedLineChars) {
            encryptedLineString = encryptedLineString.concat(encryptedChar);
        }
        return encryptedLineString;
    }
    
    /**
     * 
     * @param originalLine
     * @return 
     */
    public String decryptLineWithRailFenceTranspositionCipher(String originalLine) {
        
        String cleanLine = originalLine.split("\n")[0];
        int lineLength = cleanLine.length();
        
        double doubleFirstThirdMaxIndex = (double)lineLength/3;
        double roundedUpFirstThirdMaxIndex = Math.floor(doubleFirstThirdMaxIndex);
        int firstThirdMaxIndex = (int)roundedUpFirstThirdMaxIndex;
        int extraCharsCount = lineLength - (firstThirdMaxIndex * 3);
        int secondThirdMaxIndex = firstThirdMaxIndex * 2;

        if (extraCharsCount > 0) {
            firstThirdMaxIndex += 1;
            secondThirdMaxIndex += 1;
        }
        if (extraCharsCount > 1) {
            secondThirdMaxIndex += 1;
        }
        
        String substring1 = cleanLine.substring(0, firstThirdMaxIndex);
        String substring2 = cleanLine.substring(firstThirdMaxIndex, secondThirdMaxIndex);
        String substring3 = cleanLine.substring(secondThirdMaxIndex, lineLength);
        
        char[] substring1Chars = substring1.toCharArray();
        char[] substring2Chars = substring2.toCharArray();
        char[] substring3Chars = substring3.toCharArray();
        
        String decryptedLineString = "";
        int count = 0;
        int currentIndex = 0;
        for (int i = 0; i < lineLength; i++) {
            switch (count) {
                case 0:
                    String newChar1 = String.valueOf(substring1Chars[currentIndex]);
                    decryptedLineString = decryptedLineString.concat(newChar1);
                    count++;
                    break;
                case 1:
                    String newChar2 = String.valueOf(substring2Chars[currentIndex]);
                    decryptedLineString = decryptedLineString.concat(newChar2);
                    count++;
                    break;
                case 2:
                    String newChar3 = String.valueOf(substring3Chars[currentIndex]);
                    decryptedLineString = decryptedLineString.concat(newChar3);
                    count = 0;
                    currentIndex++;
                    break;
            }
        }
        return decryptedLineString;
    }
}
