package shopping;

public class NumericValidator {

    private NumericValidator() {
    }

    public static boolean isNonNegative(double val) {
        return val >= 0;
    }
}
