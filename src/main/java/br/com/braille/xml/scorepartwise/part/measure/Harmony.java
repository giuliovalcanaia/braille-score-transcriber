package br.com.braille.xml.scorepartwise.part.measure;

import br.com.braille.xml.scorepartwise.part.measure.harmony.Root;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "harmony")
@XmlAccessorType(XmlAccessType.FIELD)
public class Harmony {

    private Root root;

    @XmlElement(name = "kind")
    private String kind;

    public Root getRoot() {
        return root;
    }

    public String getKind() {
        return kind;
    }
}
