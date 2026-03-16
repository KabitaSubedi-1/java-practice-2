package com.example.javastarter;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Double firstNumber = readNumber(scanner, "Enter the first number: ");
        if (firstNumber == null) {
            scanner.close();
            return;
        }

        System.out.print("Enter an operator (+, -, *, /): ");
        String operatorInput = scanner.next().trim();
        if (operatorInput.length() != 1) {
            System.out.println("Invalid operator.");
            scanner.close();
            return;
        }
        char operator = operatorInput.charAt(0);

        Double secondNumber = readNumber(scanner, "Enter the second number: ");
        if (secondNumber == null) {
            scanner.close();
            return;
        }

        double result;

        switch (operator) {
            case '+':
                result = firstNumber + secondNumber;
                break;
            case '-':
                result = firstNumber - secondNumber;
                break;
            case '*':
                result = firstNumber * secondNumber;
                break;
            case '/':
                if (secondNumber == 0) {
                    System.out.println("Cannot divide by zero.");
                    scanner.close();
                    return;
                }
                result = firstNumber / secondNumber;
                break;
            default:
                System.out.println("Invalid operator.");
                scanner.close();
                return;
        }

        System.out.println("Result: " + result);
        scanner.close();
    }

    private static Double readNumber(Scanner scanner, String prompt) {
        System.out.print(prompt);
        if (!scanner.hasNextDouble()) {
            System.out.println("Invalid number input.");
            return null;
        }
        return scanner.nextDouble();
    }
}
