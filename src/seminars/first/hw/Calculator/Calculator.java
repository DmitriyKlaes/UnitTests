package seminars.first.hw.Calculator;

import java.util.Scanner;

public class Calculator {
    private static final Scanner scanner = new Scanner(System.in);

    public static char getOperator() {
        System.out.println("Enter operation: ");
        char operation = scanner.next().charAt(0);
        return operation;
    }

    public static int getOperand() {
        System.out.println("Enter operand: ");
        int operand;
        if (scanner.hasNextInt()) {
            operand = scanner.nextInt();
        } else {
            System.out.println("You have mistaken, try again");
            if (scanner.hasNext()) {
                scanner.next();
                operand = getOperand();
            } else {
                throw new IllegalStateException("Input error");
            }
        }
        return operand;
    }
    public static int calculation(int firstOperand, int secondOperand, char operator) {
        int result;

        switch (operator) {
            case '+':
                result = firstOperand + secondOperand;
                break;
            case '-':
                result = firstOperand - secondOperand;
                break;
            case '*':
                result = firstOperand * secondOperand;
                break;
            case '/':
                if (secondOperand != 0) {
                    result = firstOperand / secondOperand;
                    break;
                } else {
                    throw new ArithmeticException("Division by zero is not possible");
                }
            default:
                throw new IllegalStateException("Unexpected value operator: " + operator);
        }
        return result;
    }

    // HW1.1: Придумайте и опишите (можно в псевдокоде) функцию извлечения корня и
    // необходимые проверки для него используя граничные случаи
    public static double squareRootExtraction(double num) {
        //  0
        //  Отрицательные числа
        //  Дробные значения корней
        //  Целые
            if(num < 0) {
                throw new IllegalArgumentException("Cannot calculate square root of a negative number");
            }
            return Math.sqrt(num);
    }

    // Нужно написать в калькуляторе метод вычисления суммы покупки со скидкой и проверить его, используя AssertJ
    // Примерная сигнатура и тело метода:
    public static double calculatingDiscount(double purchaseAmount, int discountAmount) {

        if (purchaseAmount < 0 || discountAmount < 0 || discountAmount >= 100) {
            throw new ArithmeticException("Недопустимые аргументы метода");
        }
        return purchaseAmount - purchaseAmount * discountAmount / 100;

    }

    public static int pow(int value, int powValue) {
        int result = 1;

        for (int a = 1; a <= powValue; a++) {
            if (a == 0) return 1;
            result = result * value;

        }
        return result;
    }

    //HW3.1L: Попробуйте реализовать в калькуляторе с
    // помощью методологии TDD (с описанием шагов)
    // функцию расчета длины окружности
    // P=2πR
    public final static String errorMessage = "radius must be great than 0";

    public double computeAreaCircle(double radius) {
        if( radius < 0) {
            throw new IllegalArgumentException(errorMessage);
        }
        return Math.PI * radius * radius;
    }

    public double computeLengthCircle(double radius) {
        if( radius < 0) {
            throw new IllegalArgumentException(errorMessage);
        }
        return 2 * Math.PI * radius;
    }
}
