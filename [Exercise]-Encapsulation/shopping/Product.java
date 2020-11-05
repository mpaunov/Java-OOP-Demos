package shopping;

public class Product {
    private String name;
    private double cost;

    public Product(String name, double cost) {
        this.setName(name);
        this.setCost(cost);
    }

    private void setName(String name) {
        if (!StringValidator.isValidName(name)) {
            throw new IllegalArgumentException(
                    ConstantMessages.INVALID_NAME_EXCEPTION_MESSAGE);
        }

        this.name = name;
    }

    private void setCost(double cost) {
        if (!NumericValidator.isNonNegative(cost)) {
            throw new IllegalArgumentException(
                    ConstantMessages.NEGATIVE_MONEY_EXCEPTION_MESSAGE);
        }

        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public double getCost() {
        return cost;
    }
}
