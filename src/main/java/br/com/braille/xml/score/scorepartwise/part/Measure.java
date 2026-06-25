package br.com.braille.xml.score.scorepartwise.part;

import br.com.braille.models.Brailleable;
import br.com.braille.xml.score.scorepartwise.part.measure.Attributes;
import br.com.braille.xml.score.scorepartwise.part.measure.Barline;
import br.com.braille.xml.score.scorepartwise.part.measure.Harmony;
import br.com.braille.xml.score.scorepartwise.part.measure.Note;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "measure")
@XmlAccessorType(XmlAccessType.FIELD)
public class Measure implements Brailleable {

    // Atributo exclusivo do braille
    private int brailleSize = 0;

    @XmlAttribute(name = "number")
    private String number;

    @XmlElement(name = "attributes")
    private Attributes attributes;

    @XmlElement(name = "note")
    private List<Note> notes = new ArrayList<>();

    @XmlElement(name = "harmony")
    private Harmony harmony;

    @XmlElement(name = "barline")
    private List<Barline> barlines = new ArrayList<>();

    @XmlElement(name = "print")
    private Object print;

    public String getNumber() {
        return number;
    }

    public Attributes getAttributes() {
        return attributes;
    }

    public List<Note> getNotes() {
        return notes;
    }

    public Harmony getHarmony() {
        return harmony;
    }

    public List<Barline> getBarlines() {
        return barlines;
    }

    public boolean isPrint() {
        return print != null;
    }

    public int getBrailleSize() {
        // Soma um para adicionar um espaço em branco após cada compasso
        return brailleSize + 1;
    }

    @Override
    public String toBraille() {
        String string = "";
        for (Note nota : notes) {
            if (nota.isOctaveMarkRequired()) {
                string += nota.getPitch().getOctave().toBraille();
            }
            string += nota.toBraille();
            brailleSize++;
        }
        return string;
    }

    @Override
    public String toString() {
        String string = "---- Compasso " + number + " ----\n";
        for (Note nota : notes) {
            if (nota.isOctaveMarkRequired()) {
                string += nota.getPitch().getOctave().toBraille() + " = ";
                string += "Oitava " + nota.getPitch().getOctave().toString() + "\n";
            }
            string += nota.toBraille() + " = ";
            string += nota.toString() + "\n";
        }
        return string;
    }

}
