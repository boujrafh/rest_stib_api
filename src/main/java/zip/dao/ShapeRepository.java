package zip.dao;

import org.springframework.data.repository.CrudRepository;
import zip.model.Shape;

public interface ShapeRepository extends CrudRepository <Shape, Long> {
}
