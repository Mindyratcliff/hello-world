import org.junit.Test;

import static org.junit.Assert.*;

public class week3OverallTest {
    @Test
    public void countryInfo() throws Exception {
        Week3 week3 = new Week3("exportdata.csv");
        week3.countryInfo("Nauru");
    }

    @Test
    public void listExportersTwoProducts() throws Exception {
        Week3 week3 = new Week3 ("exportdata.csv");
        week3.listExportersTwoProducts("cotton","flowers");
    }

    @Test
    public void numberOfExporters() throws Exception {
        Week3 week3 = new Week3("exportdata.csv");
        week3.numberOfExporters("cocoa");
    }

    @Test
    public void bigExporters() throws Exception {
        Week3 week3 = new Week3("exportdata.csv");
        week3.bigExporters("$999,999,999,999");
    }

}