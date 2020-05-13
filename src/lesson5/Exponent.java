package lesson5;

public class Exponent {

    public static void main(String[] args) {
        for (int i = -10; i < 10; i++) {
            System.out.printf("%d ^ %d = %f\n",2, i,calcExp(2, i));

        }
    }

    private static double calcExp(int basis, int exp) {
        if (exp < 0) {
            return 1 / (getExp(basis, Math.abs(exp)));
        } else {
            return getExp(basis, exp);
        }
    }

    private static double getExp(int basis, int exp) {
        if (exp == 0) {
            return 1;
        }

        if (exp == 1) {
            return basis;
        }

        return basis * getExp(basis, --exp);
    }
}
