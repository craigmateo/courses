
/**
 * Write a description of class QuakeSortInPlace here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;
import edu.duke.*;

public class QuakeSortInPlace {
    public QuakeSortInPlace() {
        // TODO Auto-generated constructor stub
    }
   
    public int getSmallestMagnitude(ArrayList<QuakeEntry> quakes, int from) {
        int minIdx = from;
        for (int i=from+1; i< quakes.size(); i++) {
            if (quakes.get(i).getMagnitude() < quakes.get(minIdx).getMagnitude()) {
                minIdx = i;
            }
        }
        return minIdx;
    }
    
    public void sortByMagnitude(ArrayList<QuakeEntry> in) {
       
       for (int i=0; i< in.size(); i++) {
            int minIdx = getSmallestMagnitude(in,i);
            QuakeEntry qi = in.get(i);
            QuakeEntry qmin = in.get(minIdx);
            in.set(i,qmin);
            in.set(minIdx,qi);
        }
        
    }
    
    public int getLargestDepth(ArrayList<QuakeEntry> quakeData, int from) {
        int indDeepest = from;
        for (int i =from+1; i< quakeData.size();i++) {
            double deepestSoFar = quakeData.get(indDeepest).getDepth();
            double depth = quakeData.get(i).getDepth();
            if (depth<deepestSoFar) {
                indDeepest=i;
            }
        }
        return indDeepest;
    }
    
    public void sortByLargestDepth (ArrayList<QuakeEntry> quakeData) {
        //This method calls the method getLargestDepth repeatedly until the ArrayList is sorted.
        //int limit = quakeData.size();
    	int limit = 70;
    	for (int i=0; i<limit; i++) {
    		int indDeepest = getLargestDepth(quakeData, i);
    		QuakeEntry qi = quakeData.get(i);
    		QuakeEntry qDeepest = quakeData.get(indDeepest);
    		quakeData.set(i, qDeepest);
    		quakeData.set(indDeepest, qi);
    }
    }

    public void onePassBubbleSort (ArrayList<QuakeEntry> quakeData, int numSorted) {
        for (int i=1; i< quakeData.size()-numSorted; i++) {
			if (quakeData.get(i-1).getMagnitude() > quakeData.get(i).getMagnitude()) {
				QuakeEntry qireduceone = quakeData.get(i-1);
				QuakeEntry qi = quakeData.get(i);
				quakeData.set(i-1,qi);
				quakeData.set(i,qireduceone);       
			}
		}
    }
   
    public void sortByMagnitudeWithBubbleSort(ArrayList<QuakeEntry> in) {
        for (int i=0; i<in.size();i++) {
    		onePassBubbleSort(in, i);
        }
    }
    
    public boolean checkInSortedOrder (ArrayList<QuakeEntry> quakes) {
        for (int i=1; i<= quakes.size()-1; i++) {
			if (quakes.get(i-1).getMagnitude() > quakes.get(i).getMagnitude()) {
				return false;
			}
		}
		return true;
    }
    
    public void sortByMagnitudeWithBubbleSortWithCheck (ArrayList<QuakeEntry> in) {
        for (int i=0; i< in.size()-1; i++) {
			if(checkInSortedOrder(in)) {
				System.out.println(i + " passes were needed to sort the elements."); 
				break;
			}
			onePassBubbleSort(in, i);
         //			System.out.println("Printing Quakes after pass " + i);
         //			for (QuakeEntry qe: in) { 
         //				System.out.println(qe);
         //			}
		}
    }
    
    public void sortByMagnitudeWithCheck (ArrayList<QuakeEntry> in) {
        for (int i=0; i< in.size(); i++) {
			if(checkInSortedOrder(in)) {
				System.out.println(i + " passes were needed to sort the elements."); 
				break;
			}
			int minIdx = getSmallestMagnitude(in,i);
			QuakeEntry qi = in.get(i);
			QuakeEntry qmin = in.get(minIdx);
			in.set(i,qmin);
			in.set(minIdx,qi);
		}
    
    }
    
    public void testSort() {
        EarthQuakeParser parser = new EarthQuakeParser(); 
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        //String source = "data/nov20quakedatasmall.atom";
        //String source = "data/nov20quakedata.atom";
        String source = "data/earthQuakeDataWeekDec6sample1.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);  
       
        System.out.println("read data for "+list.size()+" quakes");    
        //sortByMagnitude(list);
        //sortByLargestDepth(list);
        //sortByMagnitudeWithBubbleSort(list);
        sortByMagnitudeWithBubbleSortWithCheck(list); 
        //sortByMagnitudeWithCheck(list);
        for (QuakeEntry qe: list) { 
            System.out.println(qe);
        } 
        
    }
    
    public void createCSV() {
        EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "data/nov20quakedata.atom";
        String source = "data/nov20quakedatasmall.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        dumpCSV(list);
        System.out.println("# quakes read: " + list.size());
    }
    
    public void dumpCSV(ArrayList<QuakeEntry> list) {
        System.out.println("Latitude,Longitude,Magnitude,Info");
        for(QuakeEntry qe : list){
            System.out.printf("%4.2f,%4.2f,%4.2f,%s\n",
                              qe.getLocation().getLatitude(),
                              qe.getLocation().getLongitude(),
                              qe.getMagnitude(),
                              qe.getInfo());
        }
        
    }
}
