package br.com.braille.xml.score.scorepartwise.part.measure.barline.repeat;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

@XmlEnum
public enum Direction {

    // Start of a repeated section.
    @XmlEnumValue("forward")
    FORWARD,

    // End of a repeated section.
    @XmlEnumValue("backward")
    BACKWARD
}
