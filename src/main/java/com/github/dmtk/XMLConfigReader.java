package com.github.dmtk;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.apache.log4j.Logger;

public class XMLConfigReader {

    private final static Logger log = Logger.getLogger(XMLConfigReader.class);
    public static String read(String variable) {
        String result = null;
        try {

            File file = new File("Config.xml");
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(file);
            doc.getDocumentElement().normalize();
            NodeList nodeLst = doc.getElementsByTagName("configuration");

            for (int s = 0; s < nodeLst.getLength(); s++) {
                Node node = nodeLst.item(s);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    NodeList nodeList = element.getElementsByTagName(variable);
                    Element elementList = (Element) nodeList.item(0);
                    NodeList fstNm = elementList.getChildNodes();
                    result = ((Node) fstNm.item(0)).getNodeValue();
                    break;
                }

            }

        } catch (ParserConfigurationException | SAXException | IOException | DOMException ex) {
           log.error(ex);
        }
        return result;

    }
}
