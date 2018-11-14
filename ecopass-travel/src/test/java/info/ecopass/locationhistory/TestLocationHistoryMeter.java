package info.ecopass.locationhistory;

import org.junit.Assert;
import org.junit.Test;

public class TestLocationHistoryMeter {

    private LocationHistoryMeter locationHistoryMeter = new LocationHistoryMeter();

    @Test
    public void emptyTest(){
    }

    @Test
    public void yieldsSustainable(){
        Assert.assertEquals("SustainabLe", locationHistoryMeter.getSustainable());
    }


}
