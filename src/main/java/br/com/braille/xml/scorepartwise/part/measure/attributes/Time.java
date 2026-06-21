package br.com.braille.xml.scorepartwise.part.measure.attributes;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "time")
@XmlAccessorType(XmlAccessType.FIELD)
public class Time {

    @XmlElement(name = "beats")
    private Integer beats;

    @XmlElement(name = "beat-type")
    private Integer beatType;

    public Integer getBeats() {
        return beats;
    }

    public Integer getBeatType() {
        return beatType;
    }
}
