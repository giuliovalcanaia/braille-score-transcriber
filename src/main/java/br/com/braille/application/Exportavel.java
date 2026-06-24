package br.com.braille.application;

import java.io.IOException;

/**
 * Interface criada para atender requisitos acadêmicos de persistência de objetos.
 * Não faz parte do domínio real do BrailleScoreTranscriber.
 */
public interface Exportavel {

    /**
     * Exporta o conteúdo gerenciado para o caminho informado.
     *
     * @param caminho destino do arquivo
     * @throws IOException em caso de falha de I/O
     */
    void exportar(String caminho) throws IOException;
}
