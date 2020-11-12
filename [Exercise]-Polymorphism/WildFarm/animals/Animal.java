package WildFarm.animals;

import WildFarm.foods.Food;

import java.text.DecimalFormat;

public abstract class Animal {
    private String name;
    private String type;
    private double weight;
    private String livingRegion;
    private int foodEaten;

    protected Animal(String name, String type, double weight, String livingRegion) {
        this.name = name;
        this.type = type;
        this.weight = weight;
        this.livingRegion = livingRegion;
    }

    protected String getType() {
        return this.type;
    }

    public abstract void makeSound();

    public void eat(Food food) {
        this.foodEaten += food.getQuantity();
    }

    @Override
    public String toString() {
        DecimalFormat formatter = new DecimalFormat("##.##");
        return String.format(
                "%s[%s, %s, %s, %d]",
                this.type,
                this.name,
                formatter.format(this.weight),
                this.livingRegion,
                this.foodEaten
                );
    }
}
