package br.com.braille.application;

import br.com.braille.xml.Score;

import java.io.*;

public class ScorePersistence implements Exportavel {

    public void salvar(Score score, String caminho) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(caminho))) {
            oos.writeObject(score);
        }
    }

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
