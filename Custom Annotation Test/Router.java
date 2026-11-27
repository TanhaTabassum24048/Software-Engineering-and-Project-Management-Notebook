import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

public class Router {
    public static String dispatch(Container container, String path) {
        for (Map.Entry<String, Object> entry : container.getBeans().entrySet()) {
            Object bean = entry.getValue();
            for (Method method : bean.getClass().getDeclaredMethods()) {
                Route route = method.getAnnotation(Route.class);
                if (route != null && route.path().equals(path)) {
                    try {
                        method.setAccessible(true);
                        Object result = method.invoke(bean);
                        return (String) result;
                    } catch (IllegalAccessException e) {
                        throw new IllegalStateException(
                                "Could not access route method " + method.getName(), e);
                    } catch (InvocationTargetException e) {
                        throw new IllegalStateException(
                                "Route method failed: " + method.getName(), e.getCause());
                    }
                }
            }
        }
        return "404 Not Found: " + path;
    }
}
