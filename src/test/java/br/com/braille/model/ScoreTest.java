package br.com.braille.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ScoreTest {
    private String testFilePath;

    @BeforeEach
    public void setUp() {
        this.testFilePath = "src/test/resources/Asa-Branca.musicxml";
    }

    @Test
    @DisplayName("Verifica título")
    void testIfGetTitleIsWorkingInContructor() {
        Score score = new Score(testFilePath);

        assertEquals("Asa branca", score.getTitle());
    }

    @Test
    @DisplayName("Verifica leitura dos compassos")
    public void testExtractMeasures() {
        Score score = new Score(testFilePath);
        List<String> expectedMeasureNumbers = new ArrayList<>();

        List<Measure> measures = score.getMeasures();

        assertNotNull(measures);
        assertEquals(26, measures.size());

        // Cria list com número de 1 a 26
        for (int i = 1; i < 27; i++) {
            expectedMeasureNumbers.add(String.valueOf(i));
        }

        // Compara essa lista com os compassos salvos em measures.
        for (int i = 0; i < 26; i++) {
            assertEquals(expectedMeasureNumbers.get(i), measures.get(i).getNumber());
        }
    }

    @Test
    @DisplayName("Verifica atribuição de divisões")
    public void testExtractDivisions() {
        Score score = new Score(testFilePath);
        List<Measure> measures = score.getMeasures();

        assertNotNull(measures);

        // Verifica se a divisão de cada um dos compassos é 2
        for (int i = 0; i < 25; i++) {
            assertEquals(2, measures.get(i).getDivisions());
        }
    }
}