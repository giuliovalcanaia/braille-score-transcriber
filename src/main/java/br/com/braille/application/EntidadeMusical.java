package br.com.braille.application;

import java.io.Serializable;

public abstract class EntidadeMusical implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    public EntidadeMusical(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public abstract String toBrailleResumido();
}
