import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static int num1, num2;
    static char operation;
    static int result;

    public static void main(String[] args) {
        System.out.println("Enter your expression: ");
        String userInput = scanner.nextLine();
        char[] oper_char = new char[10];
        for (int i = 0; i < userInput.length(); i++) {
            oper_char[i] = userInput.charAt(i);
            if (oper_char[i] == '+') {
                operation = '+';
            }
            if (oper_char[i] == '-') {
                operation = '-';
            }
            if (oper_char[i] == '*') {
                operation = '*';
            }
            if (oper_char[i] == '/') {
                operation = '/';
            }
        }
        String oper_charString = String.valueOf(oper_char);
        String[] signs = oper_charString.split("[+-/*]");
        String pt1 = signs[0];
        String pt2 = signs[1];
        String cutPt2 = pt2.trim();
        num1 = Enum.convertRomanToArab(pt1);
        num2 = Enum.convertRomanToArab(cutPt2);
        if (signs.length > 2
        )
            throw new ArrayIndexOutOfBoundsException("two numbers only");
        else
            signs = Arrays.copyOf(signs, 2);
        try {
            pt1 = signs[0].trim();
        } catch (NullPointerException e) {
            throw new NullPointerException();
        }

        if (num1 < 0 && num2 < 0) {
            result = 0;
        } else {
            result = Enum.calc(num1, num2, operation);
            System.out.println("Result Roman:");
            String resultRoman = Enum.convertNumToRoman(result);
            System.out.println(pt1 + " " + operation + " " + cutPt2 + " = " + resultRoman);
        }
        num1 = Enum.convertRomanToArab(pt1);
        if (num1 == -1) num1 = Integer.parseInt(pt1);
        num2 = Enum.convertRomanToArab(cutPt2);
        if (num2 == -1) {
            num2 = Integer.parseInt(cutPt2);
            result = Enum.calc(num1, num2, operation);
            System.out.println("Result Arabic:");
            System.out.println(num1 + " " + operation + " " + num2 + " = " + result);
        }
    }
}