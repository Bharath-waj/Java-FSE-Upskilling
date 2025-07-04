public class MethodOverloading {
    // Method 1: Adds two integers
    public int add(int a, int b) {
        return a + b;
    }
    // Method 2: Adds two doubles
    public double add(double a, double b) {
        return a + b;
    }
    // Method 3: Adds three integers
    public int add(int a, int b, int c) {
        return a + b + c;
    }
    public static void main(String[] args) {
        MethodOverloading obj = new MethodOverloading();
        int sum1 = obj.add(10, 20);    // Adding two integers             
        double sum2 = obj.add(5.5, 4.5);        // Adding two doubles     
        int sum3 = obj.add(1, 2, 3);      // Adding three integers          
        System.out.println("Sum of 10 and 20: " + sum1);
        System.out.println("Sum of 5.5 and 4.5: " + sum2);
        System.out.println("Sum of 1, 2, and 3: " + sum3);
    }
}
