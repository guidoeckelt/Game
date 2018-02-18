package game.filesystem;

import game.GameObjectIdentifier;
import game.Scene;
import game.gameobject.GameObject;
import game.graphic.image.ImageContainer;
import game.metric.Dimension;
import game.metric.Vector;
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
    private Hashtable<String, GameObjectIdentifier> gameObjectDictionary;

    public SceneReader(String rootPath, Hashtable<String, GameObjectIdentifier> gameObjectDictionary, ImageContainer imageContainer) {
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
        List<GameObject> gameObjects = new ArrayList<>();
        Scene scene = null;
        for (int i = 0; i < gameObjectNodeList.getLength(); i++) {
            Node gameObjectNode = gameObjectNodeList.item(i);
            String key = gameObjectNode.getAttributes().getNamedItem("key").getTextContent();
            GameObjectIdentifier identifier = this.gameObjectDictionary.get(key);
            List<Object> parameters = new ArrayList<>();
            NodeList gameObjectNodeChildren = gameObjectNode.getChildNodes();
            Node parameterRootNode = gameObjectNodeChildren.item(1);
            NodeList parameterNodeList = parameterRootNode.getChildNodes();
            for (int ii = 0; ii < parameterNodeList.getLength(); ii++) {
                Node parameterNode = parameterNodeList.item(ii);
                if (parameterNode.getNodeName().equals("Vector")) {
                    double x = Double.valueOf(parameterNode.getAttributes().getNamedItem("x").getTextContent());
                    double y = Double.valueOf(parameterNode.getAttributes().getNamedItem("y").getTextContent());
                    Vector vector = new Vector(x, y);
                    parameters.add(vector);
                }
            }
            GameObject gameObject = identifier.create(parameters);
            gameObject.createGraphics(imageContainer);
            gameObjects.add(gameObject);
        }
        scene = new Scene(imageContainer, size, gameObjects);
        return scene;

    }

}
