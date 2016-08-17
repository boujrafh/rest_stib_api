package zip.metadata;

import org.springframework.stereotype.Component;
import zip.model.Shape;
@Component
public class ShapeParser implements Parser<Shape> {
    @Override
    public Shape parse(String line) {
        String[] splitLine = line.trim().split(",");
        return new Shape(splitLine[0],
                splitLine[1],
                splitLine[2],
                splitLine[3]);
    }
}
