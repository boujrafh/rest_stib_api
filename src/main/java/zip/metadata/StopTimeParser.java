package zip.metadata;

import org.springframework.stereotype.Component;
import zip.model.StopTime;

@Component
public class StopTimeParser implements Parser<StopTime> {
    @Override
    public StopTime parse(String line) {
        String[] splitLine = line.trim().split(",");
        return new StopTime(splitLine[0],
                splitLine[1],
                splitLine[2],
                splitLine[3],
                Integer.parseInt(splitLine[4]),
                parseIntToBool(splitLine[5]),
                parseIntToBool(splitLine[6]));
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
