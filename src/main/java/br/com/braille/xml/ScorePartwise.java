package br.com.braille.xml;


import br.com.braille.xml.scorepartwise.Credit;
import br.com.braille.xml.scorepartwise.Part;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;
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
