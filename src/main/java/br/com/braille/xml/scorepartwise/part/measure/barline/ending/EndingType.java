package br.com.braille.xml.scorepartwise.part.measure.barline.ending;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

@XmlEnum
public enum EndingType {

    // Used with the left barline of the first measure in an ending.
    @XmlEnumValue("start")
    START,

    // Used with the right barline of the last measure in an ending.
    // Indicates the ending mark concludes with a downward jog, as is typical for first endings
    @XmlEnumValue("stop")
    STOP,

    // Used with the right barline of the last measure in an ending. Indicates there
    // is no downward jog, as is typical for second endings that do not conclude a piece.
    @XmlEnumValue("discontinue")
    DISCONTINUE
}
