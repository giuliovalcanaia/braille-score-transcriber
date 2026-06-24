package br.com.braille.application;

import br.com.braille.xml.Score;
import br.com.braille.xml.score.scorepartwise.Part;
import br.com.braille.xml.score.scorepartwise.part.Measure;
import br.com.braille.xml.score.scorepartwise.part.measure.Note;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrdenadorDeNotas {

    public List<String> ordenarNomesDasNotas(Score score) {
        List<Note> notas = new ArrayList<>();

        for (Part part : score.getScorePartwise().getParts()) {
            for (Measure compasso : part.getMeasures()) {
                for (Note nota : compasso.getNotes()) {
                    if (!nota.isRest()) {
                        notas.add(nota);
                    }
                }
            }
        }

        Collections.sort(notas);

        List<String> nomes = new ArrayList<>();
        for (Note nota : notas) {
            nomes.add(nota.toString());
        }

        return nomes;
    }
}
