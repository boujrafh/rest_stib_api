package zip.metadata;

import org.springframework.stereotype.Component;
import zip.model.StopTime;
import zip.dao.StopTimeRepository;

import java.io.BufferedReader;
import java.io.IOException;

@Component
public class StopsTimesLoader implements Loader{
    private final StopTimeRepository repo;
    private final Parser<StopTime> parser;

    public StopsTimesLoader(Parser<StopTime> parser, StopTimeRepository repo) {
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
