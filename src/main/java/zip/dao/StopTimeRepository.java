package zip.dao;

import org.springframework.data.repository.CrudRepository;
import zip.model.StopTime;

public interface StopTimeRepository extends CrudRepository <StopTime, Long> {
}
