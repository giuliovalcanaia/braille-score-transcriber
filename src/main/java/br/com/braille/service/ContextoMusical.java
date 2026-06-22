package br.com.braille.service;

import br.com.braille.xml.scorepartwise.part.measure.Note;

public abstract class ContextoMusical {
    protected static Note ultimaNota = null;
    protected static Note ultimaNotaReal = null;

    public static Note getUltimaNota() {
        return ultimaNota;
    }

    public static void setUltimaNota(Note ultimaNota) {
        ContextoMusical.ultimaNota = ultimaNota;
    }

    public static Note getUltimaNotaReal() {
        return ultimaNotaReal;
    }

    public static void setUltimaNotaReal(Note ultimaNotaReal) {
        ContextoMusical.ultimaNotaReal = ultimaNotaReal;
    }
}
