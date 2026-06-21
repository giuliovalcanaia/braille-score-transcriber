package br.com.braille.service;

import org.liblouis.*;
import org.liblouis.DisplayTable.StandardDisplayTables;

public class TranscritorTextoBraille{

    public String toBraille(String texto) throws TranslationException, DisplayException, CompilationException {
        Translator translator = new Translator("pt-pt-g1.utb");
        TranslationResult resultado = translator.translate(texto, null, null, null, StandardDisplayTables.UNICODE);
        return resultado.getBraille();
    }
}