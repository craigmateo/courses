
/**
 * Write a description of TestCaesarCipherTwo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.io.*;
import edu.duke.*;

public class TestCaesarCipherTwo {
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
        //CaesarCipherTwo cc = new CaesarCipherTwo(26-14,26-24);
        //String encrypted = cc.encryptTwoKeys("Hfs cpwewloj loks cd Hoto kyg Cyy.");
        //System.out.println(encrypted);
        //String decrypted = cc.decryptTwoKeys(encrypted);
        String decrypted = breakCaesarCipher(message);
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
    public String halfOfString(String message, int start){
        StringBuilder half = new StringBuilder();
        for (int i = start; i < message.length(); i += 2){
            char a = message.charAt(i);
            half.append(a);
        }
        return half.toString();
    }
    public String breakCaesarCipher(String input) {
        int key1 = getKey(halfOfString(input, 0));
        int key2 = getKey(halfOfString(input, 1));
        System.out.println(key1 + "\t" + key2);
        CaesarCipherTwo cc = new CaesarCipherTwo(key1, key2);
        String decrypted = cc.decryptTwoKeys(input);
        return decrypted;
    }
}
