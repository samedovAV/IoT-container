package parsers;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class XMLParser {

    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {
        parseXML();
    }

    public static void parseXML() throws ParserConfigurationException, IOException, SAXException {
        File inputFile = new File("dataFromContainer.xml");

        FileWriter outputFile = new FileWriter("dataFromContainer(XML).txt");

        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
        Document doc = docBuilder.parse(inputFile);
        doc.getDocumentElement().normalize();

        outputFile.write("Root element: " + doc.getDocumentElement().getNodeName());

        NodeList nodeList = doc.getElementsByTagName("dataFromContainer");
        for(int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            outputFile.write("\nCurrent element: " + node.getNodeName());

            if(node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                outputFile.write("\nTime: " + element.getAttribute("time"));

                outputFile.write("\nUser id: " +
                        element.getElementsByTagName("userId").item(0).getTextContent());
                outputFile.write("\nWeight: " +
                        element.getElementsByTagName("weight").item(0).getTextContent());
            }
        }
        outputFile.flush();
    }

}
