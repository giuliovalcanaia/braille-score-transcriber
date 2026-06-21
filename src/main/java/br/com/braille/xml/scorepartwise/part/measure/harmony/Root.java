package br.com.braille.xml.scorepartwise.part.measure.harmony;

import br.com.braille.xml.scorepartwise.part.measure.harmony.root.RootStep;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "root")
@XmlAccessorType(XmlAccessType.FIELD)
public class Root {

    @XmlElement(name = "root-step")
    private RootStep rootStep;

    public RootStep getRootStep() {
        return rootStep;
    }
}
