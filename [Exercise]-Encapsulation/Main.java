import pizza.Dough;
import pizza.Pizza;
import pizza.Topping;
import shopping.Person;
import shopping.Product;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String[] tokens = input.split("\\s+");

        try {

            Pizza pizza = new Pizza(tokens[1], Integer.parseInt(tokens[2]));

            tokens = scanner.nextLine().split("\\s+");

            Dough dough = new Dough(tokens[1], tokens[2], Double.parseDouble(tokens[3]));

            pizza.setDough(dough);

            input = scanner.nextLine();

            while (!input.equals("END")) {

                tokens = input.split("\\s+");

                Topping topping = new Topping(tokens[1], Double.parseDouble(tokens[2]));

                pizza.addTopping(topping);

                input = scanner.nextLine();
            }

            System.out.println(pizza.toString());

        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static void buyProduct(Map<String, Person> people, Map<String, Product> products, String person, String product) {
        try {
            people.get(person).buyProduct(products.get(product));
            System.out.println(person + " bought " + product);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static Map<String, Person> getPeople(Scanner scanner) {
        String[] tokens = scanner.nextLine().split(";");

        Map<String, Person> people = new LinkedHashMap<>();

        for (String token : tokens) {
            String[] personInfo = token.split("=");

            Person person = new Person(personInfo[0], Double.parseDouble(personInfo[1]));

            people.put(person.getName(), person);
        }

        return people;
    }

    private static Map<String, Product> getProducts(Scanner scanner) {
        String[] tokens = scanner.nextLine().split(";");

        Map<String, Product> people = new LinkedHashMap<>();

        for (String token : tokens) {
            String[] personInfo = token.split("=");

            Product person = new Product(personInfo[0], Double.parseDouble(personInfo[1]));

            people.put(person.getName(), person);
        }

        return people;
    }
}
