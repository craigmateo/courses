
/**
 * Write a description of UniqueIPTester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class UniqueIPTester {
    public void testUniqIP(){
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("weblog2_log");
        int uniqueIPs = la.countUniqueIPs();
        System.out.println("There are " + uniqueIPs + " IPs");
    }
    
    public void testMostNumberVisitsByIP(){
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("weblog2_log");
        System.out.println(la.mostNumberVisitsByIP(la.countVisitsPerIP()));
    }
    
    public void testiPsMostVisits() {
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("weblog2_log");
        System.out.println(la.iPsMostVisits(la.countVisitsPerIP()));
    }
}
