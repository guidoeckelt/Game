package de.charaktar.game.filesystem;

import de.charaktar.game.Scene;
import de.charaktar.game.gameobject.GameObject;
import de.charaktar.game.gameobject.GameObjectFactory;
import de.charaktar.game.graphic.image.ImageContainer;
import de.charaktar.game.metric.Dimension;
import de.charaktar.game.metric.Vector;
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

public class SceneReader {

    private String rootPath;
    private ImageContainer imageContainer;
    private Hashtable<String, GameObjectFactory> gameObjectDictionary;

    public SceneReader(String rootPath, Hashtable<String, GameObjectFactory> gameObjectDictionary, ImageContainer imageContainer) {
        this.rootPath = rootPath;
        this.gameObjectDictionary = gameObjectDictionary;
        this.imageContainer = imageContainer;
    }

    public Scene read(String name) {

        File file = new File(this.rootPath + "PointyAndClicky\\media\\scenes\\" + name + ".gscene");
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        Scene scene = null;
        try {
            Document document = documentBuilderFactory.newDocumentBuilder().parse(file);
            return this.readScene(document, this.imageContainer);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        return scene;
    }

    private Scene readScene(Document document, ImageContainer imageContainer) {

        Node sizeNode = document.getElementsByTagName("Size").item(0);
        int width = Integer.decode(sizeNode.getAttributes().getNamedItem("width").getTextContent());
        int height = Integer.decode(sizeNode.getAttributes().getNamedItem("height").getTextContent());
        Dimension size = new Dimension(width, height);

        NodeList gameObjectNodeList = document.getElementsByTagName("GameObject");
        List<GameObject> sceneGameObjects = new ArrayList<>();
        for (int gameObjectIndex = 0; gameObjectIndex < gameObjectNodeList.getLength(); gameObjectIndex++) {
            Node gameObjectNode = gameObjectNodeList.item(gameObjectIndex);
            String key = gameObjectNode.getAttributes().getNamedItem("key").getTextContent();
            GameObjectFactory gameObjectFactory = this.gameObjectDictionary.get(key);
            List<Object> parameters = new ArrayList<>();
            NodeList gameObjectChildNodes = gameObjectNode.getChildNodes();
            Node parameterNode = gameObjectChildNodes.item(1);
            NodeList parameterChildNodes = parameterNode.getChildNodes();
            for (int parameterIndex = 0; parameterIndex < parameterChildNodes.getLength(); parameterIndex++) {
                Node parameterChildNode = parameterChildNodes.item(parameterIndex);
                String parameterChildNodeName = parameterChildNode.getNodeName();
                if (parameterChildNodeName.equals("Vector")) {
                    double x = Double.valueOf(parameterChildNode.getAttributes().getNamedItem("x").getTextContent());
                    double y = Double.valueOf(parameterChildNode.getAttributes().getNamedItem("y").getTextContent());
                    Vector vector = new Vector(x, y);
                    parameters.add(vector);
                }
//                if (gameObjectFactory.needs(parameterChildNodeName)) {
//                    Class parameterClass = gameObjectFactory.getParamterClass(parameterChildNodeName);
////                    System.out.println("parameterClassName :" + parameterClass.getSimpleName());
//                    Constructor parameterConstructor = null;
//                    for (Constructor constructor : parameterClass.getConstructors()) {
//                        if (constructor.getParameterCount() == parameterChildNode.getAttributes().getLength()) {
//                            parameterConstructor = constructor;
//                            break;
//                        }
//                    }
//                    List<Object> parameters2 = new ArrayList<>();
//                    for (int i = 0; i < parameterChildNode.getAttributes().getLength(); i++) {
//                        Node pNode = parameterChildNode.getAttributes().item(i);
//                        Object temp = Double.valueOf(pNode.getTextContent());
//                        parameters2.add(temp);
//                    }
//                    try {
//                        Object parameter = parameterConstructor.newInstance(parameters2);
//                        parameters.add(parameter);
//                    } catch (InstantiationException e) {
//                        e.printStackTrace();
//                    } catch (IllegalAccessException e) {
//                        e.printStackTrace();
//                    } catch (InvocationTargetException e) {
//                        e.printStackTrace();
//                    }
//                }
            }
            GameObject gameObject = gameObjectFactory.create(parameters);
            gameObject.createGraphics(imageContainer);
            sceneGameObjects.add(gameObject);
        }
        return new Scene(imageContainer, size, sceneGameObjects);
    }

}
