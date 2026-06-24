package br.com.braille.xml.score.scorepartwise.part.measure.note;

import br.com.braille.xml.score.scorepartwise.part.measure.note.tie.TiedType;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import java.io.Serial;
import java.io.Serializable;

@XmlAccessorType(XmlAccessType.FIELD)
public class Tied implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @XmlAttribute(name = "type")
    private TiedType tiedType;

    public TiedType getTiedType() {
        return tiedType;
    }
}
