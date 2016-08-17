package zip.metadata;

import org.springframework.stereotype.Component;
import zip.model.Calendar;
import zip.dao.CalendarRepository;

import java.io.BufferedReader;
import java.io.IOException;

@Component
public class CalendarsLoader implements Loader {

    private final Parser<Calendar> parser;
    private final CalendarRepository repo;


    public CalendarsLoader(Parser<Calendar> parser, CalendarRepository repo) {
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
