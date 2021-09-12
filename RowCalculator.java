import java.math.BigDecimal;
import java.math.RoundingMode;
import java.lang.Math;

public class RowCalculator {
    private int precision;

    public RowCalculator() {
        this.precision = 15;
    }

    public RowCalculator(int precision) {
        this.precision = precision;
    }

    public <T> T Calculate(double x, int n) {
        return (T) (n > precision ? highPrecision(x, n) : lowPrecision(x, n));
    }

    private static BigDecimal highPrecision(double x, int n) {
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

    private static double lowPrecision(double x, int n) {
        double result = Math.E;
        double num = 1, denum = 1;

        for (int i = 1; i < n; i++) {
            num *= x - 1;
            denum *= i;
            result += Math.E * num / denum;
        }

        return result;
    }
}
