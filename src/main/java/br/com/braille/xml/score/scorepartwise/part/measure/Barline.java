package br.com.braille.xml.score.scorepartwise.part.measure;

import br.com.braille.xml.score.scorepartwise.part.measure.barline.Ending;
import br.com.braille.xml.score.scorepartwise.part.measure.barline.Location;
import br.com.braille.xml.score.scorepartwise.part.measure.barline.Repeat;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serial;
import java.io.Serializable;

@XmlRootElement(name = "barline")
@XmlAccessorType(XmlAccessType.FIELD)
public class Barline implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @XmlAttribute(name = "location")
    private Location location;

    @XmlElement(name = "ending")
    private Ending ending;

    @XmlElement(name = "repeat")
    private Repeat repeat;

    public Location getLocation() {
        return location;
    }

    public Ending getEnding() {
        return ending;
    }

    public Repeat getRepeat() {
        return repeat;
    }
}
