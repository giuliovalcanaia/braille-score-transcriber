package br.com.braille.app;

import br.com.braille.service.Desempacotador;
import br.com.braille.service.TranscritorTextoBraille;
import br.com.braille.xml.ScorePartwise;
import br.com.braille.xml.scorepartwise.part.Measure;
import br.com.braille.xml.scorepartwise.part.measure.Note;
import br.com.braille.xml.scorepartwise.part.measure.note.pitch.Octave;
import org.liblouis.CompilationException;
import org.liblouis.DisplayException;
import org.liblouis.TranslationException;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.FileNotFoundException;
import java.util.List;

public class Aplication {

    public static void main(String[] args) throws JAXBException, FileNotFoundException, ParserConfigurationException, SAXException, CompilationException, TranslationException, DisplayException {
        String testFilePath;
        Desempacotador desempacotador;
        ScorePartwise scorePartwise;

        testFilePath = "src/test/resources/Asa-Branca.musicxml";
        desempacotador = new Desempacotador(testFilePath);
        scorePartwise = desempacotador.carregarPartitura();

        String titulo = scorePartwise.getCredits().get(0).getCreditWords();
        List<Measure> compassos = scorePartwise.getParts().get(0).getMeasures();

        System.out.println("Partitura transcrita em braille");
        System.out.println("=====================================================");

        // Título
        System.out.println(TranscritorTextoBraille.toBraille(titulo));

        // Fórmula de compasso
        System.out.println(compassos.get(0).getAttributes().getTime().toBraille());

        // Clave
        System.out.print(compassos.get(0).getAttributes().getClef().getSign().toBraille() + " ");

        // Compassos
        Octave previousOctave = null;
        for (Measure compasso : compassos) {
            for (Note nota : compasso.getNotes()) {
                if (!nota.isRest() && nota.getPitch() != null && nota.getPitch().getOctave() != null) {
                    Octave currentOctave = nota.getPitch().getOctave();
                    if (!currentOctave.equals(previousOctave)) {
                        System.out.print(currentOctave.toBraille());
                        previousOctave = currentOctave;
                    }
                }
                String braille = nota.toBraille();
                System.out.print(braille);
            }
            System.out.print(" ");
            if (compasso.isPrint()) {
                System.out.println();
            }
        }
        System.out.println();

        System.out.println("=====================================================");


        System.out.println("=====================================================");
        System.out.println("Partitura transcrita em braille com explicação");
        System.out.println("Título: " + TranscritorTextoBraille.toBraille(titulo));
        System.out.println("Título: " + titulo);

        for (int i = 0; i < titulo.length(); i++) {
            char caractere = titulo.charAt(i);
            String braille = TranscritorTextoBraille.toBraille(String.valueOf(caractere));
            System.out.println(caractere + " = " + braille);
        }


        System.out.println("=====================================================");
    }
}
