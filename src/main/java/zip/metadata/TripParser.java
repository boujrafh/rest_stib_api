package zip.metadata;

import org.springframework.stereotype.Component;
import zip.model.Trip;

@Component
public class TripParser implements Parser<Trip> {
    @Override
    public Trip parse(String line) {
        String[] splitLine = line.trim().split(",");
        return new Trip(splitLine[0],
                splitLine[1],
                splitLine[2],
                splitLine[3],
                parseIntToBool(splitLine[4]),
                splitLine[5],
                splitLine[6]);
    }

    public boolean parseIntToBool( String integer){
        if(integer.equals("0")){
            return false;
        }
        if(integer.equals("1")){
            return true;
        }
        throw new RuntimeException("Cannot convert \"" + integer + "\"" + "boolean");

    }
}
