package shopping;

public class StringValidator {

    private StringValidator() {
    }

    public static boolean isValidName(String name) {
        return name != null && !name.trim().isEmpty();
    }
}
