import org.apache.commons.csv.*;
import edu.duke.*;

public class week3 {

    FileResource fr;
    CSVParser parser;


    public week3(String s) {
        fr = new FileResource(s);
        parser = fr.getCSVParser();

    }


    public void countryInfo(String country) {
        parser = fr.getCSVParser();
        for (CSVRecord record : parser){
        String countrylist = record.get("Country") + record.get("Exports") + record.get("Value (dollars)");
            if(countrylist.contains(country)){
                System.out.println(countrylist);
            }


        }
}

    public void listExportersTwoProducts(String exportItem1, String exportItem2) {
        parser = fr.getCSVParser();
        for (CSVRecord record : parser) {
            String exports = record.get("Exports");
            if (exports.contains(exportItem1) && (exports.contains(exportItem2))) {
                String country = record.get("Country");
                System.out.println(country);

            }
        }
    }

	public int numberOfExporters(String exportItem3){
            parser = fr.getCSVParser();
            int countries = 0;
            for (CSVRecord record : parser) {
                String countriesWhoExport = record.get("Exports");
                if (countriesWhoExport.contains(exportItem3)){
                    countries++;
                    System.out.println(countries);
                }
            } return countries;
        }

    public String bigExporters(String amount) {
        parser = fr.getCSVParser();
        String countries = null;
        for (CSVRecord record : parser) {
            String largeExports = record.get("Value (dollars)");
            countries = record.get("Country");
            int compare = largeExports.length();
            int compare1 = amount.length();
            if (compare > compare1) {
                System.out.println(countries);
                System.out.println(largeExports);


            }
        }
        return countries;
    }
}
