package br.com.braille.model;

import br.com.braille.service.Desempacotador;
import br.com.braille.xml.ScorePartwise;
import br.com.braille.xml.scorepartwise.part.Measure;
import br.com.braille.xml.scorepartwise.part.measure.Attributes;
import br.com.braille.xml.scorepartwise.part.measure.Note;
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
    @DisplayName("Teste 1: Verifica título")
    void validaTitulo() {
        assertEquals("Asa branca", scorePartwise.getCredits().getFirst().getCreditWords());
    }

    @Test
    @DisplayName("Teste 2: Verifica leitura dos compassos")
    public void validaCompassos() {
        List<Measure> measures = scorePartwise.getParts().getFirst().getMeasures();

        // Verifica se a scorePartwise possui 26 compassos
        assertEquals(26, measures.size());


        for (int i = 0; i < 26; i++) {
            assertEquals(i + 1, Integer.parseInt(measures.get(i).getNumber()));
        }
    }

    @Test
    @DisplayName("Teste 3: Verifica atribuição de divisões")
    public void validaAtributosPrimeiroCompasso() {
        Attributes attributes = scorePartwise.getParts().getFirst().getMeasures().getFirst().getAttributes();

        assertEquals(2, attributes.getDivisions());
        assertEquals(0, attributes.getKey().getFifths());
        assertEquals(2, attributes.getTime().getBeats());
        assertEquals(4, attributes.getTime().getBeatType());
        assertEquals("G", attributes.getClef().getSign());
        assertEquals(2, attributes.getClef().getLine());
    }

    @Test
    @DisplayName("Teste 4: Verifica notas do primeiro compasso")
    public void validaNotasPrimeiroCompasso() {
        List<Note> notes = scorePartwise.getParts().getFirst().getMeasures().getFirst().getNotes();

        assertEquals(3, notes.size());

        Note n1 = notes.get(0);
        assertTrue(n1.isRest());
        assertNull(n1.getPitch());
        assertEquals(2, n1.getDuration());
        assertEquals("quarter", n1.getType());

        Note n2 = notes.get(1);
        assertFalse(n2.isRest());
        assertEquals(1, n2.getDuration());
        assertEquals("eighth", n2.getType());
        assertEquals("G", n2.getPitch().getStep());
        assertEquals(4, n2.getPitch().getOctave());

        Note n3 = notes.get(2);
        assertFalse(n3.isRest());
        assertEquals(1, n3.getDuration());
        assertEquals("eighth", n3.getType());
        assertEquals("A", n3.getPitch().getStep());
        assertEquals(4, n3.getPitch().getOctave());
    }

    
}
