package br.com.braille.xml;

import br.com.braille.models.Brailleable;
import br.com.braille.service.Desempacotador;
import br.com.braille.xml.score.ScorePartwise;
import br.com.braille.xml.score.scorepartwise.part.Measure;
import br.com.braille.xml.score.scorepartwise.part.measure.Note;
import java.util.ArrayList;
import java.util.List;

public class Score implements Brailleable {
    private String filePath;
    private Desempacotador desempacotador;
    private ScorePartwise scorePartwise;

    public Score(String filePath) {
        this.desempacotador = new Desempacotador(filePath);
        this.scorePartwise = desempacotador.carregarPartitura();
        calculaMarcacaoOitava();
    }

    public ScorePartwise getScorePartwise() {
        return scorePartwise;
    }

    @Override
    public String toBraille() {
        String string;
        List<Measure> compassos = this.getScorePartwise().getParts().get(0).getMeasures();
        boolean imprimiuClave = false;

        // Título
        string = this.getScorePartwise().getCredits().get(0).toBraille();

        // Fórmula de compasso
        string += "\n" + compassos.get(0).getAttributes().getTime().toBraille();

        // Compassos
        for (int i = 0; i < compassos.size(); i++) {
            // Imprime nova linha conforme padronizado pelo musicxml
            if (compassos.get(i).isPrint()) {
                string += "\n";
            }
            // Clave
            if (!imprimiuClave) {
                string += compassos.get(0).getAttributes().getClef().toBraille() + " ";
                imprimiuClave = true;
            }

            // Imprime as notas do compasso
            string += compassos.get(i).toBraille();

            // Imprime a separação de compassos
            string += " ";
        }
        return string;
    }

    @Override
    public String toString() {
        String string;
        List<Measure> compassos = this.getScorePartwise().getParts().get(0).getMeasures();
        boolean imprimiuClave = false;

        string = "======== Partitura com explicação =======\n";

        // Título
        String titulo = this.getScorePartwise().getCredits().get(0).getCreditWords();
        string += "Título: " + this.getScorePartwise().getCredits().get(0).toBraille() + "\n";
        string += "Título: " + titulo + "\n\n";

        // Fórmula de compasso
        string += "Fórmula de compasso: " + compassos.get(0).getAttributes().getTime().toBraille() + "\n";
        string += "Fórmula de compasso: " + compassos.get(0).getAttributes().getTime().toString() + "\n";

        // Compassos
        for (int i = 0; i < compassos.size(); i++) {
            if (compassos.get(i).isPrint()) {
                string += "\n";
            }
            if (!imprimiuClave) {
                string += "Clave: " + compassos.get(0).getAttributes().getClef().toBraille() + " \n";
                string += "Clave: " + compassos.get(0).getAttributes().getClef().toString() + " \n";
                imprimiuClave = true;
            }
            string += compassos.get(i).toString();
        }

        string += "\n=========================================";

        return string;
    }

    public void calculaMarcacaoOitava() {
        Note ultimaNota = null;
        Note ultimaNotaReal = null;

        List<Measure> compassos = this.getScorePartwise().getParts().get(0).getMeasures();
        List<Note> notas = new ArrayList<>();

        // Adiciona todas as notas em sequência
        for (Measure compasso : compassos) {
            for (Note nota : compasso.getNotes())  {
                notas.add(nota);
            }
        }

        for (Note nota : notas) {
            // Primeira nota da partitura é pausa
            if (ultimaNota == null || nota.isRest()) {
                ultimaNota = nota;
                nota.setOctaveMarkRequired(false);
                continue;
            }

            // Primeira nota válida da partitura
            if (ultimaNotaReal == null) {
                ultimaNota = nota;
                ultimaNotaReal = ultimaNota;
                nota.setOctaveMarkRequired(true);
                continue;
            }

            int posAnterior = ((ultimaNotaReal.getPitch().getOctave().getDescricao() - 1) * 7) + ultimaNotaReal.getPitch().getStep().getReferencia();
            int posAtual  = ((nota.getPitch().getOctave().getDescricao() - 1) * 7) + nota.getPitch().getStep().getReferencia();
            int intervalo  = Math.abs(posAtual - posAnterior) + 1;

            // Salva as variáveis
            ultimaNota = nota;
            ultimaNotaReal = ultimaNota;

            // (a) Segundas e terças ascendentes/descendentes não recebem marca de oitava,
            // mesmo que estejam em oitavas diferentes.
            if (intervalo == 2 || intervalo == 3) {
                nota.setOctaveMarkRequired(false);
            }

            // (b) Quartas e quintas ascendentes/descendentes recebem marca de oitava
            // somente se estiverem em oitava diferente da nota anterior.
            else if (intervalo <= 5) {
                nota.setOctaveMarkRequired(nota.getPitch().getOctave() != ultimaNotaReal.getPitch().getOctave());
            }

            // (c) Sextas, sétimas, oitavas e intervalos maiores sempre precisam
            // da sua própria marca de oitava.
            else {
                nota.setOctaveMarkRequired(true);
            }
        }

    }

}
