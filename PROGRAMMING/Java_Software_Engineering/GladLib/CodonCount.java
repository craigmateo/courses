
/**
 * Write a description of CodonCount here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.*;
import java.util.*;

public class CodonCount {
    private HashMap<String, Integer> map;
    
    public CodonCount() {
        map = new HashMap<String, Integer>();
    }
    
    public void buildCodonMap(int start, String dna) {
        map.clear();
        for (int i=start; i<=dna.length()-3; i+=3) {
            String codon = dna.substring(i,i+3);
            if(!map.containsKey(codon)){
                map.put(codon,1);
            }
            else {
                map.put(codon,map.get(codon)+1);
            }
        }
    }
    public String getMostCommonCodon(){
        int max = 0;
        String maxCodon = "";
        for(String codon : map.keySet()){
            int occurrences = map.get(codon);
            if (occurrences > max){
                max = map.get(codon);
                maxCodon = codon;
            }
        }
        return maxCodon;
    }
    public void printCodonCounts(int start, int end){
        for(String codon : map.keySet()){
            int occurrences = map.get(codon);
            if (occurrences >= start && occurrences <= end){
                int count = map.get(codon);
                System.out.println(codon + " " + count);
            }
        }
    }
    public void tester(){
        FileResource fr = new FileResource();
        String dna = fr.asString().trim();
        dna = dna.toUpperCase();
        int start = 7;
        int end = 7;
        
        buildCodonMap(0, dna);
        System.out.println("Reading frame starting with 0 results in "+map.size()+" unique codons"+"\t");
        String largest = getMostCommonCodon();
        System.out.println("and most common codon is "+largest+" with count "+map.get(largest)+"\t");  
        System.out.println("Counts of codons between "+start+" and "+end+" inclusive are:"+"\t");
        printCodonCounts(start, end);
        
        buildCodonMap(1, dna);
        System.out.println("Reading frame starting with 1 results in "+map.size()+" unique codons"+"\t");
        largest = getMostCommonCodon();
        System.out.println("and most common codon is "+largest+" with count "+map.get(largest)+"\t");  
        System.out.println("Counts of codons between "+start+" and "+end+" inclusive are:"+"\t");
        printCodonCounts(start, end);
        
        buildCodonMap(2, dna);
        System.out.println("Reading frame starting with 2 results in "+map.size()+" unique codons"+"\t");
        largest = getMostCommonCodon();
        System.out.println("and most common codon is "+largest+" with count "+map.get(largest)+"\t");  
        System.out.println("Counts of codons between "+start+" and "+end+" inclusive are:"+"\t");
        printCodonCounts(start, end);
    
    }
}
