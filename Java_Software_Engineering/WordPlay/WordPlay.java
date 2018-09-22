
/**
 * @CraigFrayne 
 * @30/10/2017
 */

import edu.duke.*;

public class WordPlay {
    public boolean isVowel(char ch) {
        // convert to uppercase
        char charUpper = Character.toUpperCase(ch);
        // string of vowels
        String vowels = "AEIOU";
        // find index of ch
        int index = vowels.indexOf(charUpper);
        // return true if ch is in vowels
        if (index != -1) {
            return true;
        }
        else {
            return false;
        }
    }
    public void testIsVowel() {
        System.out.println(isVowel('F'));
        System.out.println(isVowel('a'));
    }
    public String replaceVowels(String phrase, char ch) {
        // convert phrase to mutable string
        StringBuilder newPhrase = new StringBuilder(phrase);
        // iterate over each char in phrase
        for (int i = 0, n = newPhrase.length(); i < n; i++) {
            char c = phrase.charAt(i);
            // check if char is a vowel; if true change to ch
            boolean vowel = isVowel(c);
            if (vowel == true) {
                newPhrase.setCharAt(i, ch);
            }
        }
        // convert back to string and return
        return newPhrase.toString();
    }
    public void testReplaceVowels() {
        System.out.println(replaceVowels("Hello World", '*'));
    }
    public String emphasize(String phrase, char ch) {
        // convert phrase to mutable string
        StringBuilder newPhrase = new StringBuilder(phrase);
        // interate over newPhrase
        for (int i = 0, n = newPhrase.length(); i < n; i++) {
            char c = phrase.charAt(i);
            char charUpper = Character.toUpperCase(ch);
            char cUpper = Character.toUpperCase(c);
            // check if c matches ch (case insensitive)
            if (charUpper == cUpper) {
                // check if char location is even or odd
                int location = i + 1;
                if (location % 2 == 0) {
                    newPhrase.setCharAt(i, '+');
                }
                else {
                    newPhrase.setCharAt(i, '*');
                }
            }
        }
        return newPhrase.toString();
    }
    public void testEmphasize() {
        System.out.println(emphasize("dna ctgaaactga", 'a'));
        System.out.println(emphasize("Mary Bella Abracadabra", 'a'));
    }
}
