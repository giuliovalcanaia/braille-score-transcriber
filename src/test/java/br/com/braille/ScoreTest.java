package br.com.braille;

import br.com.braille.service.Desempacotador;
import br.com.braille.service.TranscritorTextoBraille;
import br.com.braille.xml.ScorePartwise;
import br.com.braille.xml.scorepartwise.part.Measure;
import br.com.braille.xml.scorepartwise.part.measure.Attributes;
import br.com.braille.xml.scorepartwise.part.measure.Barline;
import br.com.braille.xml.scorepartwise.part.measure.Harmony;
import br.com.braille.xml.scorepartwise.part.measure.Note;
import br.com.braille.xml.scorepartwise.part.measure.barline.Location;
import br.com.braille.xml.scorepartwise.part.measure.barline.repeat.Direction;
import br.com.braille.xml.scorepartwise.part.measure.barline.ending.EndingType;
import br.com.braille.xml.scorepartwise.part.measure.harmony.Kind;
import br.com.braille.xml.scorepartwise.part.measure.harmony.root.RootStep;
import br.com.braille.xml.scorepartwise.part.measure.note.NoteType;
import br.com.braille.xml.scorepartwise.part.measure.note.pitch.Step;
import br.com.braille.xml.scorepartwise.part.measure.attributes.Clef;
import br.com.braille.xml.scorepartwise.part.measure.attributes.Time;
import br.com.braille.xml.scorepartwise.part.measure.attributes.clef.Sign;
import br.com.braille.xml.scorepartwise.part.measure.note.pitch.Octave;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.liblouis.*;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.FileNotFoundException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ScoreTest {
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
        assertEquals(Sign.G, attributes.getClef().getSign());
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
        assertEquals(NoteType.QUARTER, n1.getType());

        Note n2 = notes.get(1);
        assertFalse(n2.isRest());
        assertEquals(1, n2.getDuration());
        assertEquals(NoteType.EIGHTH, n2.getType());
        assertEquals(Step.G, n2.getPitch().getStep());
        assertEquals(Octave.FOURTH, n2.getPitch().getOctave());

        Note n3 = notes.get(2);
        assertFalse(n3.isRest());
        assertEquals(1, n3.getDuration());
        assertEquals(NoteType.EIGHTH, n3.getType());
        assertEquals(Step.A, n3.getPitch().getStep());
        assertEquals(Octave.FOURTH, n3.getPitch().getOctave());
    }

    @Test
    @DisplayName("Teste 5: Verifica notas e harmonia do segundo compasso")
    public void validaNotasHarmoniaSegundoCompasso() {
        Measure measure2 = scorePartwise.getParts().get(0).getMeasures().get(1);

        Harmony harmony = measure2.getHarmonies().get(0);
        assertEquals(RootStep.G, harmony.getRoot().getRootStep());
        assertEquals(Kind.MAJOR, harmony.getKind());

        List<Note> notes = measure2.getNotes();
        assertEquals(2, notes.size());

        Note n1 = notes.get(0);
        assertFalse(n1.isRest());
        assertEquals(2, n1.getDuration());
        assertEquals(NoteType.QUARTER, n1.getType());
        assertEquals(Step.B, n1.getPitch().getStep());
        assertEquals(Octave.FOURTH, n1.getPitch().getOctave());

        Note n2 = notes.get(1);
        assertFalse(n2.isRest());
        assertEquals(2, n2.getDuration());
        assertEquals(NoteType.QUARTER, n2.getType());
        assertEquals(Step.D, n2.getPitch().getStep());
        assertEquals(Octave.FIFTH, n2.getPitch().getOctave());
    }

    @Test
    @DisplayName("Teste 6: Verifica barline do nono compasso")
    public void validaBarlineNonoCompasso() {
        Measure compasso9 = scorePartwise.getParts().get(0).getMeasures().get(8);

        Barline barline = compasso9.getBarlines().get(0);
        assertEquals(Location.LEFT, barline.getLocation());
        assertEquals(Direction.FORWARD, barline.getRepeat().getDirection());
    }

    @Test
    @DisplayName("Teste 7: Verifica barlines do décimo sexto compasso")
    public void validaBarlinesDecimoSextoCompasso() {
        Measure compasso16 = scorePartwise.getParts().get(0).getMeasures().get(15);

        assertEquals(2, compasso16.getBarlines().size());

        Barline esquerda = compasso16.getBarlines().get(0);
        assertEquals(Location.LEFT, esquerda.getLocation());
        assertEquals("1", esquerda.getEnding().getNumber());
        assertEquals(EndingType.START, esquerda.getEnding().getType());

        Barline direita = compasso16.getBarlines().get(1);
        assertEquals(Location.RIGHT, direita.getLocation());
        assertEquals("1", direita.getEnding().getNumber());
        assertEquals(EndingType.STOP, direita.getEnding().getType());
        assertEquals(Direction.BACKWARD, direita.getRepeat().getDirection());
    }

    @Test
    @DisplayName("Teste 8: Verifica compasso 17")
    public void validaCompassoDezessete() {
        Measure compasso17 = scorePartwise.getParts().get(0).getMeasures().get(16);

        assertEquals(2, compasso17.getBarlines().size());

        Barline esquerda = compasso17.getBarlines().get(0);
        assertEquals(Location.LEFT, esquerda.getLocation());
        assertEquals("2", esquerda.getEnding().getNumber());
        assertEquals(EndingType.START, esquerda.getEnding().getType());

        Barline direita = compasso17.getBarlines().get(1);
        assertEquals(Location.RIGHT, direita.getLocation());
        assertEquals("2", direita.getEnding().getNumber());
        assertEquals(EndingType.DISCONTINUE, direita.getEnding().getType());

        Harmony harmony = compasso17.getHarmonies().get(0);
        assertEquals(RootStep.G, harmony.getRoot().getRootStep());
        assertEquals(Kind.MAJOR, harmony.getKind());

        List<Note> notes = compasso17.getNotes();
        assertEquals(3, notes.size());

        Note n1 = notes.get(0);
        assertFalse(n1.isRest());
        assertEquals(2, n1.getDuration());
        assertEquals(NoteType.QUARTER, n1.getType());
        assertEquals(Step.G, n1.getPitch().getStep());
        assertEquals(Octave.FOURTH, n1.getPitch().getOctave());

        Note n2 = notes.get(1);
        assertFalse(n2.isRest());
        assertEquals(1, n2.getDuration());
        assertEquals(NoteType.EIGHTH, n2.getType());
        assertEquals(Step.F, n2.getPitch().getStep());
        assertEquals(Octave.FIFTH, n2.getPitch().getOctave());

        Note n3 = notes.get(2);
        assertFalse(n3.isRest());
        assertEquals(1, n3.getDuration());
        assertEquals(NoteType.EIGHTH, n3.getType());
        assertEquals(Step.D, n3.getPitch().getStep());
        assertEquals(Octave.FIFTH, n3.getPitch().getOctave());
    }

    @Test
    @DisplayName("Teste 9: Verifica compasso 26")
    public void validaCompassoVinteSeis() {
        Measure compasso26 = scorePartwise.getParts().get(0).getMeasures().get(25);

        assertNull(compasso26.getAttributes());

        assertTrue(compasso26.getHarmonies().isEmpty());

        Barline barline = compasso26.getBarlines().get(0);
        assertEquals(Location.RIGHT, barline.getLocation());
        assertNull(barline.getEnding());
        assertNull(barline.getRepeat());

        List<Note> notes = compasso26.getNotes();
        assertEquals(1, notes.size());
        Note note = notes.get(0);
        assertTrue(note.isRest());
        assertEquals(4, note.getDuration());
        assertEquals(NoteType.HALF, note.getType());
    }

    @Test
    @DisplayName("Teste 10: Verifica transcrição do título para Braille")
    public void validaTranscricaoTituloBraille() throws CompilationException, TranslationException, DisplayException {
        String titulo = scorePartwise.getCredits().get(0).getCreditWords();

        assertEquals("⠨⠁⠎⠁⠀⠃⠗⠁⠝⠉⠁", TranscritorTextoBraille.textoParaBraille(titulo));
    }

    @Test
    @DisplayName("Teste 11: Verifica transcrição do compasso para Braille (2/4)")
    public void validaTranscricaoTimeSignatureBraille() throws CompilationException, TranslationException, DisplayException {
        Time time = scorePartwise.getParts().get(0).getMeasures().get(0).getAttributes().getTime();

        assertEquals("⠼⠃⠲", time.toBraille());
        assertEquals("2/4", time.toString());
    }

    @Test
    @DisplayName("Teste 12: Verifica clave da partitura (sol) em Unicode e Braille")
    public void validaClaveSol() {
        Clef clef = scorePartwise.getParts().get(0).getMeasures().get(0).getAttributes().getClef();

        assertEquals(Sign.G, clef.getSign());
        assertEquals("𝄞", clef.getSign().toString());
        assertEquals("⠜⠌⠇", clef.getSign().toBraille());
    }

    @Test
    @DisplayName("Teste 13: Verifica enum Octave (FIRST a SEVENTH)")
    public void validaOctave() {
        assertEquals(7, Octave.values().length);
        assertEquals(Octave.FIRST, Octave.valueOf("FIRST"));
        assertEquals(Octave.SECOND, Octave.valueOf("SECOND"));
        assertEquals(Octave.THIRD, Octave.valueOf("THIRD"));
        assertEquals(Octave.FOURTH, Octave.valueOf("FOURTH"));
        assertEquals(Octave.FIFTH, Octave.valueOf("FIFTH"));
        assertEquals(Octave.SIXTH, Octave.valueOf("SIXTH"));
        assertEquals(Octave.SEVENTH, Octave.valueOf("SEVENTH"));

        assertEquals("1", Octave.FIRST.toString());
        assertEquals("2", Octave.SECOND.toString());
        assertEquals("3", Octave.THIRD.toString());
        assertEquals("4", Octave.FOURTH.toString());
        assertEquals("5", Octave.FIFTH.toString());
        assertEquals("6", Octave.SIXTH.toString());
        assertEquals("7", Octave.SEVENTH.toString());

        assertEquals("⠈", Octave.FIRST.toBraille());
        assertEquals("⠘", Octave.SECOND.toBraille());
        assertEquals("⠸", Octave.THIRD.toBraille());
        assertEquals("⠐", Octave.FOURTH.toBraille());
        assertEquals("⠨", Octave.FIFTH.toBraille());
        assertEquals("⠰", Octave.SIXTH.toBraille());
        assertEquals("⠠", Octave.SEVENTH.toBraille());
    }
}
