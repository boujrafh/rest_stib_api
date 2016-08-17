package zip.metadata;

import org.springframework.stereotype.Component;
import zip.model.Translation;
import zip.dao.TranslationRepository;

import java.io.BufferedReader;
import java.io.IOException;

@Component
public class TranslationsLoader implements Loader {
    private final TranslationRepository repo;
    private final Parser<Translation> parser;

    public TranslationsLoader(Parser<Translation> parser, TranslationRepository repo) {
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

