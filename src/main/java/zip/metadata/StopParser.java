package zip.metadata;

import org.springframework.stereotype.Component;
import zip.model.Stop;

@Component
public class StopParser implements Parser<Stop> {
    @Override
    public Stop parse(String line) {
        String[] splitLine = line.trim().split(",");
        return new Stop(splitLine[0],
                splitLine[1],
                splitLine[2],
                splitLine[3],
                splitLine[4],
                splitLine[5],
                splitLine[6],
                splitLine[7],
                splitLine[8]);
    }
}