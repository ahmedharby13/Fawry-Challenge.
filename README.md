## 📦 Project Overview

This Java-based application simulates a basic e-commerce system with the following features:

- Add products (expirable / shippable / regular).
- Customer shopping cart with quantity limits.
- Checkout process including:
  - Subtotal
  - Shipping fee (based on weight)
  - Final amount
  - Customer balance check
- Rejects expired or out-of-stock products.
- ShippingService handles all items requiring delivery.

## 🛠️ Tech Stack

- Language: Java (JDK 17+)
- IDE: VS Code / IntelliJ
- No frameworks – pure OOP with Java SE

## 👨‍💻 Features Implemented

- Custom product types: Cheese, TV, Biscuits, Mobile Cards
- `Shippable` interface for shipping logic
- Product expiration check
- Customer balance validation
- Order summary and shipment details via console

## ✅ Example Output

```bash
** Shipment notice **
Cheese - 0.2kg
Biscuits - 0.7kg
Total package weight: 0.9kg

** Checkout receipt **
2x Cheese	200.0
1x Biscuits	150.0
1x Scratch Card	50.0
----------------------
Subtotal	400.0
Shipping	27.0
Amount		427.0
Remaining Balance: 573.0
