package br.com.braille.xml.scorepartwise;

import br.com.braille.xml.scorepartwise.part.Measure;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "part")
@XmlAccessorType(XmlAccessType.FIELD)
public class Part{

    @XmlAttribute
    private String id;

    private List<Measure> measures = new ArrayList<>();

    public String getId() {
        return id;
    }

    public List<Measure> getMeasures() {
        return measures;
    }
}
