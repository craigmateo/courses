
/**
 * Write a description of Part3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part3 {
    public boolean twoOccurances(String stringa, String stringb) {
        int count = 0;
        while(stringb.indexOf(stringa) != -1) {
            count+=1;
            stringb = stringb.substring(stringb.indexOf(stringa)+1);
        }
        
        if (count >= 2) {
            return true;
        }
        else {
            return false;
        }
    }
    
    public void testTwoOccurances(){
        String stringa = "by";
        String stringb = "bydfsdfsbyfsdfbydfsdby";
        boolean result = twoOccurances(stringa, stringb);
        System.out.println(result);
    }
    public void lastPart(String stringa, String stringb) {
        
    }
}

    
