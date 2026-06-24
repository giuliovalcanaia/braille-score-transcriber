package br.com.braille.xml.score.scorepartwise.part.measure.harmony.root;

import br.com.braille.models.Brailleable;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

@XmlEnum
public enum RootStep implements Brailleable {

    @XmlEnumValue("A")
    A("A", "⠁"),

    @XmlEnumValue("B")
    B("B", "⠃"),

    @XmlEnumValue("C")
    C("C", "⠉"),

    @XmlEnumValue("D")
    D("D", "⠙"),

    @XmlEnumValue("E")
    E("E", "⠑"),

    @XmlEnumValue("F")
    F("F", "⠋"),

    @XmlEnumValue("G")
    G("G", "⠛");

    private String descricao;
    private String descricaoBraille;

    RootStep(String descricao, String descricaoBraille) {
        this.descricao = descricao;
        this.descricaoBraille = descricaoBraille;
    }

    @Override
    public String toString() {
        return descricao;
    }

    @Override
    public String toBraille() {
        return descricaoBraille;
    }
}
