package br.com.braille.xml.scorepartwise.part.measure.harmony;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "root")
@XmlAccessorType(XmlAccessType.FIELD)
public class Root {

    @XmlElement(name = "root-step")
    private String rootStep;

    public String getRootStep() {
        return rootStep;
    }
}
