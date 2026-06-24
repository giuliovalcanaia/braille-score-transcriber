package br.com.braille.xml.score.scorepartwise.part.measure.barline;

import br.com.braille.xml.score.scorepartwise.part.measure.barline.repeat.Direction;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import java.io.Serial;
import java.io.Serializable;

@XmlAccessorType(XmlAccessType.FIELD)
public class Repeat implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

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
