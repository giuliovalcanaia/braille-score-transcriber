package br.com.braille.xml.scorepartwise.part.measure.note;

import br.com.braille.xml.scorepartwise.part.measure.note.tie.TiedType;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.FIELD)
public class Tied {

    @XmlAttribute(name = "type")
    private TiedType tiedType;

    public TiedType getTiedType() {
        return tiedType;
    }
}
