import edu.duke.*;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.junit.Test;

import static org.junit.Assert.*;

public class Week3ColdestDayAssignmentTest {
    @Test
    public void averageTemperatureWithHighHumidityInFile() throws Exception {
        Week3ColdestDayAssignment week3ColdestDayAssignment = new Week3ColdestDayAssignment();
        FileResource fr = new FileResource();
        double average = week3ColdestDayAssignment.averageTemperatureWithHighHumidityInFile(fr.getCSVParser(),80);
        System.out.println(average);
    }


    @Test
    public void averageTemperatureInFile() throws Exception {
        Week3ColdestDayAssignment week3ColdestDayAssignment = new Week3ColdestDayAssignment();
        FileResource fr = new FileResource();
        double average = week3ColdestDayAssignment.averageTemperatureInFile(fr.getCSVParser());
        System.out.println(average);

    }

    @Test
    public void lowestHumidityInManyDays() throws Exception {
        Week3ColdestDayAssignment week3ColdestDayAssignment = new Week3ColdestDayAssignment();
        CSVRecord coldest = week3ColdestDayAssignment.lowestHumidityInManyDays();
        System.out.println(coldest.get("Humidity"));
        System.out.println(coldest.get("DateUTC"));
    }


    @Test
    public void lowestHumidityInFile() throws Exception {
        Week3ColdestDayAssignment week3ColdestDayAssignment = new Week3ColdestDayAssignment();
        FileResource fr = new FileResource();
        CSVRecord coldest = week3ColdestDayAssignment.lowestHumidityInFile(fr.getCSVParser());
        System.out.println(coldest.get("Humidity"));
        System.out.println(coldest.get("DateUTC"));
    }

    @Test
    public void coldestInManyDays() throws Exception {
        Week3ColdestDayAssignment week3ColdestDayAssignment = new Week3ColdestDayAssignment();
        CSVRecord coldest = week3ColdestDayAssignment.coldestInManyDays();
        System.out.println(coldest.get("TemperatureF"));
        System.out.println(coldest.get("DateUTC"));

    }

    @Test
    public void hottestInManyDays() throws Exception {
        Week3ColdestDayAssignment week3ColdestDayAssignment = new Week3ColdestDayAssignment();
        CSVRecord hottest = week3ColdestDayAssignment.hottestInManyDays();
        System.out.println(hottest.get("TemperatureF"));
    }

}