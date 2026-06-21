package br.com.braille.xml.scorepartwise.part.measure;

import br.com.braille.xml.scorepartwise.part.measure.note.Pitch;
import br.com.braille.xml.scorepartwise.part.measure.note.Tied;
import br.com.braille.xml.scorepartwise.part.measure.note.NoteType;
import br.com.braille.xml.scorepartwise.part.measure.note.pitch.Step;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "note")
@XmlAccessorType(XmlAccessType.FIELD)
public class Note {

    private static final String[][] TABELA_NOTAS = {
            {"⠽", "⠵", "⠯", "⠿", "⠷", "⠮", "⠾"},
            {"⠝", "⠕", "⠏", "⠟", "⠗", "⠎", "⠞"},
            {"⠹", "⠱", "⠫", "⠻", "⠳", "⠪", "⠺"},
            {"⠙", "⠑", "⠋", "⠛", "⠓", "⠊", "⠚"}
    };

    private static final String[] TABELA_PAUSAS = {
            "⠍",
            "⠥",
            "⠧",
            "⠭"
    };

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

    public NoteType getType() {
        return noteType;
    }

    public List<Tied> getTieds() {
        return tieds;
    }

    public String toBraille() {
        int linha = linhaRitmica(noteType);
        if (linha < 0) {
            return "";
        }
        if (isRest()) {
            return TABELA_PAUSAS[linha];
        }
        if (pitch == null || pitch.getStep() == null) {
            return "";
        }
        return TABELA_NOTAS[linha][colunaPasso(pitch.getStep())];
    }

    private static int linhaRitmica(NoteType tipo) {
        if (tipo == null) {
            return -1;
        }
        return switch (tipo) {
            case WHOLE, SIXTEENTH -> 0;
            case HALF, THIRTY_SECOND -> 1;
            case QUARTER, SIXTY_FOURTH -> 2;
            case EIGHTH, ONE_HUNDRED_TWENTY_EIGHTH -> 3;
            default -> -1;
        };
    }

    private static int colunaPasso(Step passo) {
        return switch (passo) {
            case C -> 0;
            case D -> 1;
            case E -> 2;
            case F -> 3;
            case G -> 4;
            case A -> 5;
            case B -> 6;
        };
    }
}
