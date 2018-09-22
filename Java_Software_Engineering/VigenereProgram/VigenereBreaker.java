
import java.util.*;
import edu.duke.*;
import java.io.*;

public class VigenereBreaker {
    
    public String sliceString(String message, int whichSlice, int totalSlices) {
        StringBuilder result = new StringBuilder();
        for (int k = whichSlice; k < message.length(); k=k+totalSlices) {
            result.append(message.substring(k, k+1));
        }
        return result.toString();
    }

    public int[] tryKeyLength(String encrypted, int klength, char mostCommon) {
        int[] key = new int[klength];
        String[] groups = new String[klength];
        for (int k = 0; k < klength; k++) {
            groups[k] = sliceString(encrypted, k, klength);
        }
        CaesarCracker cc = new CaesarCracker(mostCommon);
        for (int k = 0; k < klength; k++) {
            key[k] = cc.getKey(groups[k]);
        } 
        return key;
    }

    // Break the message with known key length.
    
    public void breakVigenere () {
        FileResource fr = new FileResource();
        String str = fr.asString();
        int[] key = tryKeyLength(str, 4, 'e');
        VigenereCipher vc = new VigenereCipher(key);
        String result = vc.decrypt(str);
        System.out.println(result);
    }
    
    // Break the message with unknown key length.
    
    public HashSet<String> readDictionary(FileResource fr) {
        HashSet<String> result = new HashSet<String>();
        for (String line: fr.lines()) {
            line = line.toLowerCase();
            result.add(line);
        }
        return result;
    }
    
    public Integer countWords(String message, HashSet<String> dictionary) {
        int result = 0;
        for (String word: message.split("\\W")) {
            word = word.toLowerCase();
            if (dictionary.contains(word)) result += 1;
        }
        return result;
    }
    
    public String breakForLanguage(String encrypted, HashSet<String> dictionary) {
        int[] key_list = new int[100];
        int[] wordcount = new int[100];
        
        for (int k = 1; k <= 100; k++) key_list[k-1] = k;
        
        for (int k = 0; k < 100; k++) {
            int[] key = tryKeyLength(encrypted, key_list[k], 'e');
            VigenereCipher vc = new VigenereCipher(key);
            String result = vc.decrypt(encrypted);
            wordcount[k] = countWords(result, dictionary);
        }
        
        // figure out which key length has the largest word count.
        int largest = 0;
        int index = 0;
        for (int k = 0; k < 100; k++) {
            if (wordcount[k] > largest) {
                largest = wordcount[k];
                index = k;
            }
        }
        
        System.out.println("The largest count is "+largest);
        
        int truekey = key_list[index];
        int[] key = tryKeyLength(encrypted, truekey, 'e');
        System.out.println("The keys are "+"\t");
        for (int k = 0; k < key.length; k++) {
            System.out.println(key[k]);
        }
        System.out.println("The key length is "+key.length);
        VigenereCipher vc = new VigenereCipher(key);
        return vc.decrypt(encrypted);
    }
    
    public void breakVigenere2() {
        FileResource fr = new FileResource();
        String str = fr.asString();
        FileResource dic = new FileResource();
        HashSet<String> dictionary = readDictionary(dic);
        String result = breakForLanguage(str, dictionary);
        System.out.println(result);
    }
    
    // // Break the message with unknown language and unknown key length.
    public String mostCommonCharIn(HashSet<String> dictionary) {
        HashMap<String, Integer> count = new HashMap<String, Integer>();
        String all = "abcdefghijklmnopqrstuvwxyz";
        for (int k = 0; k < 26; k++) {
            count.put(all.substring(k,k+1),0);
        }
        
       
        for (String word: dictionary) {
            word = word.toLowerCase();
            String[] letters = word.split("");
            for (String letter: count.keySet()) {
                for (String le: letters) {
                    if (le.equals(letter)) count.put(letter, count.get(letter)+1);
                }
            }
        }

        int max = 0;
        String result=null;
        
        for (String letter: count.keySet()) {
            if (max < count.get(letter)) {
                max = count.get(letter);
                result = letter;
            }
        }
        
        return result;
    }
    
    public String breakForLanguage2(String encrypted, HashSet<String> dictionary) {
        // find out the most common char.
        
        
        char common = mostCommonCharIn(dictionary).charAt(0);
        System.out.println("The most common char is "+common);
        
        
        // breakForLanguage
        
        int[] key_list = new int[100];
        int[] wordcount = new int[100];
        
        for (int k = 1; k <= 100; k++) key_list[k-1] = k;
        
        for (int k = 0; k < 100; k++) {
            int[] key = tryKeyLength(encrypted, key_list[k], common);
            VigenereCipher vc = new VigenereCipher(key);
            String result = vc.decrypt(encrypted);
            wordcount[k] = countWords(result, dictionary);
        }
        
        // figure out which key length has the largest word count.
        int largest = 0;
        int index = 0;
        for (int k = 0; k < 100; k++) {
            if (wordcount[k] > largest) {
                largest = wordcount[k];
                index = k;
            }
        }
        
        
        System.out.println("The largest count is "+largest);
        
        int truekey = key_list[index];
        int[] key = tryKeyLength(encrypted, truekey, common);
        //System.out.println("The keys are "+"\t");
        //for (int k = 0; k < key.length; k++) {
        //    System.out.println(key[k]);
        //}
        System.out.println("The key length is "+key.length);
        VigenereCipher vc = new VigenereCipher(key);
        System.out.println(vc.decrypt(encrypted));
        return vc.decrypt(encrypted);
    }
    
    public HashMap<String, String> breakForAllLanguages(String encrypted, HashMap<String, HashSet<String>> languages) {
        HashMap<String, String> result = new HashMap<String, String>();
        for (String lan: languages.keySet()) {
            System.out.println("Currently breaking into "+lan);
            String lanstring = breakForLanguage2(encrypted, languages.get(lan));
            result.put(lan, lanstring);
        }
        return result;
    }
    
    
    public void breakVigenere3() {
        FileResource fr = new FileResource();
        String str = fr.asString();
        
        // initialize language hashset.
        HashMap<String, HashSet<String>> languages = new HashMap<String, HashSet<String>>();
        DirectoryResource dr = new DirectoryResource();
        
        for (File f: dr.selectedFiles()) {
            FileResource fr2 = new FileResource(f.toString());
            HashSet<String> result = new HashSet<String>();
            for (String line: fr2.lines()) {
                line = line.toLowerCase();
                result.add(line);
            }
            languages.put(f.getName(), result);
            System.out.println("Finished reading "+f.getName());
            
        }
        
        
        // break for all languages
        HashMap<String, String> decrypted = breakForAllLanguages(str, languages);
        System.out.println(decrypted.get("English"));
        
    }
}
