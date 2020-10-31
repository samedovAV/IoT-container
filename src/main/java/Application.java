import generators.HTMLGenerator;
import generators.JSONGenerator;
import generators.XMLGenerator;
import org.xml.sax.SAXException;
import parsers.HTMLParser;
import parsers.JSONParserIoT;
import parsers.XMLParser;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;

public class Application {
    public static void main(String[] args) throws TransformerException, ParserConfigurationException, IOException, SAXException {
        JSONGenerator.generateJSON();
        XMLGenerator.generateXML();
        HTMLGenerator.generateHTML();

        JSONParserIoT.parseJSON();
        XMLParser.parseXML();
        HTMLParser.parseHTML();
    }
}
