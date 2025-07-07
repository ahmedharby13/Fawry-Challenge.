import java.util.*;

class CheckoutService {
    private static final double SHIPPING_FEE_PER_KG = 30;

    public static void checkout(Customer customer, Cart cart) {
        if (cart.isEmpty()) {
            throw new RuntimeException("Cart is empty.");
        }

        double subtotal = 0;
        double totalShippingWeight = 0;
        List<Shippable> shippables = new ArrayList<>();

        for (CartItem item : cart.getItems()) {
            Product product = item.product;
            if (product.isExpired()) {
                throw new RuntimeException(product.getName() + " is expired.");
            }
            if (!product.isAvailable(item.quantity)) {
                throw new RuntimeException(product.getName() + " is out of stock.");
            }
            subtotal += item.getTotalPrice();
            if (product instanceof Shippable) {
                for (int i = 0; i < item.quantity; i++)
                    shippables.add((Shippable) product);
                totalShippingWeight += ((Shippable) product).getWeight() * item.quantity;
            }
        }

        double shippingCost = totalShippingWeight * SHIPPING_FEE_PER_KG;
        double totalAmount = subtotal + shippingCost;

        if (customer.getBalance() < totalAmount) {
            throw new RuntimeException("Insufficient balance.");
        }

        for (CartItem item : cart.getItems()) {
            item.product.reduceQuantity(item.quantity);
        }

        new ShippingService().ship(shippables);
        customer.pay(totalAmount);

        System.out.println("** Checkout receipt **");
        for (CartItem item : cart.getItems()) {
            System.out.println(item.quantity + "x " + item.product.getName() + "\t" + item.getTotalPrice());
        }
        System.out.println("----------------------");
        System.out.println("Subtotal\t" + subtotal);
        System.out.println("Shipping\t" + shippingCost);
        System.out.println("Amount\t\t" + totalAmount);
        System.out.println("Remaining Balance: " + customer.getBalance());
    }
}