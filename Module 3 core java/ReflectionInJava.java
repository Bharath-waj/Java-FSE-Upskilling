import java.lang.reflect.Method;
class Sample {
    public void sayHello(String name) {
        System.out.println("Hello, " + name);
    }
}

public class ReflectionInJava {
    public static void main(String[] args) throws Exception {
        Class<?> cls = Class.forName("Sample");
        Object obj = cls.getDeclaredConstructor().newInstance();
        Method[] methods = cls.getDeclaredMethods();
        for (Method m : methods) {
            System.out.println("Method: " + m.getName());
        }
        Method sayHello = cls.getDeclaredMethod("sayHello", String.class);
        sayHello.invoke(obj, "Java");
    }
}
