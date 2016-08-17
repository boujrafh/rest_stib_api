package zip.metadata;

import org.springframework.stereotype.Component;
import zip.model.CalendarDate;
import zip.dao.CalendarDateRepository;

import java.io.BufferedReader;
import java.io.IOException;
@Component
public class CalendarsDatesLoader implements Loader {

    private final Parser<CalendarDate> parser;
    private final CalendarDateRepository repo;


    public CalendarsDatesLoader(Parser<CalendarDate> parser, CalendarDateRepository repo) {
        this.parser = parser;
        this.repo = repo;
    }


    @Override
    public void loadToDb(BufferedReader br) {

        try {
            br.readLine(); // skip metadata
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        br.lines().map(parser::parse).forEach(repo::save);

    }
}
