package br.com.braille.xml.score.scorepartwise.part.measure;

import br.com.braille.models.Brailleable;
import br.com.braille.service.TranscreverParaBraille;
import br.com.braille.xml.score.scorepartwise.part.measure.note.Pitch;
import br.com.braille.xml.score.scorepartwise.part.measure.note.Tied;
import br.com.braille.xml.score.scorepartwise.part.measure.note.NoteType;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "note")
@XmlAccessorType(XmlAccessType.FIELD)
public class Note implements Brailleable {
    // Tag exclusiva da notação braille
    private boolean octaveMarkRequired;

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

    public boolean isOctaveMarkRequired() {
        return octaveMarkRequired;
    }

    public void setOctaveMarkRequired(boolean octaveMarkRequired) {
        this.octaveMarkRequired = octaveMarkRequired;
    }

    @Override
    public String toBraille() {
        if (isRest()) {
            return TranscreverParaBraille.pausasParaBraille(getNoteType());
        } else {
            return TranscreverParaBraille.notasParaBraille(getNoteType(), getPitch().getStep());
        }
    }

    @Override
    public String toString() {
        if (isRest()) {
            return "Pausa " + getNoteType().toString();
        } else {
            return getPitch().getStep().toString() + getPitch().getOctave().toString() + " " + getNoteType().toString();
        }
    }
}
