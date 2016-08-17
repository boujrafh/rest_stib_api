package zip.dao;

import org.springframework.data.repository.CrudRepository;
import zip.model.Agency;

public interface AgencyRepository extends CrudRepository <Agency, Long> {
}
