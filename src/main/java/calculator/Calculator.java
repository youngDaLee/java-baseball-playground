package calculator;

import java.util.Arrays;
import java.util.Scanner;

public class Calculator {

    public static double calc(String calcString) {
        String[] calcList = calcString.split(" ");

        double num = Integer.parseInt(calcList[0]);
        for (int i = 1; i < Arrays.stream(calcList).count(); i++) {
            if (calcList[i].equals("+")) {
                num += Integer.parseInt(calcList[i+1]);
            } else if (calcList[i].equals("-")) {
                num -= Integer.parseInt(calcList[i+1]);
            } else if (calcList[i].equals("*")) {
                num *= Integer.parseInt(calcList[i+1]);
            } else if (calcList[i].equals("/")) {
                num /= Integer.parseInt(calcList[i+1]);
            }
        }

        return num;
    }
    public static void main() {
        Scanner sc = new Scanner(System.in);
        String calcString = sc.nextLine();
        double result = calc(calcString);
        System.out.println(result);
    }
}
