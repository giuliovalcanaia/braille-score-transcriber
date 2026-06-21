package br.com.braille.xml.scorepartwise.part.measure;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "print")
@XmlAccessorType(XmlAccessType.FIELD)
public class Print {

    @XmlAttribute(name = "new-system")
    private String newSystem;

    public boolean isNewSystem() {
        return "yes".equals(newSystem);
    }
}
