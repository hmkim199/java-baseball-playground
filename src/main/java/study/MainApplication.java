package study;

import java.util.Scanner;

public class MainApplication {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            String value = scanner.nextLine();
            String[] values = value.split(" ");
            StringCalculator stringCalculator = new StringCalculator();
            System.out.println("계산 결과 = " + stringCalculator.calculateString(values));
        } catch (IllegalArgumentException e) {
            System.out.println("e = " + e);
        }
    }
}
