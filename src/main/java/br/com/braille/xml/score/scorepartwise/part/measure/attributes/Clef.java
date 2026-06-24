package br.com.braille.xml.score.scorepartwise.part.measure.attributes;

import br.com.braille.models.Brailleable;
import br.com.braille.xml.score.scorepartwise.part.measure.attributes.clef.Sign;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "clef")
@XmlAccessorType(XmlAccessType.FIELD)
public class Clef implements Brailleable {

    @XmlElement(name = "sign")
    private Sign sign;

    @XmlElement(name = "line")
    private Integer line;

    public Sign getSign() {
        return sign;
    }

    public Integer getLine() {
        return line;
    }

    @Override
    public String toBraille() {
        return sign.toBraille();
    }
}
