package br.com.braille.xml.scorepartwise.part.measure.note.pitch;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

@XmlEnum
public enum Octave {

    @XmlEnumValue("1")
    FIRST,

    @XmlEnumValue("2")
    SECOND,

    @XmlEnumValue("3")
    THIRD,

    @XmlEnumValue("4")
    FOURTH,

    @XmlEnumValue("5")
    FIFTH,

    @XmlEnumValue("6")
    SIXTH,

    @XmlEnumValue("7")
    SEVENTH;

    @Override
    public String toString() {
        return switch (this) {
            case FIRST -> "1";
            case SECOND -> "2";
            case THIRD -> "3";
            case FOURTH -> "4";
            case FIFTH -> "5";
            case SIXTH -> "6";
            case SEVENTH -> "7";
        };
    }

    public String toBraille() {
        return switch (this) {
            case FIRST -> "⠈";
            case SECOND -> "⠘";
            case THIRD -> "⠸";
            case FOURTH -> "⠐";
            case FIFTH -> "⠨";
            case SIXTH -> "⠰";
            case SEVENTH -> "⠠";
        };
    }
}
