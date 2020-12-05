package onlineShop.models.products.components;

public class Motherboard extends BaseComponent {
    public Motherboard(int id, String manufacturer, String model, double price, double overallPerformance, int generation) {
        super(id, manufacturer, model, price, 1.25 * overallPerformance, generation);
    }
}
