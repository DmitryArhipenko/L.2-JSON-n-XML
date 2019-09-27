import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Parser {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse("https://api.privatbank.ua/p24api/pubinfo?exchange&coursid=3");

        Element root = document.getDocumentElement();
        System.out.println("Root element: " + root.getNodeName());

        NodeList nodeListRoow = root.getChildNodes();

        for (int i = 0; i < nodeListRoow.getLength(); i++){
            Node node = nodeListRoow.item(i);

            if (node.getNodeType() == Node.ELEMENT_NODE){
                Element exchangerate = (Element) node;
                NamedNodeMap exchangerateAttributs = exchangerate.getChildNodes().item(0).getAttributes();

                for (int j = 0; j < exchangerateAttributs.getLength(); j++) {
                    System.out.print(exchangerate.getChildNodes().item(0).getAttributes().item(j) + " ");
                }
                System.out.println();
            }
        }
    }
}