package br.com.braille.xml.scorepartwise.part;

import br.com.braille.xml.scorepartwise.part.measure.Attributes;
import br.com.braille.xml.scorepartwise.part.measure.Harmony;
import br.com.braille.xml.scorepartwise.part.measure.Note;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "measure")
@XmlAccessorType(XmlAccessType.FIELD)
public class Measure{

    @XmlAttribute(name = "number")
    private String number;

    @XmlElement(name = "attributes")
    private List<Attributes> attributes = new ArrayList<>();

    @XmlElement(name = "note")
    private List<Note> notes = new ArrayList<>();

    private List<Harmony> harmonies = new ArrayList<>();

    public String getNumber() {
        return number;
    }

    public List<Attributes> getAttributes() {
        return attributes;
    }

    public List<Note> getNotes() {
        return notes;
    }

    public List<Harmony> getHarmonies() {
        return harmonies;
    }
}
