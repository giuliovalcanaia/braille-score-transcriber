package br.com.braille.xml.scorepartwise.part.measure.note;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

@XmlEnum
public enum Type {

    // semiquintifusa
    @XmlEnumValue("1024th")
    ONE_THOUSAND_TWENTY_FOURTH,

    // quintifusa
    @XmlEnumValue("512th")
    FIVE_HUNDRED_TWELFTH,

    // semiquartifusa
    @XmlEnumValue("256th")
    TWO_HUNDRED_FIFTY_SIXTH,

    // quartifusa
    @XmlEnumValue("128th")
    ONE_HUNDRED_TWENTY_EIGHTH,

    // semifusa
    @XmlEnumValue("64th")
    SIXTY_FOURTH,

    // fusa
    @XmlEnumValue("32nd")
    THIRTY_SECOND,

    // semicolcheia
    @XmlEnumValue("16th")
    SIXTEENTH,

    // colcheia
    @XmlEnumValue("eighth")
    EIGHTH,

    // semínima
    @XmlEnumValue("quarter")
    QUARTER,

    // mínima
    @XmlEnumValue("half")
    HALF,

    // semibreve
    @XmlEnumValue("whole")
    WHOLE,

    // breve
    @XmlEnumValue("breve")
    BREVE,

    // longa
    @XmlEnumValue("long")
    LONG,

    // máxima
    @XmlEnumValue("maxima")
    MAXIMA
}
