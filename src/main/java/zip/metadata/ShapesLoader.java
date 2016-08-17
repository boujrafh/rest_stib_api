package zip.metadata;

import org.springframework.stereotype.Component;
import zip.model.Shape;
import zip.dao.ShapeRepository;

import java.io.BufferedReader;
import java.io.IOException;

@Component
public class ShapesLoader implements Loader {
    private final ShapeRepository repo;
    private final Parser<Shape> parser;

    public ShapesLoader(Parser<Shape> parser, ShapeRepository repo) {
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
