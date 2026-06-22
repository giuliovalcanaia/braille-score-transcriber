package br.com.braille.service;

import br.com.braille.xml.scorepartwise.part.measure.Note;
import br.com.braille.xml.scorepartwise.part.measure.note.NoteType;
import br.com.braille.xml.scorepartwise.part.measure.note.pitch.Octave;
import br.com.braille.xml.scorepartwise.part.measure.note.pitch.Step;
import org.liblouis.*;
import org.liblouis.DisplayTable.StandardDisplayTables;

import java.util.HashMap;
import java.util.Map;

public class TranscritorParaBraille extends ContextoMusical{
    private static final String TABELA = "pt-pt-g1.utb";
    private static final Map<NoteType, Map<Step, String>> tabelaNotasBraille;
    private static final Map<NoteType, String> tabelaPausasBraille;

    // Inicialização estática - é tipo um construtor
    static {
        tabelaNotasBraille = new HashMap<>();
        tabelaPausasBraille = new HashMap<>();

        // WHOLE semibreve
        tabelaNotasBraille.put(NoteType.WHOLE, Map.of(
                Step.C, "⠽", Step.D, "⠵", Step.E, "⠯", Step.F, "⠿",
                Step.G, "⠷", Step.A, "⠮", Step.B, "⠾"
        ));
        // Duplica a tabela para 16th semicolcheia
        tabelaNotasBraille.put(NoteType.SIXTEENTH, tabelaNotasBraille.get(NoteType.WHOLE));

        // HALF Mínima
        tabelaNotasBraille.put(NoteType.HALF, Map.of(
                Step.C, "⠝", Step.D, "⠕", Step.E, "⠏", Step.F, "⠟",
                Step.G, "⠗", Step.A, "⠎", Step.B, "⠞"
        ));
        // Duplica a entrada para 32th fusa
        tabelaNotasBraille.put(NoteType.THIRTY_SECOND, tabelaNotasBraille.get(NoteType.HALF));

        // QUARTER semínima
        tabelaNotasBraille.put(NoteType.QUARTER, Map.of(
                Step.C, "⠹", Step.D, "⠱", Step.E, "⠫", Step.F, "⠻",
                Step.G, "⠳", Step.A, "⠪", Step.B, "⠺"
        ));
        // Duplica a entrada para 64th semifusa
        tabelaNotasBraille.put(NoteType.SIXTY_FOURTH, tabelaNotasBraille.get(NoteType.QUARTER));

        // EIGHTH colcheia
        tabelaNotasBraille.put(NoteType.EIGHTH, Map.of(
                Step.C, "⠙", Step.D, "⠑", Step.E, "⠋", Step.F, "⠛",
                Step.G, "⠓", Step.A, "⠊", Step.B, "⠚"
        ));
        // Duplica a entrada para 128th quartifusa
        tabelaNotasBraille.put(NoteType.ONE_HUNDRED_TWENTY_EIGHTH, tabelaNotasBraille.get(NoteType.EIGHTH));

        // Pausas
        tabelaPausasBraille.put(NoteType.WHOLE, "⠍");
        tabelaPausasBraille.put(NoteType.HALF, "⠥");
        tabelaPausasBraille.put(NoteType.QUARTER, "⠧");
        tabelaPausasBraille.put(NoteType.EIGHTH, "⠭");
        tabelaPausasBraille.put(NoteType.SIXTEENTH, "⠍");
        tabelaPausasBraille.put(NoteType.THIRTY_SECOND, "⠥");
        tabelaPausasBraille.put(NoteType.SIXTY_FOURTH, "⠧");
        tabelaPausasBraille.put(NoteType.ONE_HUNDRED_TWENTY_EIGHTH, "⠭");
    }

    public static String textoParaBraille(String texto) throws CompilationException, TranslationException, DisplayException {
        Translator translator = new Translator(TABELA);
        TranslationResult resultado = translator.translate(texto, null, null, null, StandardDisplayTables.UNICODE);
        return resultado.getBraille();
    }

    public static String notasParaBraille (NoteType noteType, Step step) {
        return tabelaNotasBraille.get(noteType).get(step);
    }

    public static String pausasParaBraille (NoteType noteType) {
        return tabelaPausasBraille.get(noteType);
    }

    public static boolean precisaOitava(Note notaAtual) {
//        System.out.println("Nota atual " + notaAtual);
//        System.out.println("Ultima nota " + ultimaNota);
        if (ultimaNota == null || notaAtual.isRest()) {
            ultimaNota = notaAtual;
            return false;
        }

        if (ultimaNotaReal == null) {
            ultimaNota = notaAtual;
            ultimaNotaReal = ultimaNota;
            return true;
        }

        ultimaNota = notaAtual;
        ultimaNotaReal = ultimaNota;
        int posAnterior = ((ultimaNotaReal.getPitch().getOctave().getDescricao() - 1) * 7) + ultimaNotaReal.getPitch().getStep().getReferencia();
        int posAtual  = ((notaAtual.getPitch().getOctave().getDescricao() - 1) * 7) + notaAtual.getPitch().getStep().getReferencia();
        int intervalo  = Math.abs(posAtual - posAnterior) + 1;

        if (intervalo <= 3) {
            ultimaNotaReal = ultimaNota;
            return false;
        } else if (intervalo <= 5) {
            return notaAtual.getPitch().getOctave() != ultimaNotaReal.getPitch().getOctave();
        } else {
            ultimaNotaReal = ultimaNota;
            return true;
        }

    }
}
