package br.com.braille.xml.scorepartwise.part.measure;

import br.com.braille.xml.scorepartwise.part.measure.note.Pitch;
import br.com.braille.xml.scorepartwise.part.measure.note.Tie;
import br.com.braille.xml.scorepartwise.part.measure.note.Type;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "note")
@XmlAccessorType(XmlAccessType.FIELD)
public class Note {

    @XmlElement(name = "pitch")
    private Pitch pitch;

    @XmlElement(name = "rest")
    private Object rest;

    @XmlElement(name = "duration")
    private Integer duration;

    @XmlElement(name = "type")
    private Type type;

    @XmlElement(name = "tie")
    private List<Tie> ties = new ArrayList<>();

    public Pitch getPitch() {
        return pitch;
    }

    public boolean isRest() {
        return this.rest != null;
    }

    public Integer getDuration() {
        return duration;
    }

    public Type getType() {
        return type;
    }

    public List<Tie> getTies() {
        return ties;
    }
}
