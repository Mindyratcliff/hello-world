import edu.duke.DirectoryResource;
import edu.duke.*;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.*;

public class Week3ColdestDayAssignment {


    public CSVRecord hottestHourInFile(CSVParser parser) {
        CSVRecord largestSoFar = null;
        for (CSVRecord currentRow : parser) {
            largestSoFar = getLargestOfTwo(currentRow, largestSoFar);
        }
        return largestSoFar;
    }

    public CSVRecord hottestInManyDays() {
        CSVRecord largestSoFar = null;
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            CSVRecord currentRow = hottestHourInFile(fr.getCSVParser());
            largestSoFar = getLargestOfTwo(currentRow, largestSoFar);
        }
        return largestSoFar;
    }


    public CSVRecord getLargestOfTwo(CSVRecord currentRow, CSVRecord largestSoFar) {
        if (largestSoFar == null) {
            largestSoFar = currentRow;
        } else {
            double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
            double largestTemp = Double.parseDouble(largestSoFar.get("TemperatureF"));
            if (currentTemp > largestTemp) {
                largestSoFar = currentRow;
            }
        }

        return largestSoFar;
    }

    public CSVRecord coldestHourInFile(CSVParser parser) {
        CSVRecord lowestSoFar = null;
        for (CSVRecord currentRow : parser) {
            lowestSoFar = getColdestOfTwo(currentRow, lowestSoFar);
        }
        return lowestSoFar;
    }


    public CSVRecord getColdestOfTwo(CSVRecord currentRow, CSVRecord lowestSoFar) {
        if (lowestSoFar == null) {
            lowestSoFar = currentRow;
        } else {
            double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
            double lowestTemp = Double.parseDouble(lowestSoFar.get("TemperatureF"));
            if (currentTemp < lowestTemp) {
                lowestSoFar = currentRow;
            }
        }

        return lowestSoFar;
    }

    public CSVRecord coldestInManyDays() {
        CSVRecord lowestSoFar = null;
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            CSVRecord currentRow = coldestHourInFile(fr.getCSVParser());
            lowestSoFar = getColdestOfTwo(currentRow, lowestSoFar);
        }
        return lowestSoFar;

    }

    public CSVRecord lowestHumidityInFile(CSVParser parser) {
        CSVRecord lowestSoFar = null;
        for (CSVRecord currentRow : parser) {
            String humidity = currentRow.get("Humidity");
            if (!humidity.equals("N/A")) {
                lowestSoFar = leastMoistOfTwo(currentRow, lowestSoFar);
            }
        }
        return lowestSoFar;

    }

    public CSVRecord leastMoistOfTwo(CSVRecord currentRow, CSVRecord lowestSoFar) {
        if (lowestSoFar == null) {
            lowestSoFar = currentRow;
        } else {
            double currentMoist = Double.parseDouble(currentRow.get("Humidity"));
            double lowestMoist = Double.parseDouble(lowestSoFar.get("Humidity"));
            if (currentMoist < lowestMoist) {
                lowestSoFar = currentRow;
            }
        }
        return lowestSoFar;
    }

    public CSVRecord lowestHumidityInManyDays() {
        CSVRecord lowestSoFar = null;
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            CSVRecord currentRow = lowestHumidityInFile(fr.getCSVParser());
            lowestSoFar = leastMoistOfTwo(currentRow, lowestSoFar);
        }
        return lowestSoFar;


    }


    public Double averageTemperatureInFile(CSVParser parser) {
        double temperature = 0;
        int count = 0;
        for (CSVRecord currentRow : parser) {
            if (currentRow != null)
                count++;
            double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
            temperature = currentTemp + temperature;


        }


        double averageTemp = temperature / count;


        return averageTemp;
    }

    public Double averageTemperatureWithHighHumidityInFile(CSVParser parser, int value) {
        double temperature = 0;
        int count = 0;
        for (CSVRecord currentRow : parser) {
            double humidity = Double.parseDouble(currentRow.get("Humidity"));
            if (currentRow != null && humidity >= value) {
                count++;
                double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
                temperature = currentTemp + temperature;


            }
        }


            double averageTemp = temperature / count;


            return averageTemp;

    }
}

















