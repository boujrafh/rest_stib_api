package zip.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Trip {
    @Id
    //@GeneratedValue(generator=  "ID_GENERATOR")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_GENERATOR")
    public Long id;
    public String routeId;
    public String serviceId;
    public String tripId;
    public String tripHeadsign;
    public boolean directionId;
    public String blockId;
    public String shapeId;

    Trip(){}

    public Trip(String routeId, String serviceId, String tripId, String tripHeadsign, boolean directionId, String blockId, String shapeId) {
        this.routeId = routeId;
        this.serviceId = serviceId;
        this.tripId = tripId;
        this.tripHeadsign = tripHeadsign;
        this.directionId = directionId;
        this.blockId = blockId;
        this.shapeId = shapeId;
    }
}
