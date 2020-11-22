package model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "car_wrapper")
public class Car {
    private String tradeMark;
    private String model;
    private User owner;

    public String getTradeMark() {
        return tradeMark;
    }

    public void setTradeMark(String tradeMark) {
        this.tradeMark = tradeMark;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
}
