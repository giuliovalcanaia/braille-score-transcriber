package br.com.braille.exemplo;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

// Define que esta classe será a tag principal (raiz) do XML
@XmlRootElement(name = "score-partwise")
public class Partitura{

    private String credit;

    public Partitura() {}

    public Partitura(String credit) {
        this.credit = credit;
    }

    @XmlElement
    public String getCredit() {
        return credit;
    }

    @XmlElement
    public void setCredit(String credit) {
        this.credit = credit;
    }
}