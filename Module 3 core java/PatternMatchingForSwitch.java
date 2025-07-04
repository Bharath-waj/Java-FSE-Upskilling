public class PatternMatchingForSwitch {
    public static void handleObject(Object obj) {
        if (obj instanceof Integer) {
            Integer i = (Integer) obj;
            System.out.println("Integer: " + i);
        } else if (obj instanceof String) {
            String s = (String) obj;
            System.out.println("String: " + s);
        } else if (obj instanceof Double) {
            Double d = (Double) obj;
            System.out.println("Double: " + d);
        } else if (obj == null) {
            System.out.println("Null object");
        } else {
            System.out.println("Unknown type: " + obj.getClass().getName());
        }
    }
    public static void main(String[] args) {
        handleObject("Hello");
        handleObject(123);
        handleObject(45.67);
        handleObject(null);
    }
}
