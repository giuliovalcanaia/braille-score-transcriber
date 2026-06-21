package br.com.braille.exemplo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

// Define que esta classe será a tag principal (raiz) do XML
@XmlRootElement(name = "score-partwise")
@XmlAccessorType(XmlAccessType.FIELD)
public class ScorePartwise {

    @XmlElement(name = "credit")
    private List<Credit> credits;

    public List<Credit> getCredits() {
        return credits;
    }

    public void setCredits(List<Credit> credits) {
        this.credits = credits;
    }
}