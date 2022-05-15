
/**
 * Write a description of Cipher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.io.*;
import edu.duke.*;

public class CaesarCipher {
    public String encrypt(String input, int key) {
        String inputUpper = input.toUpperCase();
        // convert input to mutable string
        StringBuilder encrypted = new StringBuilder(input);
        StringBuilder encryptedUpper = new StringBuilder(inputUpper);
        
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String alphabetLower = alphabet.toLowerCase();
        
        String shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0,key);
        String shiftedAlphabetLower = alphabetLower.substring(key) + alphabetLower.substring(0,key);
        
        for (int i = 0; i < encrypted.length(); i++) {
           char currChar = encrypted.charAt(i); 
           char currCharUpper = encryptedUpper.charAt(i); 
           boolean upperCase = Character.isUpperCase(currChar);
           int index = alphabet.indexOf(currCharUpper); 
           if (index != -1 && upperCase == true) { 
               int idx = alphabet.indexOf(currChar);
               char newChar = shiftedAlphabet.charAt(idx);
               encrypted.setCharAt(i, newChar);
           }
           if (index != -1 && upperCase == false) { 
               int idx = alphabetLower.indexOf(currChar);
               char newChar = shiftedAlphabetLower.charAt(idx);
               encrypted.setCharAt(i, newChar);
           }
        }
        return encrypted.toString();
    }
    public String encryptTwoKeys(String input, int key1, int key2) {
        String inputUpper = input.toUpperCase();
        // convert input to mutable string
        StringBuilder encrypted = new StringBuilder(input);
        StringBuilder encryptedUpper = new StringBuilder(inputUpper);
        
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String alphabetLower = alphabet.toLowerCase();
        
        String shiftedAlphabetEven = alphabet.substring(key1) + alphabet.substring(0,key1);
        String shiftedAlphabetLowerEven = alphabetLower.substring(key1) + alphabetLower.substring(0,key1);
        String shiftedAlphabetOdd = alphabet.substring(key2) + alphabet.substring(0,key2);
        String shiftedAlphabetLowerOdd = alphabetLower.substring(key2) + alphabetLower.substring(0,key2);
        
        for (int i = 0; i < encrypted.length(); i++) {
           char currChar = encrypted.charAt(i); 
           char currCharUpper = encryptedUpper.charAt(i); 
           boolean upperCase = Character.isUpperCase(currChar);
           int index = alphabet.indexOf(currCharUpper);
           int pos = i + 1;
           if (index != -1 && upperCase == true && pos%2 != 0) { 
               int idx = alphabet.indexOf(currChar);
               char newChar = shiftedAlphabetEven.charAt(idx);
               encrypted.setCharAt(i, newChar);
           }
           if (index != -1 && upperCase == false && pos%2 != 0) { 
               int idx = alphabetLower.indexOf(currChar);
               char newChar = shiftedAlphabetLowerEven.charAt(idx);
               encrypted.setCharAt(i, newChar);
           }
           if (index != -1 && upperCase == true && pos%2 == 0) { 
               int idx = alphabet.indexOf(currChar);
               char newChar = shiftedAlphabetOdd.charAt(idx);
               encrypted.setCharAt(i, newChar);
           }
           if (index != -1 && upperCase == false && pos%2 == 0) { 
               int idx = alphabetLower.indexOf(currChar);
               char newChar = shiftedAlphabetLowerOdd.charAt(idx);
               encrypted.setCharAt(i, newChar);
           }
        }
        return encrypted.toString();
    }
    public void testCaesar1() {
        System.out.println(encrypt("Can you imagine life WITHOUT the internet AND computers in your pocket?",15));
    }
    public void testCaesar() {
        int key = 17;
        FileResource fr = new FileResource();
        String message = fr.asString();
        String encrypted = encrypt(message, key);
        System.out.println("key is " + key + "\n" + encrypted);
        String decrypted = encrypt(encrypted, 26-key);
        System.out.println(decrypted);
    }
    public void testencryptTwoKeys() {
        System.out.println(encryptTwoKeys("At noon be in the conference room with your hat on for a surprise party. YELL LOUD!",8,21));
    }
}
