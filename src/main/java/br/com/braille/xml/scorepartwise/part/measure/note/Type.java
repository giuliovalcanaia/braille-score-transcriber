package br.com.braille.xml.scorepartwise.part.measure.note;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

@XmlEnum
public enum Type {

    @XmlEnumValue("1024th")
    ONE_THOUSAND_TWENTY_FOURTH,

    @XmlEnumValue("512th")
    FIVE_HUNDRED_TWELFTH,

    @XmlEnumValue("256th")
    TWO_HUNDRED_FIFTY_SIXTH,

    @XmlEnumValue("128th")
    ONE_HUNDRED_TWENTY_EIGHTH,

    @XmlEnumValue("64th")
    SIXTY_FOURTH,

    @XmlEnumValue("32nd")
    THIRTY_SECOND,

    @XmlEnumValue("16th")
    SIXTEENTH,

    @XmlEnumValue("eighth")
    EIGHTH,

    @XmlEnumValue("quarter")
    QUARTER,

    @XmlEnumValue("half")
    HALF,

    @XmlEnumValue("whole")
    WHOLE,

    @XmlEnumValue("breve")
    BREVE,

    @XmlEnumValue("long")
    LONG,

    @XmlEnumValue("maxima")
    MAXIMA
}
