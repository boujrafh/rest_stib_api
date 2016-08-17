package zip.metadata;

import org.springframework.stereotype.Component;
import zip.model.Stop;
import zip.dao.StopRepository;

import java.io.BufferedReader;
import java.io.IOException;

@Component
public class StopsLoader implements Loader {
    private final StopRepository repo;
    private final Parser<Stop> parser;

    public StopsLoader(Parser<Stop> parser, StopRepository repo) {
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
