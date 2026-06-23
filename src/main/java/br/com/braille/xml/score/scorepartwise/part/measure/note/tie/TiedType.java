package br.com.braille.xml.score.scorepartwise.part.measure.note.tie;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

@XmlEnum
public enum TiedType {

    // Start of a tie.
    @XmlEnumValue("start")
    START,

    // End of a tie.
    @XmlEnumValue("stop")
    STOP,

    // Continuation of a tie, usually used for cross-system formatting.
    @XmlEnumValue("continue")
    CONTINUE,

    // A tie that indicates an instrument should be undamped.
    @XmlEnumValue("let-ring")
    LET_RING
}
