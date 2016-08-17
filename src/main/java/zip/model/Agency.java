package zip.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Agency {
    @Id
//    @GeneratedValue(generator= "ID_GENERATOR")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_GENERATOR")
    public Long id;
    public String agencyName;
    public String agencyUrl;
    public String agencyTimezone;
    public String agencyLang;
    public String agencyPhone;

    Agency(){};

    public Agency(String agencyName, String agencyUrl, String agencyTimezone, String agencyLang, String agencyPhone) {
        this.agencyName = agencyName;
        this.agencyUrl = agencyUrl;
        this.agencyTimezone = agencyTimezone;
        this.agencyLang = agencyLang;
        this.agencyPhone = agencyPhone;
    }
}
