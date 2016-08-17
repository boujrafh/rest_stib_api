package zip.metadata;

import org.springframework.stereotype.Component;
import zip.model.Agency;
@Component
public class AgencyParser implements Parser <Agency> {


    @Override
    public Agency parse(String line) {
        String[] splitLine = line.split(",");
        return new Agency(splitLine[0],
                splitLine[1],
                splitLine[2],
                splitLine[3],
                splitLine[4]);
    }
}
