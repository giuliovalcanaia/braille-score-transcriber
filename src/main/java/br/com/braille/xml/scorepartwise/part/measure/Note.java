package br.com.braille.xml.scorepartwise.part.measure;

import br.com.braille.service.TranscritorParaBraille;
import br.com.braille.xml.scorepartwise.part.measure.note.Pitch;
import br.com.braille.xml.scorepartwise.part.measure.note.Tied;
import br.com.braille.xml.scorepartwise.part.measure.note.NoteType;

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
    private NoteType noteType;

    @XmlElement(name = "tied")
    private List<Tied> tieds = new ArrayList<>();

    public Pitch getPitch() {
        return pitch;
    }

    public boolean isRest() {
        return this.rest != null;
    }

    public Integer getDuration() {
        return duration;
    }

    public NoteType getNoteType() {
        return noteType;
    }

    public List<Tied> getTieds() {
        return tieds;
    }

    public String toBraille() {
        if (isRest()) {
            return TranscritorParaBraille.pausasParaBraille(getNoteType());
        } else {
            return TranscritorParaBraille.notasParaBraille(getNoteType(), getPitch().getStep());
        }
    }

    @Override
    public String toString() {
        return getPitch().getStep().toString() + getPitch().getOctave().toString() + " " + getNoteType().toString();
    }
}
