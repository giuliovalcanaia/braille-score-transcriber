package br.com.braille.service;

import br.com.braille.xml.Score;
import br.com.braille.xml.score.ScorePartwise;
import br.com.braille.xml.score.scorepartwise.part.measure.Note;
import br.com.braille.xml.score.scorepartwise.part.measure.attributes.Clef;
import br.com.braille.xml.score.scorepartwise.part.measure.attributes.Time;
import br.com.braille.xml.score.scorepartwise.part.measure.attributes.clef.Sign;
import br.com.braille.xml.score.scorepartwise.part.measure.note.NoteType;
import br.com.braille.xml.score.scorepartwise.part.measure.note.pitch.Octave;
import br.com.braille.xml.score.scorepartwise.part.measure.note.pitch.Step;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TranscreverParaBrailleTest {
    private String testFilePath;
    private Desempacotador desempacotador;
    private Score score;

    @BeforeEach
    public void setUp() {
        this.testFilePath = "src/test/resources/Asa-Branca.musicxml";
        score = new Score(testFilePath);
    }

    @Test
    @DisplayName("Teste 1: Transcrição caractere `a` para português")
    public void validaCaracteresimples() {
        assertEquals("⠁", TranscreverParaBraille.textoParaBraille("a"));
    }


    @Test
    @DisplayName("Teste 2: Verifica transcrição do título para Braille")
    public void validaTranscricaoTituloBraille() {
        String titulo = score.getScorePartwise().getCredits().get(0).getCreditWords();

        assertEquals("⠨⠁⠎⠁⠀⠃⠗⠁⠝⠉⠁", TranscreverParaBraille.textoParaBraille(titulo));
    }

    @Test
    @DisplayName("Teste 3: Verifica transcrição do compasso para Braille (2/4)")
    public void validaTranscricaoTimeSignatureBraille() {
        Time time = score.getScorePartwise().getParts().get(0).getMeasures().get(0).getAttributes().getTime();

        assertEquals("⠼⠃⠲", time.toBraille());
        assertEquals("2/4", time.toString());
    }

    @Test
    @DisplayName("Teste 4: Verifica clave da score (sol) em Unicode e Braille")
    public void validaClaveSol() {
        Clef clef = score.getScorePartwise().getParts().get(0).getMeasures().get(0).getAttributes().getClef();

        assertEquals(Sign.G, clef.getSign());
        assertEquals("𝄞", clef.getSign().toString());
        assertEquals("⠜⠌⠇", clef.toBraille());
    }

    @Test
    @DisplayName("Teste 5: Verifica enum Octave")
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

    @Test
    @DisplayName("Teste 6: Verifica transcrição de notas para braille")
    public void validaNotasBraille() {
        // Wholes, 16ths (Semibreves / Semicolcheias)
        assertEquals("⠽", TranscreverParaBraille.notasParaBraille(NoteType.WHOLE, Step.C));
        assertEquals("⠵", TranscreverParaBraille.notasParaBraille(NoteType.WHOLE, Step.D));
        assertEquals("⠯", TranscreverParaBraille.notasParaBraille(NoteType.WHOLE, Step.E));
        assertEquals("⠿", TranscreverParaBraille.notasParaBraille(NoteType.WHOLE, Step.F));
        assertEquals("⠷", TranscreverParaBraille.notasParaBraille(NoteType.WHOLE, Step.G));
        assertEquals("⠮", TranscreverParaBraille.notasParaBraille(NoteType.WHOLE, Step.A));
        assertEquals("⠾", TranscreverParaBraille.notasParaBraille(NoteType.WHOLE, Step.B));
        assertEquals("⠽", TranscreverParaBraille.notasParaBraille(NoteType.SIXTEENTH, Step.C));
        assertEquals("⠵", TranscreverParaBraille.notasParaBraille(NoteType.SIXTEENTH, Step.D));
        assertEquals("⠯", TranscreverParaBraille.notasParaBraille(NoteType.SIXTEENTH, Step.E));
        assertEquals("⠿", TranscreverParaBraille.notasParaBraille(NoteType.SIXTEENTH, Step.F));
        assertEquals("⠷", TranscreverParaBraille.notasParaBraille(NoteType.SIXTEENTH, Step.G));
        assertEquals("⠮", TranscreverParaBraille.notasParaBraille(NoteType.SIXTEENTH, Step.A));
        assertEquals("⠾", TranscreverParaBraille.notasParaBraille(NoteType.SIXTEENTH, Step.B));

        // Halves, 32nds (Mínimas / Fusas)
        assertEquals("⠝", TranscreverParaBraille.notasParaBraille(NoteType.HALF, Step.C));
        assertEquals("⠕", TranscreverParaBraille.notasParaBraille(NoteType.HALF, Step.D));
        assertEquals("⠏", TranscreverParaBraille.notasParaBraille(NoteType.HALF, Step.E));
        assertEquals("⠟", TranscreverParaBraille.notasParaBraille(NoteType.HALF, Step.F));
        assertEquals("⠗", TranscreverParaBraille.notasParaBraille(NoteType.HALF, Step.G));
        assertEquals("⠎", TranscreverParaBraille.notasParaBraille(NoteType.HALF, Step.A));
        assertEquals("⠞", TranscreverParaBraille.notasParaBraille(NoteType.HALF, Step.B));
        assertEquals("⠝", TranscreverParaBraille.notasParaBraille(NoteType.THIRTY_SECOND, Step.C));
        assertEquals("⠕", TranscreverParaBraille.notasParaBraille(NoteType.THIRTY_SECOND, Step.D));
        assertEquals("⠏", TranscreverParaBraille.notasParaBraille(NoteType.THIRTY_SECOND, Step.E));
        assertEquals("⠟", TranscreverParaBraille.notasParaBraille(NoteType.THIRTY_SECOND, Step.F));
        assertEquals("⠗", TranscreverParaBraille.notasParaBraille(NoteType.THIRTY_SECOND, Step.G));
        assertEquals("⠎", TranscreverParaBraille.notasParaBraille(NoteType.THIRTY_SECOND, Step.A));
        assertEquals("⠞", TranscreverParaBraille.notasParaBraille(NoteType.THIRTY_SECOND, Step.B));

        // Quarters, 64ths (Semínimas / Semifusas)
        assertEquals("⠹", TranscreverParaBraille.notasParaBraille(NoteType.QUARTER, Step.C));
        assertEquals("⠱", TranscreverParaBraille.notasParaBraille(NoteType.QUARTER, Step.D));
        assertEquals("⠫", TranscreverParaBraille.notasParaBraille(NoteType.QUARTER, Step.E));
        assertEquals("⠻", TranscreverParaBraille.notasParaBraille(NoteType.QUARTER, Step.F));
        assertEquals("⠳", TranscreverParaBraille.notasParaBraille(NoteType.QUARTER, Step.G));
        assertEquals("⠪", TranscreverParaBraille.notasParaBraille(NoteType.QUARTER, Step.A));
        assertEquals("⠺", TranscreverParaBraille.notasParaBraille(NoteType.QUARTER, Step.B));
        assertEquals("⠹", TranscreverParaBraille.notasParaBraille(NoteType.SIXTY_FOURTH, Step.C));
        assertEquals("⠱", TranscreverParaBraille.notasParaBraille(NoteType.SIXTY_FOURTH, Step.D));
        assertEquals("⠫", TranscreverParaBraille.notasParaBraille(NoteType.SIXTY_FOURTH, Step.E));
        assertEquals("⠻", TranscreverParaBraille.notasParaBraille(NoteType.SIXTY_FOURTH, Step.F));
        assertEquals("⠳", TranscreverParaBraille.notasParaBraille(NoteType.SIXTY_FOURTH, Step.G));
        assertEquals("⠪", TranscreverParaBraille.notasParaBraille(NoteType.SIXTY_FOURTH, Step.A));
        assertEquals("⠺", TranscreverParaBraille.notasParaBraille(NoteType.SIXTY_FOURTH, Step.B));

        // 8ths, 128ths (Colcheias / Quartifusas)
        assertEquals("⠙", TranscreverParaBraille.notasParaBraille(NoteType.EIGHTH, Step.C));
        assertEquals("⠑", TranscreverParaBraille.notasParaBraille(NoteType.EIGHTH, Step.D));
        assertEquals("⠋", TranscreverParaBraille.notasParaBraille(NoteType.EIGHTH, Step.E));
        assertEquals("⠛", TranscreverParaBraille.notasParaBraille(NoteType.EIGHTH, Step.F));
        assertEquals("⠓", TranscreverParaBraille.notasParaBraille(NoteType.EIGHTH, Step.G));
        assertEquals("⠊", TranscreverParaBraille.notasParaBraille(NoteType.EIGHTH, Step.A));
        assertEquals("⠚", TranscreverParaBraille.notasParaBraille(NoteType.EIGHTH, Step.B));
        assertEquals("⠙", TranscreverParaBraille.notasParaBraille(NoteType.ONE_HUNDRED_TWENTY_EIGHTH, Step.C));
        assertEquals("⠑", TranscreverParaBraille.notasParaBraille(NoteType.ONE_HUNDRED_TWENTY_EIGHTH, Step.D));
        assertEquals("⠋", TranscreverParaBraille.notasParaBraille(NoteType.ONE_HUNDRED_TWENTY_EIGHTH, Step.E));
        assertEquals("⠛", TranscreverParaBraille.notasParaBraille(NoteType.ONE_HUNDRED_TWENTY_EIGHTH, Step.F));
        assertEquals("⠓", TranscreverParaBraille.notasParaBraille(NoteType.ONE_HUNDRED_TWENTY_EIGHTH, Step.G));
        assertEquals("⠊", TranscreverParaBraille.notasParaBraille(NoteType.ONE_HUNDRED_TWENTY_EIGHTH, Step.A));
        assertEquals("⠚", TranscreverParaBraille.notasParaBraille(NoteType.ONE_HUNDRED_TWENTY_EIGHTH, Step.B));
    }

    @Test
    @DisplayName("Teste 7: Verifica transcrição de notas para string")
    public void validaNotasString() {
        Note n1  = score.getScorePartwise().getParts().get(0).getMeasures().get(0).getNotes().get(0);
        Note n2  = score.getScorePartwise().getParts().get(0).getMeasures().get(0).getNotes().get(1);
        Note n3  = score.getScorePartwise().getParts().get(0).getMeasures().get(0).getNotes().get(2);
        Note n4  = score.getScorePartwise().getParts().get(0).getMeasures().get(1).getNotes().get(0);
        Note n5  = score.getScorePartwise().getParts().get(0).getMeasures().get(1).getNotes().get(1);
        Note n6  = score.getScorePartwise().getParts().get(0).getMeasures().get(2).getNotes().get(0);
        Note n7  = score.getScorePartwise().getParts().get(0).getMeasures().get(2).getNotes().get(1);
        Note n8  = score.getScorePartwise().getParts().get(0).getMeasures().get(3).getNotes().get(0);
        Note n9  = score.getScorePartwise().getParts().get(0).getMeasures().get(3).getNotes().get(1);
        Note n10 = score.getScorePartwise().getParts().get(0).getMeasures().get(4).getNotes().get(0);

        assertEquals("Pausa semínima", n1.toString());
        assertEquals("G4 colcheia",    n2.toString());
        assertEquals("A4 colcheia",    n3.toString());
        assertEquals("B4 semínima",    n4.toString());
        assertEquals("D5 semínima",    n5.toString());
        assertEquals("D5 semínima",    n6.toString());
        assertEquals("B4 semínima",    n7.toString());
        assertEquals("C5 semínima",    n8.toString());
        assertEquals("C5 semínima",    n9.toString());
        assertEquals("Pausa semínima", n10.toString());

        assertEquals("⠧", n1.toBraille());
        assertEquals("⠓", n2.toBraille());
        assertEquals("⠊", n3.toBraille());
        assertEquals("⠺", n4.toBraille());
        assertEquals("⠱", n5.toBraille());
        assertEquals("⠱", n6.toBraille());
        assertEquals("⠺", n7.toBraille());
        assertEquals("⠹", n8.toBraille());
        assertEquals("⠹", n9.toBraille());
        assertEquals("⠧", n10.toBraille());
    }

    @Test
    @DisplayName("Teste 8: Verifica quando uma nota precisa do prefixo de oitava")
    public void validaPrecisaOitava() {
        Note n1 = score.getScorePartwise().getParts().get(0).getMeasures().get(0).getNotes().get(0);
        Note n2 = score.getScorePartwise().getParts().get(0).getMeasures().get(0).getNotes().get(1);
        Note n3 = score.getScorePartwise().getParts().get(0).getMeasures().get(0).getNotes().get(2);
        Note n4 = score.getScorePartwise().getParts().get(0).getMeasures().get(1).getNotes().get(0);
        Note n5 = score.getScorePartwise().getParts().get(0).getMeasures().get(1).getNotes().get(1);
        Note n6 = score.getScorePartwise().getParts().get(0).getMeasures().get(2).getNotes().get(0);
        Note n7 = score.getScorePartwise().getParts().get(0).getMeasures().get(2).getNotes().get(1);
        Note n8 = score.getScorePartwise().getParts().get(0).getMeasures().get(3).getNotes().get(0);
        Note n9 = score.getScorePartwise().getParts().get(0).getMeasures().get(3).getNotes().get(1);
        Note n10 = score.getScorePartwise().getParts().get(0).getMeasures().get(4).getNotes().get(0);

        assertFalse(n1.isOctaveMarkRequired());
        assertTrue(n2.isOctaveMarkRequired());
        assertFalse(n3.isOctaveMarkRequired());
        assertFalse(n4.isOctaveMarkRequired());
        assertFalse(n5.isOctaveMarkRequired());
        assertFalse(n6.isOctaveMarkRequired());
        assertFalse(n7.isOctaveMarkRequired());
        assertFalse(n8.isOctaveMarkRequired());
        assertFalse(n9.isOctaveMarkRequired());
        assertFalse(n10.isOctaveMarkRequired());
    }
}