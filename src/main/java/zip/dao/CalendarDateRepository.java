package zip.dao;

import org.springframework.data.repository.CrudRepository;
import zip.model.CalendarDate;

public interface CalendarDateRepository extends CrudRepository <CalendarDate, Long> {
}
