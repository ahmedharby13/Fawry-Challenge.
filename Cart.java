import java.util.*;

class CartItem {
    Product product;
    int quantity;

    public CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return product.getPrice() * quantity;
    }
}

class Cart {
    private List<CartItem> items = new ArrayList<>();

    public void add(Product product, int quantity) {
        if (product.isAvailable(quantity)) {
            items.add(new CartItem(product, quantity));
        } else {
            System.out.println("Quantity exceeds available stock.");
        }
    }

    public List<CartItem> getItems() { return items; }
    public boolean isEmpty() { return items.isEmpty(); }
}