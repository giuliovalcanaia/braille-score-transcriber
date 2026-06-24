package br.com.braille.application;

import br.com.braille.xml.Score;

import java.io.IOException;
import java.nio.file.Paths;

public class Application {

    public static void main(String[] args) {
        String caminhoXml = "src/test/resources/Asa-Branca.musicxml";
        String caminhoSerial = "score-exportado.bin";

        Score score = new Score(caminhoXml);

        // Exportação
        ScorePersistence persistence = new ScorePersistence();
        try {
            persistence.salvar(score, caminhoSerial);
        } catch (IOException e) {
            System.err.println("Erro ao exportar Score: " + e.getMessage());
            return;
        }

        // Importação
        try {
            Score scoreImportado = persistence.carregar(caminhoSerial);
            System.out.println("Título em Braille: " + scoreImportado.toBraille().split("\\n")[0]);
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Erro ao importar Score: " + e.getMessage());
        }
    }
}
