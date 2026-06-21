package br.com.braille.xml.scorepartwise.part.measure.barline;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.FIELD)
public class Repeat {

    @XmlAttribute(name = "direction")
    private String direction;

    @XmlAttribute(name = "times")
    private Integer times;

    public String getDirection() {
        return direction;
    }

    public Integer getTimes() {
        return times;
    }
}
