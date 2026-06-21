package br.com.braille.service;

import org.liblouis.*;
import org.liblouis.DisplayTable.StandardDisplayTables;

public class TranscritorTextoBraille{

    private static final String TABELA = "pt-pt-g1.utb";

    public static String toBraille(String texto) throws CompilationException, TranslationException, DisplayException {
        Translator translator = new Translator(TABELA);
        TranslationResult resultado = translator.translate(texto, null, null, null, StandardDisplayTables.UNICODE);
        return resultado.getBraille();
    }
}
