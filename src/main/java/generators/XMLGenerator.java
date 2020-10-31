package generators;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class XMLGenerator {

    public static void main(String[] args) throws TransformerException, ParserConfigurationException {
        generateXML();
    }

    public static void generateXML() throws ParserConfigurationException, TransformerException {

        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

        Document doc = docBuilder.newDocument();
        Element rootElement = doc.createElement("container");
        doc.appendChild(rootElement);

        Element data = doc.createElement("dataFromContainer");
        rootElement.appendChild(data);

        data.setAttribute("time", "2020-10-29T11:30:30.634Z");

        Element user = doc.createElement("userId");
        user.appendChild(doc.createTextNode("2"));
        data.appendChild(user);

        Element weight = doc.createElement("weight");
        weight.appendChild(doc.createTextNode("100"));
        data.appendChild(weight);

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File("dataFromContainer.xml"));

        transformer.transform(source, result);
    }
}
