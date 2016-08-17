package zip.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Stop {
    @Id
    //@GeneratedValue(generator=  "ID_GENERATOR")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_GENERATOR")
    public Long id;
    public String stopId;
    public String stopCode;
    public String stopName;
    public String stopDesc;
    public String stopLat;
    public String stopLon;
    public String zoneId;
    public String stopUrl;
    public String locationType;

    Stop(){}

    public Stop(String stopId, String stopCode, String stopName, String stopDesc, String stopLat, String stopLon, String zoneId, String stopUrl, String locationType) {
        this.stopId = stopId;
        this.stopCode = stopCode;
        this.stopName = stopName;
        this.stopDesc = stopDesc;
        this.stopLat = stopLat;
        this.stopLon = stopLon;
        this.zoneId = zoneId;
        this.stopUrl = stopUrl;
        this.locationType = locationType;
    }
}
