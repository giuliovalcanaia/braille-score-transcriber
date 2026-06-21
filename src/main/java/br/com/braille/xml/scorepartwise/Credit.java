package br.com.braille.xml.scorepartwise;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "credit")
@XmlAccessorType(XmlAccessType.FIELD)
public class Credit{

    @XmlElement(name = "credit-type")
    private String creditType;

    @XmlElement(name = "credit-words")
    private String creditWords;

    public String getCreditType() {
        return creditType;
    }

    public String getCreditWords() {
        return creditWords;
    }
}
