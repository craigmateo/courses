
/**
 * Write a description of CaesarCipherTwo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CaesarCipherTwo {
    private String alphabet;
    private String alphabetLower;
    private String shiftedAlphabetEven;
    private String shiftedAlphabetOdd;
    private String shiftedAlphabetLowerEven;
    private String shiftedAlphabetLowerOdd;
    private int mainKey1;
    private int mainKey2;
    public CaesarCipherTwo(int key1, int key2) {
        mainKey1 = key1;
        mainKey2 = key2;
        alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        alphabetLower = alphabet.toLowerCase();
        shiftedAlphabetEven = alphabet.substring(key1) + alphabet.substring(0,key1);
        shiftedAlphabetLowerEven = alphabetLower.substring(key1) + alphabetLower.substring(0,key1);
        shiftedAlphabetOdd = alphabet.substring(key2) + alphabet.substring(0,key2);
        shiftedAlphabetLowerOdd = alphabetLower.substring(key2) + alphabetLower.substring(0,key2);
    }
    public String encryptTwoKeys(String input) {
        //CaesarCipherTwo cc = new CaesarCipherTwo(22, 18); 
        String inputUpper = input.toUpperCase();
        // convert input to mutable string
        StringBuilder encrypted = new StringBuilder(input);
        StringBuilder encryptedUpper = new StringBuilder(inputUpper);
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
    public String decryptTwoKeys(String input) {
        CaesarCipherTwo cc = new CaesarCipherTwo(26 - mainKey1, 26 - mainKey2);
        return cc.encryptTwoKeys(input);
    }
}
