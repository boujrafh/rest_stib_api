package zip.metadata;

import org.springframework.stereotype.Component;
import zip.model.Translation;

@Component
public class TranslationParser implements Parser<Translation> {
    @Override
    public Translation parse(String line) {
        String[] splitLine = line.split(",");
        return new Translation(splitLine[0],
                splitLine[1],
                splitLine[2]);
    }
}
