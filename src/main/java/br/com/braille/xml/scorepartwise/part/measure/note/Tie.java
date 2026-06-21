package br.com.braille.xml.scorepartwise.part.measure.note;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.FIELD)
public class Tie {

    @XmlAttribute(name = "type")
    private String type;

    public String getType() {
        return type;
    }
}
