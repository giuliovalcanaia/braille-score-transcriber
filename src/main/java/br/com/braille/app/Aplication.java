package br.com.braille.app;

import br.com.braille.service.ContextoMusical;
import br.com.braille.service.Desempacotador;
import br.com.braille.service.TranscritorParaBraille;
import br.com.braille.xml.ScorePartwise;
import br.com.braille.xml.scorepartwise.part.Measure;
import br.com.braille.xml.scorepartwise.part.measure.Note;
import br.com.braille.xml.scorepartwise.part.measure.note.Pitch;
import br.com.braille.xml.scorepartwise.part.measure.note.pitch.Octave;
import br.com.braille.xml.scorepartwise.part.measure.note.pitch.Step;
import org.liblouis.CompilationException;
import org.liblouis.DisplayException;
import org.liblouis.TranslationException;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.FileNotFoundException;
import java.util.List;

public class Aplication extends ContextoMusical {

    public static void main(String[] args) throws JAXBException, FileNotFoundException, ParserConfigurationException, SAXException, CompilationException, TranslationException, DisplayException {
        String testFilePath;
        Desempacotador desempacotador;
        ScorePartwise scorePartwise;

        testFilePath = "src/test/resources/Asa-Branca.musicxml";
        desempacotador = new Desempacotador(testFilePath);
        scorePartwise = desempacotador.carregarPartitura();

        String titulo = scorePartwise.getCredits().get(0).getCreditWords();
        List<Measure> compassos = scorePartwise.getParts().get(0).getMeasures();

        System.out.println("==== Partitura transcrita em braille ====");

        // Título
        System.out.println(TranscritorParaBraille.textoParaBraille(titulo));

        // Fórmula de compasso
        System.out.print(compassos.get(0).getAttributes().getTime().toBraille());

        // Compassos
        Boolean imprimiuClave = false;
        for (int i = 0; i < compassos.size(); i++) {
            if (compassos.get(i).isPrint()) {
                // Imprime a quebra de linha
                System.out.println();
            }
            if (!imprimiuClave) {
                // Clave
                System.out.print(compassos.get(0).getAttributes().getClef().getSign().toBraille() + " ");
                imprimiuClave = true;
            }
            for (Note nota : compassos.get(i).getNotes()) {
                if (TranscritorParaBraille.precisaOitava(nota)) {
                    System.out.print(nota.getPitch().getOctave().toBraille());
                }
                // Imprime as notas
                System.out.print(nota.toBraille());
            }
            // Imprime as marcações de compasso
            System.out.print(" ");
        }

        setUltimaNota(null);
        setUltimaNotaReal(null);

        System.out.println();

        System.out.println("=========================================");

        System.out.println("======== Partitura com explicação =======");

        // Título
        System.out.println("Título: " + TranscritorParaBraille.textoParaBraille(titulo));
        System.out.println("Título: " + titulo);
        System.out.println();

        // Fórmula de compasso
        System.out.println("Fórmula de compasso: " + compassos.get(0).getAttributes().getTime().toBraille());
        System.out.println("Fórmula de compasso: " + compassos.get(0).getAttributes().getTime().toString());

        // Compassos
        imprimiuClave = false;
        for (int i = 0; i < compassos.size(); i++) {
            if (compassos.get(i).isPrint()) {
                // Imprime a quebra de linha
                System.out.println();
            }
            if (!imprimiuClave) {
                // Clave
                System.out.println("Clave: " + compassos.get(0).getAttributes().getClef().getSign().toBraille() + " ");
                System.out.println("Clave: " + compassos.get(0).getAttributes().getClef().getSign().toString() + " ");
                imprimiuClave = true;
            }
            System.out.println();
            System.out.println("Compasso " + (i + 1));
            for (Note nota : compassos.get(i).getNotes()) {
                if (TranscritorParaBraille.precisaOitava(nota)) {
                    System.out.print(nota.getPitch().getOctave().toBraille() + " = ");
                    System.out.println("Oitava " + nota.getPitch().getOctave().toString());
                }
                // Imprime as notas
                System.out.print(nota.toBraille() + " = ");
                System.out.println(nota.toString());
            }
            // Imprime as marcações de compasso
            System.out.println(" ");
        }
        System.out.println();

        System.out.println("=========================================");


    }
}
