package wkr.testy.jpa.converters;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "car")
@Entity
public class CarHack {

    @Id
    @GeneratedValue
    private Long id;

    private String frontColor;

    private String seatsColor;

    private Integer upholsteryColor;


    public Long getId() {
        return id;
    }

    public String getFrontColor() {
        return frontColor;
    }

    public String getSeatsColor() {
        return seatsColor;
    }

    public Integer getUpholsteryColor() {
        return upholsteryColor;
    }
}
