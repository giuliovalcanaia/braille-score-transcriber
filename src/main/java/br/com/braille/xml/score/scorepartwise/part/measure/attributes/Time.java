package br.com.braille.xml.score.scorepartwise.part.measure.attributes;

import br.com.braille.models.Brailleable;
import br.com.braille.service.TranscreverParaBraille;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "time")
@XmlAccessorType(XmlAccessType.FIELD)
public class Time implements Brailleable {

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

    @Override
    public String toBraille() {
        // Remove o indicador numérico L invertido
        String numerador = TranscreverParaBraille.textoParaBraille(beats.toString()).substring(1);
        String denominador = switch (beatType) {
            case 1 -> "⠁";
            case 2 -> "⠃";
            case 4 -> "⠲";
            case 8 -> "⠦";
            case 16 -> "⠶";
            case 32 -> "⠾";
            case 64 -> "⠿";
            default -> throw new IllegalStateException("Unexpected value: " + beatType);
        };
        return "⠼" + numerador + denominador;
    }

    @Override
    public String toString() {
        return (beats.toString() + "/" + beatType.toString());
    }
}
