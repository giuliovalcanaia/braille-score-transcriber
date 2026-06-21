package br.com.braille.model;

import br.com.braille.service.Desempacotador;
import br.com.braille.xml.ScorePartwise;
import br.com.braille.xml.scorepartwise.part.Measure;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.FileNotFoundException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ScoreTest {
    private String testFilePath;
    private Desempacotador desempacotador;
    private ScorePartwise scorePartwise;

    @BeforeEach
    public void setUp() throws JAXBException, FileNotFoundException, ParserConfigurationException, SAXException {
        this.testFilePath = "/home/giulio/braille-xml/src/test/resources/Asa-Branca.musicxml";
        desempacotador = new Desempacotador(testFilePath);
        scorePartwise = desempacotador.carregarPartitura();
    }

    @Test
    @DisplayName("Verifica título")
    void validaTitulo() {
        assertEquals("Asa branca", scorePartwise.getCredits().getFirst().getCreditWords());
    }

    @Test
    @DisplayName("Verifica leitura dos compassos")
    public void validaCompassos() {
        List<Measure> measures = scorePartwise.getParts().getFirst().getMeasures();

        // Verifica se a scorePartwise possui 26 compassos
        assertEquals(26, measures.size());


        for (int i = 0; i < 26; i++) {
            assertEquals(i + 1, Integer.parseInt(measures.get(i).getNumber()));
        }
    }

    @Test
    @DisplayName("Verifica atribuição de divisões")
    public void validaAtributosPrimeiroCompasso() {

    }
}
