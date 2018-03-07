package de.charaktar.ge.filesystem;

import de.charaktar.ge.gameobject.GameObjectFactory;
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

public class GameObjectFactoryDictionaryReader {

    private String rootPath;

    public GameObjectFactoryDictionaryReader(String rootPath) {
        this.rootPath = rootPath;
    }

    public Hashtable<String, GameObjectFactory> read() {

        File file = new File(this.rootPath + "PointyAndClicky\\media\\GameObjectDictionary.xml");
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        Hashtable<String, GameObjectFactory> gameObjectList = new Hashtable<>();
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

    private Hashtable<String, GameObjectFactory> readList(Document document) {

        NodeList list = document.getElementsByTagName("GameObject");
        Hashtable<String, GameObjectFactory> gameObjectList = new Hashtable<>();
        for (int factoryIndex = 0; factoryIndex < list.getLength(); factoryIndex++) {
            Node factoryNode = list.item(factoryIndex);
            String key = factoryNode.getAttributes().getNamedItem("key").getTextContent();
            String classP = factoryNode.getAttributes().getNamedItem("classPath").getTextContent();
            List<Class> parameterClassList = new ArrayList<>();

            NodeList factoryChildNodes = factoryNode.getChildNodes();
            Node parameterClassNode = factoryChildNodes.item(1);
//            System.out.println("parameterClassNodeName :" + parameterClassNode.getNodeName());
            NodeList parameterClassChildNodes = parameterClassNode.getChildNodes();
//            System.out.println("parameterClassChildNodeslength :" + parameterClassChildNodes.getLength());
            for (int parameterClassIndex = 0; parameterClassIndex < parameterClassChildNodes.getLength(); parameterClassIndex++) {
                Node parameterClassChildNode = parameterClassChildNodes.item(parameterClassIndex);
                if (parameterClassChildNode.hasAttributes()) {
                    String parameterClassName = parameterClassChildNode.getNodeName();
                    String parameterClassPath = parameterClassChildNode.getAttributes().getNamedItem("classPath").getTextContent();
//                    System.out.println("parameterClassName :" + parameterClassName);
                    String cl = parameterClassPath + "." + parameterClassName;
//                    System.out.println("classPath :" + cl);
                    try {
                        Class parameterClass = Class.forName(cl);
                        parameterClassList.add(parameterClass);
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
//            System.out.println("parameterClassList :" + parameterClassList);
            GameObjectFactory identifier = new GameObjectFactory(classP, parameterClassList);
            gameObjectList.put(key, identifier);
        }
        return gameObjectList;
    }
}
