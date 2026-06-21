package br.com.braille.xml.scorepartwise.part.measure.barline;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;

@XmlAccessorType(XmlAccessType.FIELD)
public class Ending {

    @XmlAttribute(name = "number")
    private String number;

    @XmlAttribute(name = "type")
    private String type;

    @XmlValue
    private String text;

    public String getNumber() {
        return number;
    }

    public String getType() {
        return type;
    }

    public String getText() {
        return text;
    }
}
