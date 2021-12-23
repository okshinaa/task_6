package ru.vsu.cs.okshina_v_a;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Locale.setDefault(Locale.ROOT);

        int n = (int) readNumber("n");
        double x = readNumOfX();
        double e = readNumber("e");

        double sumOfSequence = calculateSumOfSequence(x, n);
        double sumOfSequenceMoreThanEpsilon = calculateSumOfSequenceMoreThanEpsilon(x,e,n);
        double sumOfSequenceMoreThanPartOfEpsilon = calculateSumOfSequenceMoreThanEpsilon(x, e/10, n);
        double valueOfFunction = calculateValueOfFunction(x);

        printAnswer(sumOfSequence, sumOfSequenceMoreThanEpsilon, sumOfSequenceMoreThanPartOfEpsilon, valueOfFunction);
    }

    private static double readNumber(String text) {
        Scanner scan = new Scanner(System.in);
        System.out.printf("Введите %s: ", text);

        double enterData = scan.nextDouble();

        if (enterData <= 0 & text == "n") {
            System.out.printf("Ошибка! Значение %s должно быть больше 0\n", text);

            System.exit(0);
        }
        return enterData;
    }

    private static double readNumOfX() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите x: ");

        return scanner.nextDouble();
    }

    public static int getFactorial(int factorial) {
        if (factorial <= 1) {
            return 1;
        }
        else {
            return factorial * getFactorial(factorial-1);
        }
    }

    private static double getMemberOfSequence(double x, int n) {
        return (Math.pow(x, 2 * n - 2)) / getFactorial(2 * n - 2);
    }

    private static double calculateSumOfSequence(double x, int n) {
        double sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += getMemberOfSequence(x, i);
        }
        return sum;
    }

    private static double calculateSumOfSequenceMoreThanEpsilon(double x, double e, int n) {
        double sum = 0;

        for (int i = 1; i <= n; i++) {
            double MemberOfSequence = getMemberOfSequence(x, i);
            if (MemberOfSequence > e) {
                sum += MemberOfSequence;
            }
        }
        if (sum == 0) {
            System.out.println("Не нашлось члена последовательности большего по значению 'e'");
        }
        return sum;
    }

    private static double calculateValueOfFunction(double x) {
        return Math.cosh(x);
    }

    private static void printAnswer(double a, double b, double c, double d) {
        System.out.println("1)Сумма членов последовательности = " + a);
        System.out.println("2)Сумма членов последовательности больших e по значению = " + b);
        System.out.println("3)Сумма членов последовательности больших e/10 по значению = " + c);
        System.out.println("4)Значение функции = " + d);
    }
}
