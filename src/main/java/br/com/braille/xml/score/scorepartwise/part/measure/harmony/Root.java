package br.com.braille.xml.score.scorepartwise.part.measure.harmony;

import br.com.braille.models.Brailleable;
import br.com.braille.xml.score.scorepartwise.part.measure.harmony.root.RootStep;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serial;
import java.io.Serializable;

@XmlRootElement(name = "root")
@XmlAccessorType(XmlAccessType.FIELD)
public class Root implements Brailleable, Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @XmlElement(name = "root-step")
    private RootStep rootStep;

    public RootStep getRootStep() {
        return rootStep;
    }

    @Override
    public String toBraille() {
        return rootStep.toBraille();
    }
}
