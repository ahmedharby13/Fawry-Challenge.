interface Shippable {
    String getName();
    double getWeight();
}

abstract class Product {
    protected String name;
    protected double price;
    protected int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public boolean isAvailable(int requestedQuantity) {
        return quantity >= requestedQuantity;
    }

    public void reduceQuantity(int requestedQuantity) {
        quantity -= requestedQuantity;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }
    public boolean isExpired() { return false; }
    public boolean requiresShipping() { return false; }
}

class Cheese extends Product implements Shippable {
    private java.time.LocalDate expiryDate;
    private double weight;

    public Cheese(String name, double price, int quantity, java.time.LocalDate expiryDate, double weight) {
        super(name, price, quantity);
        this.expiryDate = expiryDate;
        this.weight = weight;
    }

    @Override
    public boolean isExpired() {
        return expiryDate.isBefore(java.time.LocalDate.now());
    }

    @Override
    public boolean requiresShipping() {
        return true;
    }

    @Override
    public double getWeight() {
        return weight;
    }
}

class Biscuits extends Product implements Shippable {
    private java.time.LocalDate expiryDate;
    private double weight;

    public Biscuits(String name, double price, int quantity, java.time.LocalDate expiryDate, double weight) {
        super(name, price, quantity);
        this.expiryDate = expiryDate;
        this.weight = weight;
    }

    @Override
    public boolean isExpired() {
        return expiryDate.isBefore(java.time.LocalDate.now());
    }

    @Override
    public boolean requiresShipping() {
        return true;
    }

    @Override
    public double getWeight() {
        return weight;
    }
}

class TV extends Product implements Shippable {
    private double weight;

    public TV(String name, double price, int quantity, double weight) {
        super(name, price, quantity);
        this.weight = weight;
    }

    @Override
    public boolean requiresShipping() {
        return true;
    }

    @Override
    public double getWeight() {
        return weight;
    }
}

class MobileCard extends Product {
    public MobileCard(String name, double price, int quantity) {
        super(name, price, quantity);
    }
}