package WildFarm.animals;

import WildFarm.foods.Food;

public class Cat extends Felime {
    private String breed;

    public Cat(String name, String type, double weight, String livingRegion,
               String breed) {
        super(name, type, weight, livingRegion);
        this.breed = breed;
    }

    @Override
    public void makeSound() {
        System.out.println("Meowwww");
    }

    @Override
    public String toString() {
        StringBuilder baseToString = new StringBuilder(super.toString());
        baseToString.insert(baseToString.indexOf(",") + 1, " " + this.breed + ",");

        return baseToString.toString();
    }
}
