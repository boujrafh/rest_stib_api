package zip.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Shape {

    @Id
    //@GeneratedValue(generator=  "ID_GENERATOR")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_GENERATOR")
    public Long id;
    public String shapeId;
    public String shapePtLat;
    public String shapePtLon;
    public String shapePtSequence;

    Shape(){}

    public Shape(String shapeId, String shapePtLat, String shapePtLon, String shapePtSequence) {
        this.shapeId = shapeId;
        this.shapePtLat = shapePtLat;
        this.shapePtLon = shapePtLon;
        this.shapePtSequence = shapePtSequence;
    }
}
