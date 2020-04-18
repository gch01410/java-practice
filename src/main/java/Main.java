import Calculator.Calculator;

public class Main {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        System.out.println(calculator.add(2, 3));
        System.out.println(calculator.subtract(4, 1));
        System.out.println(calculator.multiply(2, 2));
        System.out.println(calculator.divide(8, 4));
    }
}
