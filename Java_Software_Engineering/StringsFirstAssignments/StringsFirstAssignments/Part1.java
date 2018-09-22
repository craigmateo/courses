
/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part1 {
    public String findGeneSimple(String dna) {
        // start codon is "ATG"
        // stop codon is "TAA"
        String result = "";
        int startIndex = dna.indexOf("ATG");
        int stopIndex = dna.indexOf("TAA", startIndex+3);
        if (startIndex == -1 || stopIndex == -1) {
            result = "";
        }
        else {
            String output = dna.substring(startIndex, stopIndex+3);
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
    }

}
