package game.gameobject;

import game.metric.Vector;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class GameObjectFactory {

    private String classPath;
    private List<Class> parameterClasses;

    public GameObjectFactory(String classPath, List<Class> parameterClasses) {

        this.classPath = classPath;
        this.parameterClasses = parameterClasses;
    }


    public boolean needs(String parameterClassName) {

        return this.parameterClasses.stream().anyMatch(c -> c.getSimpleName().equals(parameterClassName));
    }

    public Class getParamterClass(String parameterChildNodeName) {
        Class pC = null;
        for (Class c : this.parameterClasses) {
            if (c.getSimpleName().equals(parameterChildNodeName)) {
                pC = c;
                break;
            }
        }
        return pC;
    }

    public GameObject create(List<Object> parameter) {

        GameObject gameObject = null;
        Vector position = (Vector) parameter.get(0);
        try {
            gameObject = (GameObject) Class.forName(this.classPath).getConstructor(Vector.class).newInstance(position);
//            gameObject = (GameObject) Class.forName(this.classPath).getConstructor(this.parameterClasses).newInstance(parameter);
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
