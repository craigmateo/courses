
/**
 * Write a description of class MarkovRunner here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.*;

public class MarkovRunner {
    public void runModel(IMarkovModel markov, String text, int size){ 
        markov.setTraining(text); 
        System.out.println("running with " + markov); 
        for(int k=0; k < 3; k++){ 
            String st = markov.getRandomText(size); 
            printOut(st); 
        } 
    } 

    public void runModel(IMarkovModel markov, String text, int size, int seed){ 
        markov.setTraining(text); 
        markov.setRandom(seed);
        System.out.println("running with " + markov); 
        for(int k=0; k < 3; k++){ 
            String st = markov.getRandomText(size); 
            printOut(st); 
        } 
    } 
    
    public void runMarkovZero() {
    FileResource fr = new FileResource("data/confucius.txt");
    String st = fr.asString();
    st = st.replace('\n', ' ');
    MarkovZero markov = new MarkovZero();
    markov.setTraining(st);
    markov.setRandom(1024);
    for (int k = 0; k < 3; k++) {
      String text = markov.getRandomText(500);
      printOut(text);
    }
    }
    
    public void runMarkov() { 
        FileResource fr = new FileResource(); 
        String st = fr.asString(); 
        st = st.replace('\n', ' '); 
        MarkovWordOne markovWord = new MarkovWordOne(); 
        runModel(markovWord, st, 200); 
    } 

    private void printOut(String s){
        String[] words = s.split("\\s+");
        int psize = 0;
        System.out.println("----------------------------------");
        for(int k=0; k < words.length; k++){
            System.out.print(words[k]+ " ");
            psize += words[k].length() + 1;
            if (psize > 60) {
                System.out.println(); 
                psize = 0;
            } 
        } 
        System.out.println("\n----------------------------------");
    } 

     public void testHashMap() {
//        String st = "this is a test yes this is really a test";
//    	String st = "this is a test yes this is really a test yes a test this is wow";
        FileResource fr = new FileResource("data/confucius.txt"); 
        String st = fr.asString(); 
        st = st.replace('\n', ' ');
        EfficientMarkovWord efficientMarkovWord = new EfficientMarkovWord(2);
//        EfficientMarkovWord efficientMarkovWord = new EfficientMarkovWord(3);
//        runModel(efficientMarkovWord, st, 120, 42);
//        runModel(efficientMarkovWord, st, 50, 42);
//        runModel(efficientMarkovWord, st, 50, 371);
        runModel(efficientMarkovWord, st, 50, 65);
    }
    
    public void runMarkovWord() {
        FileResource fr = new FileResource("data/confucius.txt"); 
        String st = fr.asString(); 
        st = st.replace('\n', ' '); 
        //MarkovWord markovWord = new MarkovWord(3);
        MarkovWord markovWord = new MarkovWord(5);
//        runModel(markovWord, st, 120, 643);
        //runModel(markovWord, st, 120, 621);
        runModel(markovWord, st, 120, 844);
    }
    
    public void compareMethods(){
        FileResource fr = new FileResource("data/hawthorne.txt");
		String st = fr.asString();
		st = st.replace('\n', ' ');
		int seed = 42;
		int size = 100;
		
		double startTime = System.nanoTime();
        MarkovWord mTwo = new MarkovWord(2);
        runModel(mTwo, st, size, seed);
        double endTime = System.nanoTime();
        System.out.println("The running time of MarkovWord is " + (endTime-startTime)/ 1000000000.0 + " seconds");
		
        startTime = System.nanoTime();
		EfficientMarkovWord emw = new EfficientMarkovWord(2);
        runModel(emw, st, size, seed);
        endTime = System.nanoTime();
        System.out.println("The running time of EfficientMarkovWord is " + (endTime-startTime)/ 1000000000.0 + " seconds");
    }
    
}
