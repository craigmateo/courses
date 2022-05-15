
/**
 * Write a description of Part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part2 {
    public String findGeneSimple(String dna) {
        // start codon is "ATG"
        // stop codon is "TAA"
        String result = "";
        String startCodon = "";
        String stopCodon = "";
        boolean isUpperCase = Character.isUpperCase(dna.charAt(0));
        if (isUpperCase) {
            startCodon = "ATG";
            stopCodon = "TAA";
        }
        else {
            startCodon = "atg";
            stopCodon = "taa";
        }
        
        int startIndex = dna.indexOf(startCodon);
        int stopIndex = dna.indexOf(stopCodon, startIndex+3);
        if (startIndex == -1 || stopIndex == -1) {
            result = "";
        }
        else {
            String output = dna.substring(startIndex, stopIndex+3);
            startCodon = dna.substring(startIndex, startIndex+3);
            stopCodon = dna.substring(stopIndex, stopIndex+3);
            if (output.length()%3 == 0) {
                result = output;
            }
            else {
                result = "";
            }
            
        }
        return result;
    }
    
    public void testFindGeneSimple(){
       System.out.println("***** TEST 1 ***** ");
       String dna = "ATGAGTGTGTTAA";
       System.out.println("DNA strand is " + dna);
       String gene = findGeneSimple(dna);
       System.out.println("Gene is " + gene);
       
       System.out.println("***** TEST 2 ***** ");
       dna = "ATGAGTGTGTTGA";
       System.out.println("DNA strand is " + dna);
       gene = findGeneSimple(dna);
       System.out.println("Gene is " + gene);
       
       System.out.println("***** TEST 3 ***** ");
       dna = "ATTAGTGTGTTAA";
       System.out.println("DNA strand is " + dna);
       gene = findGeneSimple(dna);
       System.out.println("Gene is " + gene);
       
       System.out.println("***** TEST 4 ***** ");
       dna = "ATGAGTGTGTTGTAA";
       System.out.println("DNA strand is " + dna);
       gene = findGeneSimple(dna);
       System.out.println("Gene is " + gene);
       
       System.out.println("***** TEST 5 ***** ");
       dna = "atgtagtatatttaa";
       System.out.println("DNA strand is " + dna);
       gene = findGeneSimple(dna);
       System.out.println("Gene is " + gene);
    }

}
