import java.math.BigDecimal;
import java.math.RoundingMode;
import java.lang.Math;
import java.util.Scanner;

class Main {
    public static BigDecimal highPrecision(double x, int n) {
        BigDecimal result = new BigDecimal(Math.E);
        BigDecimal num = new BigDecimal(1);
        BigDecimal denum = new BigDecimal(1);

        for (int i = 1; i < n; i++) {
            num = num.multiply(BigDecimal.valueOf(x - 1));
            denum = denum.multiply(BigDecimal.valueOf(i));
            result = result.add(num.multiply(BigDecimal.valueOf(Math.E)).divide(denum, n, RoundingMode.HALF_UP));
        }

        return result;
    }

    public static double lowPrecision(double x, int n) {
        double result = Math.E;
        double num = 1, denum = 1;

        for (int i = 1; i < n; i++) {
            num *= x - 1;
            denum *= i;
            result += Math.E * num / denum;
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double x = sc.nextDouble();
        sc.close();
        System.out.println((n > 15) ? highPrecision(x, n) : lowPrecision(x, n));
    }
}