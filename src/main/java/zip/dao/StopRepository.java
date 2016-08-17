package zip.dao;

import org.springframework.data.repository.CrudRepository;
import zip.model.Stop;

public interface StopRepository extends CrudRepository <Stop, Long> {
}
