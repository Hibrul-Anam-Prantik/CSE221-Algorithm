package Lab01;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i= 0; i < T; ++i) {
            double num1, num2;
            String operation;
            String prompt = sc.next(); // using to read "calculate" prompt
            num1 = sc.nextDouble(); operation = sc.next(); num2 = sc.nextDouble();

            switch(operation) {
                case "+": System.out.printf("%.6f\n", (num1 + num2)); break;
                case "-": System.out.printf("%.6f\n", (num1 - num2)); break;
                case "*": System.out.printf("%.6f\n", (num1 * num2)); break;
                case "/": System.out.printf("%.6f\n", (num1 / num2)); break;
                default: break;
            }
        }
        sc.close();
    }
}
