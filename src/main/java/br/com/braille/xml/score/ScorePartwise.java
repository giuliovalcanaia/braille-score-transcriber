package br.com.braille.xml.score;


import br.com.braille.xml.score.scorepartwise.Credit;
import br.com.braille.xml.score.scorepartwise.Part;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "score-partwise")
@XmlAccessorType(XmlAccessType.FIELD)
public class ScorePartwise {

    @XmlElement(name = "credit")
    private List<Credit> credits = new ArrayList<>();

    @XmlElement(name = "part")
    private List<Part> parts = new ArrayList<>();

    public List<Credit> getCredits() {
        return credits;
    }

    public List<Part> getParts() {
        return parts;
    }
}
