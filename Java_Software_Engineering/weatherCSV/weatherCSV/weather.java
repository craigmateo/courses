
/**
 * Write a description of weather here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;

public class weather {
    public CSVRecord coldestHourInFile(CSVParser parser) {
        CSVRecord coldestSoFar = null;
        for (CSVRecord currentRow : parser) {
        if (coldestSoFar == null) {
            coldestSoFar = currentRow;
        }
        else {
            double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
            double coldestTemp = Double.parseDouble(coldestSoFar.get("TemperatureF"));
            if (currentTemp < coldestTemp && currentTemp != -9999) {
                coldestSoFar = currentRow;
            }
        }
    }
    return coldestSoFar;
   }
   
      public CSVRecord lowestHumidityInFile(CSVParser parser) {
        CSVRecord leastHumidSoFar = null;
        for (CSVRecord currentRow : parser) {
        if (leastHumidSoFar == null) {
            leastHumidSoFar = currentRow;
        }
        else {
			if(currentRow.get("Humidity") != "N/A") {
            double currentHumid = Double.parseDouble(currentRow.get("Humidity"));
			double leastHumid = Double.parseDouble(leastHumidSoFar.get("Humidity"));
         		if (currentHumid < leastHumid) {
                leastHumidSoFar = currentRow;
            }
        }
        }
    }
    return leastHumidSoFar;
   }

   public CSVRecord coldestTemperature() {
       CSVRecord coldestSoFar = null;
       DirectoryResource dr = new DirectoryResource();
       for (File f : dr.selectedFiles()) {
           FileResource fr = new FileResource(f);
           CSVRecord currentRow = coldestHourInFile(fr.getCSVParser());
           if (coldestSoFar == null) {
               coldestSoFar = currentRow;
           }
           else {
               double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
               double coldestTemp = Double.parseDouble(coldestSoFar.get("TemperatureF"));
               if (currentTemp < coldestTemp && currentTemp != -9999) {
                   coldestSoFar = currentRow;
               }
            }
        }
       return coldestSoFar;
   }
   
   public CSVRecord lowestHumidity() {
       CSVRecord leastHumidSoFar = null;
       DirectoryResource dr = new DirectoryResource();
       for (File f : dr.selectedFiles()) {
           FileResource fr = new FileResource(f);
           CSVRecord currentRow = lowestHumidityInFile(fr.getCSVParser());
           if (leastHumidSoFar == null) {
               leastHumidSoFar = currentRow;
           }
           else {
			if(currentRow.get("Humidity") != "N/A") {
            double currentHumid = Double.parseDouble(currentRow.get("Humidity"));
			double leastHumid = Double.parseDouble(leastHumidSoFar.get("Humidity"));
         		if (currentHumid < leastHumid) {
                leastHumidSoFar = currentRow;
            }
           }
           }
        }
       return leastHumidSoFar;
   }

   public String fileWithColdestTemperature() {
       String coldestFile = "";
       CSVRecord coldestSoFar = null;
       DirectoryResource dr = new DirectoryResource();
       for (File f : dr.selectedFiles()) {
           FileResource fr = new FileResource(f);
           CSVRecord currentRow = coldestHourInFile(fr.getCSVParser());
           if (coldestSoFar == null) {
               coldestSoFar = currentRow;
               coldestFile = "";
           }
           else {
               double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
               double coldestTemp = Double.parseDouble(coldestSoFar.get("TemperatureF"));
               if (currentTemp < coldestTemp && currentTemp != -9999) {
                   coldestSoFar = currentRow;
                   coldestFile = f.toString();
               }
            }
        }
       return coldestFile;
   }
  
   public String lowestHumidityInManyFiles() {
       String lowestHumidityFile = "";
       CSVRecord lowestSoFar = null;
       DirectoryResource dr = new DirectoryResource();
       for (File f : dr.selectedFiles()) {
           FileResource fr = new FileResource(f);
           CSVRecord currentRow = lowestHumidityInFile(fr.getCSVParser());
           if (lowestSoFar == null) {
               lowestSoFar = currentRow;
               lowestHumidityFile = "";
           }
           else {
				if(currentRow.get("Humidity") != "N/A") {
            	double currentHumid = Double.parseDouble(currentRow.get("Humidity"));
				double leastHumid = Double.parseDouble(lowestSoFar.get("Humidity"));
         		if (currentHumid < leastHumid) {
                lowestSoFar = currentRow;
            	}
           		}
           }
        }
       return lowestHumidityFile;
   }

   public double averageTemperatureInFile(CSVParser parser) {
        double total = 0;
		int count = 0;
        for (CSVRecord currentRow : parser) {
		String temp = currentRow.get("TemperatureF");
        if (temp == "N/A") {
            total = total;
			count = count;
        }
        else {
            double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
			total = total + currentTemp;
			count++;
        }
    }
    double average = total/count;
    return average;
   } 

   public double averageTemperatureWithHighHumidityInFile(CSVParser parser, int value) {
        double total = 0;
		int count = 0;
        for (CSVRecord currentRow : parser) {
		String temp = currentRow.get("TemperatureF");
        String humid = currentRow.get("Humidity");
        if (temp == "N/A" || humid == "N/A") {
            total = total;
			count = count;
        }
        else {
            double currentTemp = Double.parseDouble(temp);
            double currentHumid = Double.parseDouble(humid);
			if (currentHumid >= value) {
				total = total + currentTemp;
				count++;
			}
			else {
			  	total = total;
				count = count;
			 }
        }
    }
    if (count == 0) {
    double average = 0;
	return average;
    }
	else {
	double average = total/count;
	return average;
    }
   } 

   public void coldestFileAll(CSVParser parser) {
        for (CSVRecord currentRow : parser) {
            String date = currentRow.get("DateUTC");
			String temp = currentRow.get("TemperatureF");
			System.out.println(date + ": " + temp);
        }
    }  

   public void lowestHumidAll(CSVParser parser) {
        for (CSVRecord currentRow : parser) {
            String date = currentRow.get("DateUTC");
			String humid = currentRow.get("Humidity");
			System.out.println(date + ": " + humid);
        }
    } 

   public void testLowestHumidityInFile() {
   		FileResource fr = new FileResource("data/2014/weather-2014-07-22.csv");
		CSVParser parser = fr.getCSVParser();
		CSVRecord csv = lowestHumidityInFile(parser);
		System.out.println("Lowest Humidity was " + csv.get("Humidity") + " at " + csv.get("DateUTC"));
   }    

   public void testColdestHourInFile() {
       FileResource fr = new FileResource("data/2014/weather-2014-05-01.csv");
       CSVRecord coldest = coldestHourInFile(fr.getCSVParser());
       System.out.println("coldest temperature was " + coldest.get("TemperatureF") + " at " + coldest.get("DateUTC"));
   }
   
   public void testAverageTemperatureInFile() {
       FileResource fr = new FileResource("data/2013/weather-2013-08-10.csv");
       double average = averageTemperatureInFile(fr.getCSVParser());
       System.out.printf("Average temperature in file is " + average);
   }

   public void testAverageTemperatureWithHighHumidityInFile() {
       FileResource fr = new FileResource("data/2013/weather-2013-09-02.csv");
	   int value = 80;
       double average = averageTemperatureWithHighHumidityInFile(fr.getCSVParser(), value);
	   if (average != 0) {
       System.out.printf("Average temperature in file is " + average);
       }
       else {
       System.out.printf("No temperatures with that humidity");
       }
   }

   public void testFileWithColdestTemperature() {
       String coldestFile = fileWithColdestTemperature();
       CSVRecord coldest = coldestTemperature();
       System.out.println("Coldest day was in file " + coldestFile);
       System.out.println("Coldest temperature on that day was " + coldest.get("TemperatureF") + " at " + coldest.get("DateUTC"));
       FileResource fr = new FileResource(coldestFile);
	   System.out.println("All the temperatures on the coldest day were:");
	   coldestFileAll(fr.getCSVParser());
    }

   public void testLowestHumidityInManyFiles() {
       String lowestFile = lowestHumidityInManyFiles();
       CSVRecord lowest = lowestHumidity();
       System.out.println("Lowest Humidity was " + lowest.get("Humidity") + " at " + lowest.get("DateUTC"));
    }
}
