
/**
 * Write a description of CharactersInPlay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;
import edu.duke.*;

public class CharactersInPlay {
    private ArrayList<String> characterNames;
    private ArrayList<Integer> characterCounts;
    public CharactersInPlay() {
        // arrays for character names and counts 
        characterNames = new ArrayList<String>();
        characterCounts = new ArrayList<Integer>();
    }
    public void update(String person){
        // if character not in the array, add it
        if(!characterNames.contains(person)){
            characterNames.add(person);
            characterCounts.add(0);
        }
        // add one to the counts array in the same index
        int index = characterNames.indexOf(person);
        int value = characterCounts.get(index);
        characterCounts.set(index, value+1);
    }
    public void findAllCharacters() {
        // open file
        FileResource fr = new FileResource(); 
        // read words -- if period in word and if first letter is Uppercase, assume it is a character name
        for(String line: fr.lines()){
            int index = line.indexOf(".");
            if (index != -1) {
                String s = line.substring(0,index);
                update(s);
            }
        }   
    }
    public void charactersWithNumParts(int num1, int num2){
        for(int k=0; k < characterNames.size(); k++){
            if (characterCounts.get(k) >= num1 && characterCounts.get(k) <= num2) {
                System.out.println(characterNames.get(k)+"\t"+characterCounts.get(k));
            }
        }
        
    }
    public void tester() {
        findAllCharacters();
        for(int k=0; k < characterNames.size(); k++){
            if (characterCounts.get(k) > 1) {
            System.out.println(characterNames.get(k)+"\t"+characterCounts.get(k));
            }
        }
        System.out.println("----------------");
        charactersWithNumParts(10, 15);
        System.out.println("----------------");
        int maxCount = 1;
        int maxInd = 0;
        for(int k=0; k < characterNames.size(); k++){
           if (characterCounts.get(k) > maxCount) {
               maxInd = k;
               maxCount = characterCounts.get(k); 
            }
           //System.out.println(myFreqs.get(k)+"\t"+myWords.get(k));
        }
        System.out.println(characterCounts.get(maxInd)+"\t"+characterNames.get(maxInd));
    }
}
