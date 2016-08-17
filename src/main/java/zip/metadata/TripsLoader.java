package zip.metadata;

import org.springframework.stereotype.Component;
import zip.model.Trip;
import zip.dao.TripRepository;

import java.io.BufferedReader;
import java.io.IOException;

@Component
public class TripsLoader implements Loader {
    private final TripRepository repo;
    private final Parser<Trip> parser;

    public TripsLoader(Parser<Trip> parser, TripRepository repo) {
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
