package br.com.braille.xml.score.scorepartwise.part.measure;


import br.com.braille.xml.score.scorepartwise.part.measure.attributes.Clef;
import br.com.braille.xml.score.scorepartwise.part.measure.attributes.Key;
import br.com.braille.xml.score.scorepartwise.part.measure.attributes.Time;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serial;
import java.io.Serializable;

@XmlRootElement(name = "attributes")
@XmlAccessorType(XmlAccessType.FIELD)
public class Attributes implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @XmlElement(name = "divisions")
    private Integer divisions;

    @XmlElement(name = "key")
    private Key key;

    @XmlElement(name = "time")
    private Time time;

    @XmlElement(name = "clef")
    private Clef clef;

    public Integer getDivisions() {
        return divisions;
    }

    public Key getKey() {
        return key;
    }

    public Time getTime() {
        return time;
    }

    public Clef getClef() {
        return clef;
    }
}
