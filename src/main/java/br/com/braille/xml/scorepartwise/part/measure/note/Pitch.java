package br.com.braille.xml.scorepartwise.part.measure.note;

import br.com.braille.xml.scorepartwise.part.measure.note.pitch.Octave;
import br.com.braille.xml.scorepartwise.part.measure.note.pitch.Step;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "pitch")
@XmlAccessorType(XmlAccessType.FIELD)
public class Pitch {

    @XmlElement(name = "step")
    private Step step;

    @XmlElement(name = "octave")
    private Octave octave;

    @XmlElement(name = "alter")
    private Integer alter;

    public Step getStep() {
        return step;
    }

    public Octave getOctave() {
        return octave;
    }

    public Integer getAlter() {
        return alter;
    }
}
