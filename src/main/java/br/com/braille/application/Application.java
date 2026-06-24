package br.com.braille.application;

import br.com.braille.xml.Score;

import java.io.IOException;
import java.nio.file.Paths;

/**
 * Classe de aplicação criada para demonstrar os requisitos acadêmicos
 * de classe abstrata, interface, importação e exportação de objetos.
 * Não faz parte do domínio real do BrailleScoreTranscriber.
 */
public class Application {

    public static void main(String[] args) {
        String caminhoXml = Paths.get("src", "test", "resources", "Asa-Branca.musicxml").toString();
        String caminhoSerial = "score-exportado.bin";

        System.out.println("Carregando partitura do MusicXML...");
        Score score = new Score(caminhoXml);

        System.out.println("Exportando Score para arquivo binário...");
        ScorePersistence persistence = new ScorePersistence();
        try {
            persistence.salvar(score, caminhoSerial);
            System.out.println("Score exportado com sucesso: " + caminhoSerial);
        } catch (IOException e) {
            System.err.println("Erro ao exportar Score: " + e.getMessage());
            return;
        }

        System.out.println("Importando Score do arquivo binário...");
        try {
            Score scoreImportado = persistence.carregar(caminhoSerial);
            System.out.println("Score importado com sucesso!");
            System.out.println("Título em Braille: " + scoreImportado.toBraille().split("\\n")[0]);
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Erro ao importar Score: " + e.getMessage());
        }
    }
}
