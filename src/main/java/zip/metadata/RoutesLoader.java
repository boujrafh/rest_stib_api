package zip.metadata;

import org.springframework.stereotype.Component;
import zip.model.Route;
import zip.dao.RouteRepository;

import java.io.BufferedReader;
import java.io.IOException;

@Component
public class RoutesLoader implements Loader{

    private final RouteRepository repo;
    private final Parser<Route> parser;

    public RoutesLoader(Parser<Route> parser, RouteRepository repo) {
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




