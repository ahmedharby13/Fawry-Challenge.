public class Main {
    public static void main(String[] args) {
        Cheese cheese = new Cheese("Cheese", 100, 5, java.time.LocalDate.now().plusDays(2), 0.2);
        Biscuits biscuits = new Biscuits("Biscuits", 150, 2, java.time.LocalDate.now().plusDays(1), 0.7);
        TV tv = new TV("TV", 4000, 1, 5.0);
        MobileCard scratchCard = new MobileCard("Scratch Card", 50, 10);

        Customer customer = new Customer("Ahmed", 1000);
        Cart cart = new Cart();
        cart.add(cheese, 2);
        cart.add(biscuits, 1);
        cart.add(scratchCard, 1);

        CheckoutService.checkout(customer, cart);
    }
}