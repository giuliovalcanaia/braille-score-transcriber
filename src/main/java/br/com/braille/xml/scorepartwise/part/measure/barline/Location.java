package br.com.braille.xml.scorepartwise.part.measure.barline;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

@XmlEnum
public enum Location {

    // Right barline.
    @XmlEnumValue("right")
    RIGHT,

    // Left barline.
    @XmlEnumValue("left")
    LEFT,

    // Mid-measure barline.
    @XmlEnumValue("middle")
    MIDDLE
}
