package br.com.braille.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.liblouis.CompilationException;
import org.liblouis.DisplayException;
import org.liblouis.TranslationException;

import static org.junit.jupiter.api.Assertions.*;

public class TranscritorTextoBrailleTest {
    @Test
    @DisplayName("Teste 1: Transcrição caractere `a` para português")
    public void validaCaracteresimples() throws CompilationException, TranslationException, DisplayException {
        TranscritorTextoBraille ttb = new TranscritorTextoBraille();
        String textoTranscrito = ttb.toBraille("a");
        assertEquals("⠁", textoTranscrito);
    }

}