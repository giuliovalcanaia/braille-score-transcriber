package br.com.braille.application;

import br.com.braille.xml.Score;

import java.io.*;

/**
 * Classe criada para atender requisitos acadêmicos de importação/exportação
 * de objetos via Object streams. Não faz parte do domínio real do BrailleScoreTranscriber.
 */
public class ScorePersistence implements Exportavel {

    /**
     * Exporta (salva) o objeto Score em um arquivo usando ObjectOutputStream.
     *
     * @param score   objeto a ser persistido
     * @param caminho destino do arquivo
     * @throws IOException em caso de falha de I/O
     */
    public void salvar(Score score, String caminho) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(caminho))) {
            oos.writeObject(score);
        }
    }

    /**
     * Importa (carrega) o objeto Score de um arquivo usando ObjectInputStream.
     *
     * @param caminho origem do arquivo
     * @return Score recuperado
     * @throws IOException            em caso de falha de I/O
     * @throws ClassNotFoundException se a classe do objeto não for encontrada
     */
    public Score carregar(String caminho) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(caminho))) {
            return (Score) ois.readObject();
        }
    }

    @Override
    public void exportar(String caminho) throws IOException {
        throw new UnsupportedOperationException(
                "Use o método salvar(Score, String) para exportar um Score específico."
        );
    }
}
