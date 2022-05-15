
/**
 * Write a description of class LogAnalyzer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;
import edu.duke.*;

public class LogAnalyzer
{
     private ArrayList<LogEntry> records;
     
     public LogAnalyzer() {
         records = new ArrayList<LogEntry>();
     }
        
     public void readFile(String filename) {
         FileResource fr = new FileResource(filename);
         for (String line : fr.lines()) {
             records.add(WebLogParser.parseEntry(line));
         }
     }
     
     public HashMap<String,Integer> countVisitsPerIP(){
         // Make empty HashMap counts
         HashMap<String,Integer> counts = new HashMap<String, Integer>();
         // For each le in records
         for (LogEntry le: records){
             //ip is le's ipAddress
             String ip = le.getIpAddress();
             // check if ip is in counts
             if (!counts.containsKey(ip)){
                 // If not: put ip in with a value of 1
                 counts.put(ip,1);
                }
                // If so: update the value by 1
             else {
                 counts.put(ip,counts.get(ip)+1);
                }
            }
         return counts;
        }
      
     public int mostNumberVisitsByIP(HashMap<String,Integer> map){
         int max = 0;
         for (Integer value : map.values()) {
             if (value > max){
                max = value;
                }
         }
         return max;
        }
        
     public ArrayList<String> iPsMostVisits(HashMap<String,Integer> map){
         int max = mostNumberVisitsByIP(map);
         ArrayList<String> uniqueIPs = new ArrayList<String>();
         for (Map.Entry<String, Integer> entry : map.entrySet()) {
             int count = entry.getValue();
             if (count >= max) {
                 String ip = entry.getKey();
                 uniqueIPs.add(ip);
            }
        }
        return uniqueIPs;
        }
        
     public HashMap<String, ArrayList<String>> iPsForDays() {
         HashMap<String, ArrayList<String>> eachday = new HashMap<String, ArrayList<String>>();
         for (LogEntry le:records) {
             String whole = le.getAccessTime().toString();
             String date = whole.substring(8, 10);
             String month = whole.substring(4, 7);
             String time = month + " " + date;
             String ip = le.getIpAddress();
             if (!eachday.containsKey(time)) {
                 eachday.put(time, new ArrayList<String>());
             }
             eachday.get(time).add(ip);
         }
         return eachday;
     }
     
     public String dayWithMostIPVisits(HashMap<String, ArrayList<String>> eachday) {
        String mosttime=null;
        int most = 0;
        int current;
        for (String time: eachday.keySet()) {
            current = eachday.get(time).size();
            if (most < current) {
                most = current;
                mosttime = time;
            }
        }
        return mosttime;
     }    
     
     public ArrayList<String> iPsWithMostVisitsOnDay(HashMap<String, ArrayList<String>> eachday, String day) {
        ArrayList<String> ip = new ArrayList<String>();
        HashMap<String, Integer> eachip = new HashMap<String, Integer>();
        ArrayList<String> mostthatday = new ArrayList<String>();
        int mostnumber = 0;
        int currentnumber;
        for (String time: eachday.keySet()) {
            if (time.equals(day)) {
                ip = eachday.get(time);
            }
        }
        for (int k = 0; k < ip.size(); k++) {
            if (!eachip.containsKey(ip.get(k))) {
                eachip.put(ip.get(k), 1);
            }
            else eachip.put(ip.get(k), eachip.get(ip.get(k))+1);
        }
        mostthatday = iPsMostVisits(eachip);
        return mostthatday;
     }

     
     
     public void printAll() {
         for (LogEntry le : records) {
             System.out.println(le);
         }
      }
    
     
     public int countUniqueIPs() {
         ArrayList<String> uniqueIPs = new ArrayList<String>();
         for (LogEntry le: records) {
             String ipAddr = le.getIpAddress();
             
             if (!uniqueIPs.contains(ipAddr)) {
                uniqueIPs.add(ipAddr);
                }
            }
         return uniqueIPs.size();
     }
     
     public void printAllHigherThanNum(int num){
        ArrayList<Integer> greaterThan = new ArrayList<Integer>();
        for (LogEntry le: records) {
             int code = le.getStatusCode();
             
             if (code > num) {
                greaterThan.add(code);
                }
            }
        for (int code: greaterThan) {
             System.out.println(code+"\t");
            }
     }
     
     public int uniqueIPVisitsOnDay(String someday) {
        ArrayList<String> uniqueip = new ArrayList<String>();
         for (LogEntry le:records) {
             String whole = le.getAccessTime().toString();
             String date = whole.substring(8, 10);
             String month = whole.substring(4, 7);
             if (someday.substring(0,3).equals(month) && someday.substring(4,6).equals(date)) {
                 String ip = le.getIpAddress();
                 System.out.println(ip);
                 if (!uniqueip.contains(ip)) {
                     uniqueip.add(ip);
                }
         }
         
        }
        return uniqueip.size();
     }
     
     public int countUniqueIPsInRange(int low, int high) {
        ArrayList<String> uniqueip = new ArrayList<String>();
        for (LogEntry le: records) {
             int code = le.getStatusCode();
             if (code >=low && code <= high) {
                String ip = le.getIpAddress();
                if (!uniqueip.contains(ip)) {
                     uniqueip.add(ip);
             }
            }
            }
        return uniqueip.size();
     }
}