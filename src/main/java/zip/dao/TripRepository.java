package zip.dao;

import org.springframework.data.repository.CrudRepository;
import zip.model.Trip;

public interface TripRepository extends CrudRepository <Trip, Long> {
}
