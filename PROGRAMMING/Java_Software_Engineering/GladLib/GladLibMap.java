
/**
 * Write a description of GladLibMap here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.util.*;

public class GladLibMap {
    private HashMap<String, ArrayList<String>> myMap;
    
    private ArrayList<String> usedWords;
    private ArrayList<String> usedLabels;
    
    private Random myRandom;
    
    private static String dataSourceURL = "http://dukelearntoprogram.com/course3/data";
    private static String dataSourceDirectory = "data";
    
    public GladLibMap(){
        myMap = new HashMap<String, ArrayList<String>>();
        initializeFromSource(dataSourceDirectory);
        myRandom = new Random();
    }
    
    public GladLibMap(String source){
        initializeFromSource(source);
        myRandom = new Random();
    }
    
    private void initializeFromSource(String source) {
        ArrayList<String> arraylist = new ArrayList<String>();
        String [] labels = {"country","noun","animal","adjective","name","color","timeframe","verb","fruit"};
        
        for (int k = 0; k < labels.length; k++) {
            arraylist = readIt(source+"/"+labels[k]+".txt");
            myMap.put(labels[k], arraylist);
        }
        usedWords = new ArrayList<String>();
        usedLabels = new ArrayList<String>();
    }
             
    private String randomFrom(ArrayList<String> source){
        int index = myRandom.nextInt(source.size());
        return source.get(index);
    }
    
    private String getSubstitute(String label) {
        if (label.equals("number")){
            return ""+myRandom.nextInt(50)+5;
        }
        return randomFrom(myMap.get(label));
    }
    
    private String processWord(String w){
        int first = w.indexOf("<");
        int last = w.indexOf(">",first);
        if (first == -1 || last == -1){
            return w;
        }
        String prefix = w.substring(0,first);
        String suffix = w.substring(last+1);
        String sub = getSubstitute(w.substring(first+1,last));
        int index = usedWords.indexOf(sub);
        int usedornot = 1;
        while (usedornot == 1) {
            if (index == -1) {
                usedWords.add(sub);
                usedornot = 0;
                
            }
            else {
                sub = getSubstitute(w.substring(first+1,last));
                index = usedWords.indexOf(sub);
            }
        }
        return prefix+sub+suffix;
    }
    
    private void printOut(String s, int lineWidth){
        int charsWritten = 0;
        for(String w : s.split("\\s+")){
            if (charsWritten + w.length() > lineWidth){
                System.out.println();
                charsWritten = 0;
            }
            System.out.print(w+" ");
            charsWritten += w.length() + 1;
        }
    }
    
    private String fromTemplate(String source){
        String story = "";
        if (source.startsWith("http")) {
            URLResource resource = new URLResource(source);
            for(String word : resource.words()){
                story = story + processWord(word) + " ";
            }
        }
        else {
            FileResource resource = new FileResource(source);
            for(String word : resource.words()){
                story = story + processWord(word) + " ";
            }
        }
        return story;
    }
    
    private ArrayList<String> readIt(String source){
        ArrayList<String> list = new ArrayList<String>();
        if (source.startsWith("http")) {
            URLResource resource = new URLResource(source);
            for(String line : resource.lines()){
                list.add(line);
            }
        }
        else {
            FileResource resource = new FileResource(source);
            for(String line : resource.lines()){
                list.add(line);
            }
        }
        return list;
    }
    
    private int totalWordsInMap() {
        int sum = 0;
        for (String word: myMap.keySet()) {
            sum += myMap.get(word).size();
        }
        return sum;
    }
    
    private int totalWordsConsidered() {
        int sum = 0;
        for (int k = 0; k < usedLabels.size(); k++) {
            sum += myMap.get(usedLabels.get(k)).size();
        }
        return sum;
    }
    
    
    public void makeStory(){
        System.out.println("\n");
        String story = fromTemplate("data/madtemplate2.txt");
        printOut(story, 60);
    }
    


}

