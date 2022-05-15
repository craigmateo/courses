
/**
 * Write a description of tester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
import edu.duke.*;
import java.io.*;

public class tester {
    public void testCaesarCipher() {
        CaesarCipher se = new CaesarCipher(3);
        FileResource fr = new FileResource();
        String str = fr.asString();
        System.out.println(str);
        System.out.println(se.encrypt(str));
        System.out.println(se.decrypt(se.encrypt(str)));
    }
    
    public void testCaesarCracker() {
        CaesarCracker cc = new CaesarCracker();
        FileResource fr = new FileResource();
        String str = fr.asString();
        System.out.println(cc.decrypt(str));
    }
    
    public void testVigenereCipher() {
        int[] key = {17, 14, 12, 4};
        VigenereCipher vc = new VigenereCipher(key);
        FileResource fr = new FileResource();
        String str = fr.asString();
        System.out.println(vc.encrypt(str));
    }
    
    public void testVigenereBreaker() {
        VigenereBreaker vb = new VigenereBreaker();
        FileResource fr = new FileResource();
        String str = fr.asString();
        int[] key = vb.tryKeyLength(str, 4, 'e');
        for (int k = 0; k < key.length; k++) {
            System.out.println(key[k]);
        }
    }
    
    public void testVigenereBreaker2() {
        VigenereBreaker vb = new VigenereBreaker();
        vb.breakVigenere2();
    }
    
    public void testVigenereBreaker3() {
        VigenereBreaker vb = new VigenereBreaker();
        vb.breakVigenere3();
    }
}
