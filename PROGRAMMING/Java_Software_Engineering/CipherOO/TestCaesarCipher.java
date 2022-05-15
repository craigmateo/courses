
/**
 * Write a description of TestCaesarCipher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.io.*;
import edu.duke.*;

public class TestCaesarCipher {
    public int [] countLetters(String message){
        String alph = "abcdefghijklmnopqrstuvwxyz";
        int [] counts = new int[26];
        for(int k=0; k < message.length(); k++) {
            char ch = Character.toLowerCase(message.charAt(k));
            int dex = alph.indexOf(ch);
            if(dex != -1){
                counts[dex] += 1;
            }
        }
        return counts;
    }
    public int maxIndex(int [] values) {
       int max = 0;
       int pos = 0;
       for (int i = 0; i < values.length; i++) {
           if(values[i] > max){
               max = values[i];
               pos = i;
           }
       }
       return pos;
    }
    public void simpleTests() {
        FileResource fr = new FileResource();
        String message = fr.asString();
        CaesarCipher cc = new CaesarCipher(18);
        String encrypted = cc.encrypt(message);
        System.out.println(encrypted);
        //String decrypted = cc.decrypt(encrypted);
        String decrypted = breakCaesarCipher(encrypted);
        System.out.println(decrypted);
    }
    public int getKey(String s){
        int [] letters = countLetters(s);
        int maxInd = maxIndex(letters);
        int dkey = maxInd-4;
        if (dkey < 0) {
            dkey = 26 - (4 - maxInd);
        }
        return dkey;
    }
    public String breakCaesarCipher(String input) {
        int key = getKey(input);
        CaesarCipher cc = new CaesarCipher(key);
        String decrypted = cc.decrypt(input);
        return decrypted;
    }
}
