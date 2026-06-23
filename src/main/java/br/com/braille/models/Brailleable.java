package br.com.braille.models;

import org.liblouis.CompilationException;
import org.liblouis.DisplayException;
import org.liblouis.TranslationException;

public interface Brailleable {

    public String toBraille() throws CompilationException, TranslationException, DisplayException;
}
