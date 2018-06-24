package com.boring.webservice.example.domain;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
public class Toll {
    @XmlElement
    private String productionCountry;
    @XmlElementWrapper(name = "numbers")
    @XmlElement(name = "number")
    private List<Number> numbers;

    public String getProductionCountry() {
        return productionCountry;
    }


    public void setProductionCountry(String productionCountry) {
        this.productionCountry = productionCountry;
    }

    public List<Number> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<Number> numbers) {
        this.numbers = numbers;
    }
}
