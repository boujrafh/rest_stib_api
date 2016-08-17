package zip.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Calendar {

    @Id
   // @GeneratedValue(generator=  "ID_GENERATOR")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_GENERATOR")
    public Long id;
    public String serviceId;
    public Boolean monday;
    public Boolean tuesday;
    public Boolean wednesday;
    public Boolean  thursday;
    public Boolean friday;
    public Boolean saturday;
    public Boolean sunday;
    public String startDate;
    public String endDate;

    Calendar(){}

    public Calendar(String serviceId, Boolean monday, Boolean tuesday, Boolean wednesday, Boolean thursday,
                    Boolean friday, Boolean saturday, Boolean sunday, String startDate, String endDate) {
        this.serviceId = serviceId;
        this.monday = monday;
        this.tuesday = tuesday;
        this.wednesday = wednesday;
        this.thursday = thursday;
        this.friday = friday;
        this.saturday = saturday;
        this.sunday = sunday;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
