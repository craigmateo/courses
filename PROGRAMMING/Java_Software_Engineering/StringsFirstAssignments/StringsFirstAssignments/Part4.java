
/**
 * Write a description of Part4 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.io.*;

public class Part4 {
    public void urlList() {
    String youTube = "www.youtube.com";
    String quoteStart = "\""+"http";
    String quote = "\"";
    URLResource ur = new URLResource("http://www.dukelearntoprogram.com/course2/data/manylinks.html");
    for (String s : ur.lines()) {
        String str = s.toLowerCase();
        if (str.contains(youTube)) {
            int index1 = s.indexOf(quoteStart);
            int index2 = s.indexOf(quote, index1+1);
            System.out.println(s.substring(index1+1, index2));
        }
 }
}
}
