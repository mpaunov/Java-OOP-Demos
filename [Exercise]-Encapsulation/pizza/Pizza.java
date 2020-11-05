package pizza;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private String name;
    private Dough dough;
    private List<Topping> toppings;

    public Pizza(String name, int toppingsCount) {
        setName(name);
        setToppings(toppingsCount);
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()
                || name.length() > 15) {
            throw new IllegalArgumentException
                    ("Pizza name should be between 1 and 15 symbols.");
        }

        this.name = name;
    }

    private void setToppings(int toppingsCount) {
        if (toppingsCount < 0 || toppingsCount > 10) {
            throw new IllegalArgumentException(
                    "Number of toppings should be in range [0..10].");
        }

        this.toppings = new ArrayList<>(toppingsCount);
    }

    public void setDough(Dough dough) {
        this.dough = dough;
    }

    public String getName() {
        return name;
    }

    public void addTopping(Topping topping) {
        this.toppings.add(topping);
    }

    public double getOverallCalories() {
        double calories = this.dough.calculateCalories();

        for (Topping topping : toppings) {
            calories += topping.calculateCalories();
        }

        return calories;
    }

    @Override
    public String toString() {
        return String.format("%s - %.2f", name, getOverallCalories());
    }
}
