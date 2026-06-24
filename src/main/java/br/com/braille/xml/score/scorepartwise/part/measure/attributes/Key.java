package br.com.braille.xml.score.scorepartwise.part.measure.attributes;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serial;
import java.io.Serializable;

@XmlRootElement(name = "key")
@XmlAccessorType(XmlAccessType.FIELD)
public class Key implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @XmlElement(name = "fifths")
    private Integer fifths;

    public Integer getFifths() {
        return fifths;
    }
}
