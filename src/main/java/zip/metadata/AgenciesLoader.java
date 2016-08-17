package zip.metadata;

import org.springframework.stereotype.Component;
import zip.model.Agency;
import zip.dao.AgencyRepository;

import java.io.BufferedReader;
import java.io.IOException;

@Component
public class AgenciesLoader implements Loader{

    private final AgencyRepository repo;
    private final Parser<Agency> parser;

    public AgenciesLoader(AgencyRepository repo, Parser<Agency> parser) {
        this.repo = repo;
        this.parser = parser;
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
