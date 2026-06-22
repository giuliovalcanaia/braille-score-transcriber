package br.com.braille.xml.scorepartwise.part.measure.note.pitch;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

@XmlEnum
public enum Step {

    @XmlEnumValue("A")
    A,

    @XmlEnumValue("B")
    B,

    @XmlEnumValue("C")
    C,

    @XmlEnumValue("D")
    D,

    @XmlEnumValue("E")
    E,

    @XmlEnumValue("F")
    F,

    @XmlEnumValue("G")
    G;
}
