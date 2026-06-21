package br.com.braille.service;

import org.liblouis.*;
import org.liblouis.DisplayTable.StandardDisplayTables;

public class TranscritorTextoBraille{
    public static void main(String[] args) throws CompilationException, TranslationException, DisplayException {
        System.out.println("Iniciando o teste com liblouis-java...\n");

        // PASSO 1: O verdadeiro Hello World (Testar a ponte JNA)
        // Isso só vai funcionar se a biblioteca nativa do liblouis estiver instalada no sistema.
        String version = Louis.getVersion();
        System.out.println("✅ Sucesso! Versão do liblouis nativo encontrada: " + version);

        // PASSO 2: Exemplo de Tradução
        // Nota: Para isso funcionar, o arquivo de tabela "en-us-g1.utb" (Braille não contraído em inglês)
        // precisa existir nos diretórios de tabelas do seu sistema.
        System.out.println("\nTentando traduzir 'Hello World'...");

        Translator translator = new Translator("pt-pt-g1.utb");
        TranslationResult resultado = translator.translate("Asa Branca", null, null, null, StandardDisplayTables.UNICODE);
        String braille = resultado.getBraille();

        System.out.println("Resultado em Braille: " + braille);

    }
}