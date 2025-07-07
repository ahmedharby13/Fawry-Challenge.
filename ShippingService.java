import java.util.*;

class ShippingService {
    public void ship(List<Shippable> items) {
        System.out.println("** Shipment notice **");
        double totalWeight = 0;
        for (Shippable item : items) {
            System.out.println(item.getName() + " - " + item.getWeight() + "kg");
            totalWeight += item.getWeight();
        }
        System.out.println("Total package weight: " + totalWeight + "kg\n");
    }
}