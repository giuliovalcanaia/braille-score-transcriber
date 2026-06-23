package br.com.braille.xml.score.scorepartwise.part.measure.attributes.clef;

import br.com.braille.models.Brailleable;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

@XmlEnum
public enum Sign implements Brailleable {

    @XmlEnumValue("G")
    G,

    @XmlEnumValue("F")
    F,

    @XmlEnumValue("C")
    C,

    @XmlEnumValue("percussion")
    PERCUSSION,

    // The TAB sign indicates that the music that follows should be in tablature notation.
    @XmlEnumValue("TAB")
    TAB,

    // The jianpu sign indicates that the music that follows should be in jianpu numbered notation. Unlike TAB, a jianpu sign does not correspond to a visual clef notation.
    @XmlEnumValue("jianpu")
    JIANPU,

    // Deprecated as of MusicXML 4.0. Use the clef element's print-object attribute instead. When the none sign is used, notes should be displayed as if in treble clef.
    @XmlEnumValue("none")
    NONE;

    @Override
    public String toString() {
        return switch (this) {
            case G -> "𝄞";
            case F -> "𝄢";
            case C -> "𝄡";
            default -> name();
        };
    }

    @Override
    public String toBraille() {
        return switch (this) {
            case G -> "⠜⠌⠇";
            case F -> "⠜⠼⠇";
            case C -> "⠜⠬⠇";
            default -> name();
        };
    }
}
