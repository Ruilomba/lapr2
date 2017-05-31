package lapr.project.utils;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author softwareadapttech
 */
public class EncryptionServiceTest {

    @Test
    private void ensureEncryptIsCorrect() throws Exception {
        String encryptionResult = EncryptionService.encrypt("abc", 4);
        String expectedResult = EncryptionService.encrypt("def", 4);
        assertEquals(encryptionResult, expectedResult);
    }

    @Test
    private void ensureDecryptIsCorrect() throws Exception {
        String decryptionResult = EncryptionService.decrypt("def", 4);
        String expectedResult = EncryptionService.decrypt("abc", 4);
        assertEquals(decryptionResult, expectedResult);
    }
}
