package br.com.braille.xml.scorepartwise.part.measure.note.pitch;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

@XmlEnum
public enum Octave {

    @XmlEnumValue("1")
    FIRST(1,"⠈"),

    @XmlEnumValue("2")
    SECOND(2,"⠘"),

    @XmlEnumValue("3")
    THIRD(3,"⠸"),

    @XmlEnumValue("4")
    FOURTH(4,"⠐"),

    @XmlEnumValue("5")
    FIFTH(5,"⠨"),

    @XmlEnumValue("6")
    SIXTH(6,"⠰"),

    @XmlEnumValue("7")
    SEVENTH(7,"⠠");

    private int descricao;
    private String descricaoBraille;

    Octave(int descricao, String descricaoBraille) {
        this.descricao = descricao;
        this.descricaoBraille = descricaoBraille;
    }

    @Override
    public String toString() {
        return String.valueOf(descricao);
    }

    public int getDescricao() {
        return descricao;
    }

    public String toBraille() {
        return descricaoBraille;
    }
}
