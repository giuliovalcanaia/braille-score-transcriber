package br.com.braille.service;

import org.liblouis.*;
import org.liblouis.DisplayTable.StandardDisplayTables;

public class TranscritorTextoBraille{
//    public static void main(String[] args) throws CompilationException, TranslationException, DisplayException {
//        Translator translator = new Translator("pt-pt-g1.utb");
//        TranslationResult resultado = translator.translate("Asa Branca", null, null, null, StandardDisplayTables.UNICODE);
//        String braille = resultado.getBraille();
//
//        System.out.println("Resultado em Braille: " + braille);
//    }

    public String toBraille(String texto) throws TranslationException, DisplayException, CompilationException {
        Translator translator = new Translator("pt-pt-g1.utb");
        TranslationResult resultado = translator.translate(texto, null, null, null, StandardDisplayTables.UNICODE);
        return resultado.getBraille();
    }
}