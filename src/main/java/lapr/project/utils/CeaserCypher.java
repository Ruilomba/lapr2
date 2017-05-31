/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.utils;

/**
 *
 * @author inesmartins
 */
public class CeaserCypher {
    
    public static String cipher(String originalMessage, int shift) {
        String cypher = "";
        int messageLength = originalMessage.length();
        for (int x = 0; x < messageLength; x++) {
            char c = (char)(originalMessage.charAt(x) + shift);
        if (c < 'z')
            cypher += (char)(originalMessage.charAt(x) + shift);
        else
            cypher += (char)(originalMessage.charAt(x) - (26-shift));
        }
        return cypher;
    }
}
