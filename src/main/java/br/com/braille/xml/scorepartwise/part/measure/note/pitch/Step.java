package br.com.braille.xml.scorepartwise.part.measure.note.pitch;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

@XmlEnum
public enum Step {

    @XmlEnumValue("A")
    A("A", 5),

    @XmlEnumValue("B")
    B("B", 6),

    @XmlEnumValue("C")
    C("C", 0),

    @XmlEnumValue("D")
    D("D", 1),

    @XmlEnumValue("E")
    E("E", 2),

    @XmlEnumValue("F")
    F("F", 3),

    @XmlEnumValue("G")
    G("G", 4);

    private String descricao;
    private int referencia;

    Step(String descricao, int referencia) {
        this.descricao = descricao;
        this.referencia = referencia;
    }

    @Override
    public String toString() {
        return descricao;
    }

    public int getReferencia() {
        return referencia;
    }
}
