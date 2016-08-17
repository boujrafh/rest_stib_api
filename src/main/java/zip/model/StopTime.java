package zip.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class StopTime {
    @Id
    //@GeneratedValue(generator=  "ID_GENERATOR")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_GENERATOR")
    public Long id;
    public String tripId;
    public String arrivalTime;
    public String departureTime;
    public String stopId;
    public int stopSequence;
    public boolean pickupType;
    public boolean dropOffType;

    StopTime(){}

    public StopTime(String tripId, String arrivalTime, String departureTime, String stopId,
                    int stopSequence, boolean pickupType, boolean dropOffType) {
        this.tripId = tripId;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
        this.stopId = stopId;
        this.stopSequence = stopSequence;
        this.pickupType = pickupType;
        this.dropOffType = dropOffType;
    }
}
