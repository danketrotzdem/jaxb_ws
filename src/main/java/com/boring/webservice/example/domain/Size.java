package com.boring.webservice.example.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Size {

    @XmlElement
    private ValueUnit length;
    @XmlElement
    private ValueUnit height;
    @XmlElement
    private ValueUnit width;

    public ValueUnit getLength() {
        return length;
    }

    public void setLength(ValueUnit length) {
        this.length = length;
    }

    public ValueUnit getHeight() {
        return height;
    }

    public void setHeight(ValueUnit height) {
        this.height = height;
    }

    public ValueUnit getWidth() {
        return width;
    }

    public void setWidth(ValueUnit width) {
        this.width = width;
    }
}
