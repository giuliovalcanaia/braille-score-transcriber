package br.com.braille.xml.score.scorepartwise.part.measure.barline;

import br.com.braille.xml.score.scorepartwise.part.measure.barline.ending.EndingType;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.FIELD)
public class Ending {

    @XmlAttribute(name = "number")
    private String number;

    @XmlAttribute(name = "type")
    private EndingType type;

    public String getNumber() {
        return number;
    }

    public EndingType getType() {
        return type;
    }

}
