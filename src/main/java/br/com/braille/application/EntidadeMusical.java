package br.com.braille.application;

import java.io.Serializable;

/**
 * Classe abstrata de exemplo criada para atender requisitos acadêmicos.
 * Não faz parte do domínio real do BrailleScoreTranscriber.
 */
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

    /**
     * Método abstrato que deve ser implementado pelas subclasses.
     */
    public abstract String toBrailleResumido();
}
