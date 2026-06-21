package br.com.braille.xml.scorepartwise.part.measure.barline;

import br.com.braille.xml.scorepartwise.part.measure.barline.repeat.Direction;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.FIELD)
public class Repeat {

    @XmlAttribute(name = "direction")
    private Direction direction;

    @XmlAttribute(name = "times")
    private Integer times;

    public Direction getDirection() {
        return direction;
    }

    public Integer getTimes() {
        return times;
    }
}
