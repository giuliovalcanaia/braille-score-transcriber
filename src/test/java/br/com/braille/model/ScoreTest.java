package br.com.braille.model;

import br.com.braille.service.Desempacotador;
import br.com.braille.xml.ScorePartwise;
import br.com.braille.xml.scorepartwise.part.Measure;
import br.com.braille.xml.scorepartwise.part.measure.Attributes;
import br.com.braille.xml.scorepartwise.part.measure.Barline;
import br.com.braille.xml.scorepartwise.part.measure.Harmony;
import br.com.braille.xml.scorepartwise.part.measure.Note;
import br.com.braille.xml.scorepartwise.part.measure.barline.Ending;
import br.com.braille.xml.scorepartwise.part.measure.harmony.root.RootStep;
import br.com.braille.xml.scorepartwise.part.measure.note.pitch.Step;
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
        this.testFilePath = "src/test/resources/Asa-Branca.musicxml";
        desempacotador = new Desempacotador(testFilePath);
        scorePartwise = desempacotador.carregarPartitura();
    }

    @Test
    @DisplayName("Teste 1: Verifica título")
    void validaTitulo() {
        assertEquals("Asa branca", scorePartwise.getCredits().get(0).getCreditWords());
    }

    @Test
    @DisplayName("Teste 2: Verifica leitura dos compassos")
    public void validaCompassos() {
        List<Measure> measures = scorePartwise.getParts().get(0).getMeasures();

        // Verifica se a scorePartwise possui 26 compassos
        assertEquals(26, measures.size());


        for (int i = 0; i < 26; i++) {
            assertEquals(i + 1, Integer.parseInt(measures.get(i).getNumber()));
        }
    }

    @Test
    @DisplayName("Teste 3: Verifica atribuição de divisões")
    public void validaAtributosPrimeiroCompasso() {
        Attributes attributes = scorePartwise.getParts().get(0).getMeasures().get(0).getAttributes();

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
        List<Note> notes = scorePartwise.getParts().get(0).getMeasures().get(0).getNotes();

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
        assertEquals(Step.G, n2.getPitch().getStep());
        assertEquals(4, n2.getPitch().getOctave());

        Note n3 = notes.get(2);
        assertFalse(n3.isRest());
        assertEquals(1, n3.getDuration());
        assertEquals("eighth", n3.getType());
        assertEquals(Step.A, n3.getPitch().getStep());
        assertEquals(4, n3.getPitch().getOctave());
    }

    @Test
    @DisplayName("Teste 5: Verifica notas e harmonia do segundo compasso")
    public void validaNotasHarmoniaSegundoCompasso() {
        Measure measure2 = scorePartwise.getParts().get(0).getMeasures().get(1);

        Harmony harmony = measure2.getHarmonies().get(0);
        assertEquals(RootStep.G, harmony.getRoot().getRootStep());
        assertEquals("major", harmony.getKind());

        List<Note> notes = measure2.getNotes();
        assertEquals(2, notes.size());

        Note n1 = notes.get(0);
        assertFalse(n1.isRest());
        assertEquals(2, n1.getDuration());
        assertEquals("quarter", n1.getType());
        assertEquals(Step.B, n1.getPitch().getStep());
        assertEquals(4, n1.getPitch().getOctave());

        Note n2 = notes.get(1);
        assertFalse(n2.isRest());
        assertEquals(2, n2.getDuration());
        assertEquals("quarter", n2.getType());
        assertEquals(Step.D, n2.getPitch().getStep());
        assertEquals(5, n2.getPitch().getOctave());
    }

    @Test
    @DisplayName("Teste 6: Verifica barline do nono compasso")
    public void validaBarlineNonoCompasso() {
        Measure compasso9 = scorePartwise.getParts().get(0).getMeasures().get(8);

        Barline barline = compasso9.getBarlines().get(0);
        assertEquals("left", barline.getLocation());
        assertEquals("forward", barline.getRepeat().getDirection());
    }

    @Test
    @DisplayName("Teste 7: Verifica barlines do décimo sexto compasso")
    public void validaBarlinesDecimoSextoCompasso() {
        Measure compasso16 = scorePartwise.getParts().get(0).getMeasures().get(15);

        assertEquals(2, compasso16.getBarlines().size());

        Barline esquerda = compasso16.getBarlines().get(0);
        assertEquals("left", esquerda.getLocation());
        assertEquals("1", esquerda.getEnding().getNumber());
        assertEquals("start", esquerda.getEnding().getType());

        Barline direita = compasso16.getBarlines().get(1);
        assertEquals("right", direita.getLocation());
        assertEquals("1", direita.getEnding().getNumber());
        assertEquals("stop", direita.getEnding().getType());
        assertEquals("backward", direita.getRepeat().getDirection());
    }

    @Test
    @DisplayName("Teste 8: Verifica compasso 17")
    public void validaCompassoDezessete() {
        Measure compasso17 = scorePartwise.getParts().get(0).getMeasures().get(16);

        assertEquals(2, compasso17.getBarlines().size());

        Barline esquerda = compasso17.getBarlines().get(0);
        assertEquals("left", esquerda.getLocation());
        assertEquals("2", esquerda.getEnding().getNumber());
        assertEquals("start", esquerda.getEnding().getType());

        Barline direita = compasso17.getBarlines().get(1);
        assertEquals("right", direita.getLocation());
        assertEquals("2", direita.getEnding().getNumber());
        assertEquals("discontinue", direita.getEnding().getType());

        Harmony harmony = compasso17.getHarmonies().get(0);
        assertEquals(RootStep.G, harmony.getRoot().getRootStep());
        assertEquals("major", harmony.getKind());

        List<Note> notes = compasso17.getNotes();
        assertEquals(3, notes.size());

        Note n1 = notes.get(0);
        assertFalse(n1.isRest());
        assertEquals(2, n1.getDuration());
        assertEquals("quarter", n1.getType());
        assertEquals(Step.G, n1.getPitch().getStep());
        assertEquals(4, n1.getPitch().getOctave());

        Note n2 = notes.get(1);
        assertFalse(n2.isRest());
        assertEquals(1, n2.getDuration());
        assertEquals("eighth", n2.getType());
        assertEquals(Step.F, n2.getPitch().getStep());
        assertEquals(5, n2.getPitch().getOctave());

        Note n3 = notes.get(2);
        assertFalse(n3.isRest());
        assertEquals(1, n3.getDuration());
        assertEquals("eighth", n3.getType());
        assertEquals(Step.D, n3.getPitch().getStep());
        assertEquals(5, n3.getPitch().getOctave());
    }

    @Test
    @DisplayName("Teste 9: Verifica compasso 26")
    public void validaCompassoVinteSeis() {
        Measure compasso26 = scorePartwise.getParts().get(0).getMeasures().get(25);

        assertNull(compasso26.getAttributes());

        assertTrue(compasso26.getHarmonies().isEmpty());

        Barline barline = compasso26.getBarlines().get(0);
        assertEquals("right", barline.getLocation());
        assertNull(barline.getEnding());
        assertNull(barline.getRepeat());

        List<Note> notes = compasso26.getNotes();
        assertEquals(1, notes.size());
        Note note = notes.get(0);
        assertTrue(note.isRest());
        assertEquals(4, note.getDuration());
        assertEquals("half", note.getType());
    }
}
