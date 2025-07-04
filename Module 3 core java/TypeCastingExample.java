public class TypeCastingExample {
    public static void main(String[] args) {
        double myDouble = 9.78;
        int myInt = (int) myDouble;
        int anotherInt = 15;
        double anotherDouble = anotherInt; 
        System.out.println("Original double: " + myDouble);
        System.out.println("After casting to int: " + myInt);
        System.out.println("Original int: " + anotherInt);
        System.out.println("After casting to double: " + anotherDouble);
    }
}
