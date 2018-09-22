
/**
 * Write a description of WhichCountriesExport here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import org.apache.commons.csv.*;

public class WhichCountriesExport {
    public void listExporters(CSVParser parser, String exportOfInterest) {
        for (CSVRecord record : parser) {
            String export = record.get("Exports");
            if (export.contains(exportOfInterest)) {
                String country = record.get("Country");
                System.out.println(country);
            }
        }
    }
    
    public void countryInfo(CSVParser parser, String country) {
        for (CSVRecord record : parser) {
            if (record.get("Country").equals(country)) {
                String exports = record.get("Exports");
                String value = record.get("Value (dollars)");
                if (exports==null) {
                exports = "NOT FOUND";
                }
                if (value==null) {
                value = "NOT FOUND";
                }
                System.out.println(country + ": " + exports + ": " + value);
        }
    }
    }   
    
    public void listExportersTwoProducts(CSVParser parser, String exportItem1, String exportItem2){
        for (CSVRecord record : parser) {
            String exports = record.get("Exports");
            if (exports.contains(exportItem1) && exports.contains(exportItem2)) {
                System.out.println(record.get("Country"));
            }
        }
    }
    
    public void numberOfExporters(CSVParser parser, String exportItem) {
        int count = 0;
        for (CSVRecord record : parser) {
            String exports = record.get("Exports");
            if (exports.contains(exportItem)) {
                count++;
            }
        }
        System.out.printf("Number of Exporters: " + count);
    }
    
    public void bigExporters(CSVParser parser, String amount) {
        for (CSVRecord record : parser) {
            String value = record.get("Value (dollars)");
            if (value.length() > amount.length()) {
                System.out.println(record.get("Country") +" " + value);
            }
        }
    }
    
    public void whoExportsCoffee() {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        listExporters(parser, "cocoa");
    }
    
    public void countryInfoTest() {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        countryInfo(parser, "Nauru");
    }
    
    public void twoProductsTest() {
       FileResource fr = new FileResource();
       CSVParser parser = fr.getCSVParser();
       listExportersTwoProducts(parser, "cotton", "flowers");
    }
    
    public void numberOfExportersTest() {
       FileResource fr = new FileResource();
       CSVParser parser = fr.getCSVParser();
       numberOfExporters(parser, "gold");
    }
    
    public void bigExportersTest() {
       FileResource fr = new FileResource();
       CSVParser parser = fr.getCSVParser();
       bigExporters(parser, "$999,999,999,999");
    }
}
