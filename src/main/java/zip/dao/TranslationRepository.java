package zip.dao;

import org.springframework.data.repository.CrudRepository;
import zip.model.Translation;

public interface TranslationRepository extends CrudRepository <Translation, Long> {
}
