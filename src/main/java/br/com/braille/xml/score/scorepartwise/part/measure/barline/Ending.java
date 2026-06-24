package br.com.braille.xml.score.scorepartwise.part.measure.barline;

import br.com.braille.xml.score.scorepartwise.part.measure.barline.ending.EndingType;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import java.io.Serial;
import java.io.Serializable;

@XmlAccessorType(XmlAccessType.FIELD)
public class Ending implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

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
