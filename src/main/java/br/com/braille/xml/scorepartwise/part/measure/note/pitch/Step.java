package br.com.braille.xml.scorepartwise.part.measure.note.pitch;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

@XmlEnum
public enum Step {

    @XmlEnumValue("A")
    A("A"),

    @XmlEnumValue("B")
    B("B"),

    @XmlEnumValue("C")
    C("C"),

    @XmlEnumValue("D")
    D("D"),

    @XmlEnumValue("E")
    E("E"),

    @XmlEnumValue("F")
    F("F"),

    @XmlEnumValue("G")
    G("G");

    private String descricao;

    Step(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return descricao;
    }
}
