package br.com.braille.xml.scorepartwise.part.measure.note;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

@XmlEnum
public enum NoteType {

    // semiquintifusa
    @XmlEnumValue("1024th")
    ONE_THOUSAND_TWENTY_FOURTH("semiquintifusa"),

    // quintifusa
    @XmlEnumValue("512th")
    FIVE_HUNDRED_TWELFTH("quintifusa"),

    // semiquartifusa
    @XmlEnumValue("256th")
    TWO_HUNDRED_FIFTY_SIXTH("semiquartifusa"),

    // quartifusa
    @XmlEnumValue("128th")
    ONE_HUNDRED_TWENTY_EIGHTH("quartifusa"),

    // semifusa
    @XmlEnumValue("64th")
    SIXTY_FOURTH("semifusa"),

    // fusa
    @XmlEnumValue("32nd")
    THIRTY_SECOND("fusa"),

    // semicolcheia
    @XmlEnumValue("16th")
    SIXTEENTH("semicolcheia"),

    // colcheia
    @XmlEnumValue("eighth")
    EIGHTH("colcheia"),

    // semínima
    @XmlEnumValue("quarter")
    QUARTER("semínima"),

    // mínima
    @XmlEnumValue("half")
    HALF("mínima"),

    // semibreve
    @XmlEnumValue("whole")
    WHOLE("semibreve"),

    // breve
    @XmlEnumValue("breve")
    BREVE("breve"),

    // longa
    @XmlEnumValue("long")
    LONG("longa"),

    // máxima
    @XmlEnumValue("maxima")
    MAXIMA("máxima");

    private String descricao;

    NoteType(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return descricao;
    }
}
