package task_1;

public class exep {
    public static void main(String[] args) {
        try {
            int[] intArray = {10, 20, 30};
            int d = 2; // Значение делителя не равно нулю
            double catchedRes1 = intArray[8] / d;
            System.out.println("catchedRes1 = " + catchedRes1);
        } catch (ArithmeticException e) {
            System.out.println("Catching exception: " + e);
        }
    }
}
