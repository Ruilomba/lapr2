/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.utils;

/**
 *
 * @author RuiSL
 */
public class Utils {
     static public int generateRandom(int minimo, int maximo) {
        int n =minimo + (int)(Math.random() * maximo);
        return n;
        
    }
     
     public static int getMinorValueIndex ( int[]vetor){
        int menorIndex=0;
        for(int i=0;i<vetor.length;i++) {
            if(vetor[menorIndex]> vetor[i]) {
                menorIndex=i;
            }
        }
        return menorIndex;
    }
}
