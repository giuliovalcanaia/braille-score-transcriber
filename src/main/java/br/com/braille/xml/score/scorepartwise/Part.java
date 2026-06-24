package br.com.braille.xml.score.scorepartwise;

import br.com.braille.xml.score.scorepartwise.part.Measure;

import javax.xml.bind.annotation.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "part")
@XmlAccessorType(XmlAccessType.FIELD)
public class Part implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @XmlAttribute
    private String id;

    @XmlElement(name = "measure")
    private List<Measure> measures = new ArrayList<>();

    public String getId() {
        return id;
    }

    public List<Measure> getMeasures() {
        return measures;
    }
}
