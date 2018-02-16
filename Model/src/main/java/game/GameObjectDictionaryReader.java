package game;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class GameObjectDictionaryReader {

    private String rootPath;

    public GameObjectDictionaryReader(String rootPath) {
        this.rootPath = rootPath;
    }

    public Hashtable<String, GameObjectIdentifier> read() {

        File file = new File(this.rootPath + "PointyAndClicky\\media\\GameObjectDictionary.xml");
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        Hashtable<String, GameObjectIdentifier> gameObjectList = new Hashtable<>();
        try {
            Document document = documentBuilderFactory.newDocumentBuilder().parse(file);
            gameObjectList.putAll(this.readList(document));
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        return gameObjectList;
    }

    private Hashtable<String, GameObjectIdentifier> readList(Document document) {

        NodeList list = document.getElementsByTagName("GameObject");
        Hashtable<String, GameObjectIdentifier> gameObjectList = new Hashtable<>();
        for (int i = 0; i < list.getLength(); i++) {
            Node node = list.item(i);
            String key = node.getAttributes().getNamedItem("key").getTextContent();
            String classP = node.getAttributes().getNamedItem("class").getTextContent();
            List<Class> parameterList = new ArrayList<>();

            NodeList temp = node.getChildNodes();
            Node parameter = temp.item(0);//.getAttributes().getNamedItem("Parameter");
            System.out.println(parameter.getTextContent());
//            System.out.println(key + "   " + classP);

            GameObjectIdentifier identifier = new GameObjectIdentifier(classP, parameterList);
            gameObjectList.put(key, identifier);
        }
        return gameObjectList;
    }
}
