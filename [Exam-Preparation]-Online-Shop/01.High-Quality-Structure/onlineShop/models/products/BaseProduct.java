package onlineShop.models.products;

public abstract class BaseProduct implements Product {
    private int id;
    private String manufacturer;
    private String model;
    private double price;
    private double overallPerformance;

    protected BaseProduct(int id, String manufacturer, String model, double price, double overallPerformance) {
        this.setId(id);
        this.setManufacturer(manufacturer);
        this.setModel(model);
        this.setPrice(price);
        this.setOverallPerformance(overallPerformance);
    }

    private void setId(int id) {
        this.id = id;
    }

    private void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    private void setModel(String model) {
        this.model = model;
    }

    private void setPrice(double price) {
        this.price = price;
    }

    private void setOverallPerformance(double overallPerformance) {
        this.overallPerformance = overallPerformance;
    }

    @Override
    public int getId() {
        return 0;
    }

    @Override
    public String getManufacturer() {
        return null;
    }

    @Override
    public String getModel() {
        return null;
    }

    @Override
    public double getPrice() {
        return 0;
    }

    @Override
    public double getOverallPerformance() {
        return 0;
    }

    @Override
    public String toString() {
        return "BaseProduct{}";
    }
}
