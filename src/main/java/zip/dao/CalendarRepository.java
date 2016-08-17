package zip.dao;

import org.springframework.data.repository.CrudRepository;
import zip.model.Calendar;

public interface CalendarRepository extends CrudRepository <Calendar, Long> {
}
