package br.com.braille.xml.scorepartwise.part.measure;

import br.com.braille.xml.scorepartwise.part.measure.barline.Ending;
import br.com.braille.xml.scorepartwise.part.measure.barline.Repeat;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "barline")
@XmlAccessorType(XmlAccessType.FIELD)
public class Barline {

    @XmlAttribute(name = "location")
    private String location;

    @XmlElement(name = "ending")
    private Ending ending;

    @XmlElement(name = "repeat")
    private Repeat repeat;

    public String getLocation() {
        return location;
    }

    public Ending getEnding() {
        return ending;
    }

    public Repeat getRepeat() {
        return repeat;
    }
}
