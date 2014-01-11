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
    private Color rearColor;

    public Car() {
    }

    public Car(Color color) {
        this.frontColor = color;
        this.seatsColor = color;
        this.rearColor = color;
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

    public Color getRearColor() {
        return rearColor;
    }

    public void setRearColor(Color rearColor) {
        this.rearColor = rearColor;
    }
}
