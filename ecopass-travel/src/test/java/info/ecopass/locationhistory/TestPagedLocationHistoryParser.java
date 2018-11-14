package info.ecopass.locationhistory;

import org.junit.Test;

public class TestPagedLocationHistoryParser {

    @Test (expected = IllegalArgumentException.class)
    public void pageSizeMustBeBiggerThanZero(){
        PagedLocationHistoryParser pagedLocationHistoryParser = new PagedLocationHistoryParser(0, "pathToJson");
    }
}
