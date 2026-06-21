package br.com.braille.xml.scorepartwise.part.measure.attributes;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "clef")
@XmlAccessorType(XmlAccessType.FIELD)
public class Clef {

    @XmlElement(name = "sign")
    private String sign;

    @XmlElement(name = "line")
    private Integer line;

    public String getSign() {
        return sign;
    }

    public Integer getLine() {
        return line;
    }
}
