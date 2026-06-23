package br.com.braille.service;

import br.com.braille.xml.score.ScorePartwise;
import org.xml.sax.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.sax.SAXSource;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Desempacotador {
    File arquivoXML;

    public Desempacotador(String pathArquivo) {
        this.arquivoXML = new File(pathArquivo);
    }

    public ScorePartwise carregarPartitura() {
        try {
            // Classe alvo
            JAXBContext contexto = JAXBContext.newInstance(ScorePartwise.class);

            // Criamos o objeto desempacotador
            Unmarshaller unmarshaller = contexto.createUnmarshaller();

            // Burocracias para ignorar o DTD (método que define a estrutura e os elementos permitidos)
            SAXParserFactory spf = SAXParserFactory.newInstance();
            spf.setValidating(false);
            spf.setFeature("http://xml.org/sax/features/validation", false);
            spf.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
            XMLReader xmlReader = spf.newSAXParser().getXMLReader();
            InputSource inputSource = new InputSource(new FileReader(arquivoXML));
            SAXSource source = new SAXSource(xmlReader, inputSource);

            // Aqui acontece a desserialização
            return (ScorePartwise) unmarshaller.unmarshal(source);

        // Tratamento de erro
        } catch (JAXBException | SAXException | ParserConfigurationException | FileNotFoundException e) {
            throw new RuntimeException("Erro ao carregar a partitura: " + e.getMessage(), e);
        }
    }
}
