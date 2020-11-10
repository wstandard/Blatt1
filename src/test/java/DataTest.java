import de.unitrier.st.core.CountryDataPoint;
import de.unitrier.st.core.DataLoader;
import de.unitrier.st.core.DataParser;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class DataTest {

    private List<CountryDataPoint> germany;

    @Before
    public void setUp() {
        DataLoader dataLoader = new DataLoader();
        DataParser dataParser = new DataParser();
        String json = dataLoader.loadJsonFile("countries-aggregated_json.json");
        Map<String, List<CountryDataPoint>> countries = dataParser.parseJsonData(json);
        germany = countries.get("Germany");
    }

    @Test
    public void confirmedTest() {
        Assert.assertEquals(germany.get(98).Confirmed, 161539);
    }

    @Test
    public void deathsTest() {
        Assert.assertEquals(germany.get(98).Deaths, 6467);    }

    @Test
    public void recoveredTest() {
        Assert.assertEquals(germany.get(98).Recovered, 120400);
    }

    @Test
    public void DateTest() {
        Assert.assertEquals(germany.get(98).Date, "2020-04-29");
    }
}
