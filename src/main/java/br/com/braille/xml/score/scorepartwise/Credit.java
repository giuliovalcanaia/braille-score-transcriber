package br.com.braille.xml.score.scorepartwise;

import br.com.braille.models.Brailleable;
import br.com.braille.service.TranscreverParaBraille;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "credit")
@XmlAccessorType(XmlAccessType.FIELD)
public class Credit implements Brailleable {

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

    @Override
    public String toBraille() {
        return TranscreverParaBraille.textoParaBraille(creditWords);
    }
}
