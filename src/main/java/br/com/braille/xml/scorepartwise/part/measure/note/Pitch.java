package br.com.braille.xml.scorepartwise.part.measure.note;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "pitch")
@XmlAccessorType(XmlAccessType.FIELD)
public class Pitch {

    @XmlElement(name = "step")
    private String step;

    @XmlElement(name = "octave")
    private Integer octave;

    @XmlElement(name = "alter")
    private Integer alter;

    public String getStep() {
        return step;
    }

    public Integer getOctave() {
        return octave;
    }

    public Integer getAlter() {
        return alter;
    }
}
