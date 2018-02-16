package game;

import game.gameobject.GameObject;
import game.metric.Vector;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class GameObjectIdentifier {

    private String classPath;
    private List<Class> parameter;

    public GameObjectIdentifier(String classPath, List<Class> parameter) {
        this.classPath = classPath;
        this.parameter = parameter;
    }


    public GameObject create(List<Object> parameter) {

        GameObject gameObject = null;
        Vector position = (Vector) parameter.get(0);
        try {
            gameObject = (GameObject) Class.forName(this.classPath).getConstructor(Vector.class).newInstance(position);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return gameObject;
    }

}
