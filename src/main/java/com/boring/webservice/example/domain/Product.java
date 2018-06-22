package com.boring.webservice.example.domain;

import javax.xml.bind.annotation.*;
import java.util.List;


@XmlAccessorType(XmlAccessType.FIELD)
public class Product {


    @XmlAttribute
    private String number;
    @XmlElementWrapper(name = "names")
    @XmlElement(name = "name")
    private List<Name> names;
    @XmlElement
    private Size sizes;
    @XmlElement
    private ValueUnit weight;
    @XmlElement
    private Shipping shipping;
    @XmlElement
    private Toll toll;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public List<Name> getNames() {
        return names;
    }

    public void setNames(List<Name> names) {
        this.names = names;
    }

    public Size getSizes() {
        return sizes;
    }

    public void setSizes(Size sizes) {
        this.sizes = sizes;
    }

    public ValueUnit getWeight() {
        return weight;
    }

    public void setWeight(ValueUnit weight) {
        this.weight = weight;
    }

    public Shipping getShipping() {
        return shipping;
    }

    public void setShipping(Shipping shipping) {
        this.shipping = shipping;
    }

    public Toll getToll() {
        return toll;
    }

    public void setToll(Toll toll) {
        this.toll = toll;
    }
}
