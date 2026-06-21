package br.com.braille.xml.scorepartwise.part.measure.attributes;

import br.com.braille.xml.scorepartwise.part.measure.attributes.clef.Sign;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "clef")
@XmlAccessorType(XmlAccessType.FIELD)
public class Clef {

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
}
