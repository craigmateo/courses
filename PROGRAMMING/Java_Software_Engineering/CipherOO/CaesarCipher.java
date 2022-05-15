
/**
 * Write a description of CaesarCipher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CaesarCipher {
    private String alphabet;
    private String alphabetLower;
    private String shiftedAlphabet;
    private String shiftedAlphabetLower;
    private int mainKey;
    public CaesarCipher(int key) {
        mainKey = key;
        alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        alphabetLower = alphabet.toLowerCase();
        shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0,key);
        shiftedAlphabetLower = alphabetLower.substring(key) + alphabetLower.substring(0,key);
    }
    public String encrypt(String input) {
        CaesarCipher cc = new CaesarCipher(22); 
        // convert input to mutable string
        String inputUpper = input.toUpperCase();
        StringBuilder encrypted = new StringBuilder(input);
        StringBuilder encryptedUpper = new StringBuilder(inputUpper);
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
    public String decrypt(String input) {
        CaesarCipher cc = new CaesarCipher(26 - mainKey);
        return cc.encrypt(input);
    }
}

