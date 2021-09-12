import java.util.Scanner;
import java.math.BigDecimal;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of iterations: ");
        while (!sc.hasNextInt()) {
            System.out.print("Plz, enter again: ");
            sc.next();
        }
        int n = sc.nextInt();

        System.out.print("Enter x value: ");
        while (!sc.hasNextDouble()) {
            System.out.print("Plz, enter again: ");
            sc.next();
        }
        double x = sc.nextDouble();
        sc.close();

        RowCalculator calculator = new RowCalculator();
        System.out.printf("e^%g = ", x);
        System.out.println(calculator.<BigDecimal>Calculate(x, n));
    }
}