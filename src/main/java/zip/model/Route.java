package zip.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Route {
    @Id
    //@GeneratedValue(generator=  "ID_GENERATOR")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_GENERATOR")
    public Long id;
    public String idRoute;
    public String shortName;
    public String longName;
    public String desc;
    public String type;
    public String url;
    public String color;
    public String textColor;

    Route(){}

    public Route(
            String idRoute,
            String shortName,
            String longName,
            String desc,
            String type,
            String url,
            String color,
            String textColor) {
        this.idRoute = idRoute;
        this.shortName = shortName;
        this.longName = longName;
        this.desc = desc;
        this.type = type;
        this.url = url;
        this.color = color;
        this.textColor = textColor;
    }
}
