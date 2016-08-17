package zip.metadata;

import org.springframework.stereotype.Component;
import zip.model.Route;

@Component
public class RouteParser implements Parser <Route> {
    @Override
    public Route parse(String line) {
        String[] splitLine = line.split(",");
        return new Route(splitLine[0],
                splitLine[1],
                splitLine[2],
                splitLine[3],
                splitLine[4],
                splitLine[5],
                splitLine[6],
                splitLine[7]);
    }
}
