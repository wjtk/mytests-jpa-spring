package wkr.testy.jpa.converters;

import javax.persistence.*;

@Entity
public class Car {

    @Id
    @GeneratedValue
    private Long id;

    private Color frontColor;

    @Convert(converter = ColorTwoLettersConverter.class)
    private Color seatsColor;

    @Enumerated
    private Color upholsteryColor;

    public Car() {
    }

    public Car(Color color) {
        this.frontColor = color;
        this.seatsColor = color;
        this.upholsteryColor = color;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Color getFrontColor() {
        return frontColor;
    }

    public void setFrontColor(Color frontColor) {
        this.frontColor = frontColor;
    }

    public Color getSeatsColor() {
        return seatsColor;
    }

    public void setSeatsColor(Color seatsColor) {
        this.seatsColor = seatsColor;
    }

    public Color getUpholsteryColor() {
        return upholsteryColor;
    }

    public void setUpholsteryColor(Color upholsteryColor) {
        this.upholsteryColor = upholsteryColor;
    }
}
