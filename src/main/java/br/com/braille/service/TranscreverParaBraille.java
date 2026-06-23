package br.com.braille.service;

import br.com.braille.xml.score.scorepartwise.part.measure.Note;
import br.com.braille.xml.score.scorepartwise.part.measure.note.NoteType;
import br.com.braille.xml.score.scorepartwise.part.measure.note.pitch.Step;
import org.liblouis.*;
import org.liblouis.DisplayTable.StandardDisplayTables;

import java.util.HashMap;
import java.util.Map;

public class TranscreverParaBraille {
    private static final String TABELA = "pt-pt-g1.utb";
    private static final Translator TRANSLATOR;
    private static final Map<NoteType, Map<Step, String>> tabelaNotasBraille;
    private static final Map<NoteType, String> tabelaPausasBraille;

    // Inicialização estática - é tipo um construtor
    static {
        tabelaNotasBraille = new HashMap<>();

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
        tabelaPausasBraille = new HashMap<>();

        tabelaPausasBraille.put(NoteType.WHOLE, "⠍");
        tabelaPausasBraille.put(NoteType.HALF, "⠥");
        tabelaPausasBraille.put(NoteType.QUARTER, "⠧");
        tabelaPausasBraille.put(NoteType.EIGHTH, "⠭");
        tabelaPausasBraille.put(NoteType.SIXTEENTH, "⠍");
        tabelaPausasBraille.put(NoteType.THIRTY_SECOND, "⠥");
        tabelaPausasBraille.put(NoteType.SIXTY_FOURTH, "⠧");
        tabelaPausasBraille.put(NoteType.ONE_HUNDRED_TWENTY_EIGHTH, "⠭");

        // Liblouis
        try {
            TRANSLATOR = new Translator(TABELA);
        } catch (CompilationException e) {
            throw new RuntimeException("Erro ao inicializar tradutor braille", e);
        }
    }

    public static String textoParaBraille(String texto) throws TranslationException, DisplayException {
        TranslationResult resultado = TRANSLATOR.translate(texto, null, null, null, StandardDisplayTables.UNICODE);
        return resultado.getBraille();
    }

    public static String notasParaBraille (NoteType noteType, Step step) {
        return tabelaNotasBraille.get(noteType).get(step);
    }

    public static String pausasParaBraille (NoteType noteType) {
        return tabelaPausasBraille.get(noteType);
    }

}
