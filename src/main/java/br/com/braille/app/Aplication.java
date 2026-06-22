package br.com.braille.app;

import br.com.braille.service.Desempacotador;
import br.com.braille.service.TranscritorTextoBraille;
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

//        System.out.println("Partitura transcrita em braille");
//        System.out.println("=====================================================");

        // Título
        System.out.println(TranscritorTextoBraille.textoParaBraille(titulo));

        // Fórmula de compasso
        System.out.println(compassos.get(0).getAttributes().getTime().toBraille());

        // Clave
        System.out.print(compassos.get(0).getAttributes().getClef().getSign().toBraille() + " ");

        // Compassos
        Pitch previousPitch = null;
        for (Measure compasso : compassos) {
            for (Note nota : compasso.getNotes()) {
                if (!nota.isRest() && nota.getPitch() != null && nota.getPitch().getOctave() != null) {
                    Pitch currentPitch = nota.getPitch();
                    if (previousPitch == null || needsOctaveMark(previousPitch, currentPitch)) {
                        System.out.print(currentPitch.getOctave().toBraille());
                    }
                    previousPitch = currentPitch;
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

//        System.out.println("=====================================================");


//        System.out.println("=====================================================");
//        System.out.println("Partitura transcrita em braille com explicação");
//        System.out.println("Título: " + TranscritorTextoBraille.textoParaBraille(titulo));
//        System.out.println("Título: " + titulo);
//
//        for (int i = 0; i < titulo.length(); i++) {
//            char caractere = titulo.charAt(i);
//            String braille = TranscritorTextoBraille.textoParaBraille(String.valueOf(caractere));
//            System.out.println(caractere + " = " + braille);
//        }
//
//
//        System.out.println("=====================================================");
    }

    private static int stepIndex(Step step) {
        return switch (step) {
            case C -> 0;
            case D -> 1;
            case E -> 2;
            case F -> 3;
            case G -> 4;
            case A -> 5;
            case B -> 6;
        };
    }

    private static int octaveValue(Octave octave) {
        return switch (octave) {
            case FIRST -> 1;
            case SECOND -> 2;
            case THIRD -> 3;
            case FOURTH -> 4;
            case FIFTH -> 5;
            case SIXTH -> 6;
            case SEVENTH -> 7;
        };
    }

    private static int diatonicIndex(Pitch pitch) {
        return stepIndex(pitch.getStep()) + 7 * octaveValue(pitch.getOctave());
    }

    private static boolean needsOctaveMark(Pitch previous, Pitch current) {
        int delta = diatonicIndex(current) - diatonicIndex(previous);
        int intervalNumber = Math.abs(delta) + 1;
        int simpleInterval = ((intervalNumber - 1) % 7) + 1;
        return switch (simpleInterval) {
            case 1 -> delta != 0;
            case 2, 3 -> false;
            case 4, 5 -> !current.getOctave().equals(previous.getOctave());
            default -> true;
        };
    }
}
