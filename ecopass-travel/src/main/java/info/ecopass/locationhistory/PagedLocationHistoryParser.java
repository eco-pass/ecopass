package info.ecopass.locationhistory;

public class PagedLocationHistoryParser {
    public PagedLocationHistoryParser(int pageSize, String pathToJson) {
        if( 1 > pageSize){
            throw new IllegalArgumentException("Page size must be bigger than Zero");
        }
    }
}
