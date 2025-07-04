public class OperatorPrecedence {
    public static void main(String[] args) {
        int result1 = 10 + 5 * 2;
        int result2 = (10 + 5) * 2;
        int result3 = 100 / 10 + 5 * 3 - 2;
        System.out.println("Result1 (10 + 5 * 2): " + result1);  // 10 + (5*2) = 20
        // Note: The multiplication operator (*) has higher precedence than the addition operator (+)
        System.out.println("Result2 ((10 + 5) * 2): " + result2); // (10+5)*2 = 30
        // Note: Parentheses change the order of operations, so addition is performed before multiplication
        System.out.println("Result3 (100 / 10 + 5 * 3 - 2): " + result3); // (100/10) + (5*3) - 2 = 10 + 15 - 2 = 23
        // In this expression, division and multiplication are performed before addition and subtraction,
        // following the order of operations (PEMDAS/BODMAS)
    }
}
