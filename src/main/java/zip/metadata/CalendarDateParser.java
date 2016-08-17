package zip.metadata;

import org.springframework.stereotype.Component;
import zip.model.CalendarDate;
@Component
public class CalendarDateParser implements Parser<CalendarDate> {

    @Override
    public CalendarDate parse(String line) {
        String[] splitLine = line.split(",");
        return new CalendarDate(splitLine[0],
                splitLine[1],
                Integer.parseInt(splitLine[2]));
    }

}
