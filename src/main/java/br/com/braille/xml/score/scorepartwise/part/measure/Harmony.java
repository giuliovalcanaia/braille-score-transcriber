package br.com.braille.xml.score.scorepartwise.part.measure;

import br.com.braille.models.Brailleable;
import br.com.braille.xml.score.scorepartwise.part.measure.harmony.Kind;
import br.com.braille.xml.score.scorepartwise.part.measure.harmony.Root;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serial;
import java.io.Serializable;

@XmlRootElement(name = "harmony")
@XmlAccessorType(XmlAccessType.FIELD)
public class Harmony implements Brailleable, Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @XmlElement(name = "root")
    private Root root;

    @XmlElement(name = "kind")
    private Kind kind;

    public Root getRoot() {
        return root;
    }

    public Kind getKind() {
        return kind;
    }

    @Override
    public String toBraille() {
        String string = "";
        string += root.toBraille();
        string += kind.toBraille();
        return string;
    }

    @Override
    public String toString() {
        return root.toString() + kind.toString();
    }
}
