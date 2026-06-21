package br.com.braille.exemplo;

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

public class Main {
    public static void main(String[] args) throws JAXBException, SAXException, ParserConfigurationException, FileNotFoundException {
        // Define arquivo
        File arquivoXml = new File("src/main/java/br/com/braille/exemplo/Asa-Branca.musicxml");

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
        InputSource inputSource = new InputSource(new FileReader(arquivoXml));
        SAXSource source = new SAXSource(xmlReader, inputSource);

        // Aqui acontece a desserialização
        ScorePartwise scorePartwise = (ScorePartwise) unmarshaller.unmarshal(source);
        System.out.println(scorePartwise.getCredits().get(0).getCreditWords());
    }
}
