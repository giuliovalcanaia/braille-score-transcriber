package br.com.braille.exemplo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Credit {
    @XmlElement(name = "credit-type")
    private String creditType;

    @XmlElement(name = "credit-words")
    private String creditWords;

    public String getCreditType() {
        return creditType;
    }

    public void setCreditType(String creditType) {
        this.creditType = creditType;
    }

    public String getCreditWords() {
        return creditWords;
    }

    public void setCreditWords(String creditWords) {
        this.creditWords = creditWords;
    }
}
