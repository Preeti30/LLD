package org.example;;

import org.example.models.*;
import org.example.service.ProductDeliverySystem;
import org.example.strategy.warehouseStrategy.NearestWarehouseSelectionStrategy;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String args[]){
        Main mainObj = new Main();

        System.out.println("🚀 Welcome to Blinkit...");

        // 1. Create warehouses in the system
        List<Warehouse> warehouseList = new ArrayList<>();
        warehouseList.add(mainObj.addWarehouseAndItsInventory());

        // 2. Create users in the system
        List<User> userList = new ArrayList<>();
        userList.add(mainObj.createUser());

        // 3. Feed the system with the initial information
        ProductDeliverySystem productDeliverySystem = new ProductDeliverySystem(userList, warehouseList);

        System.out.println("✅ Initial setup completed. Running delivery flow...");

        mainObj.runDeliveryFlow(productDeliverySystem, 1);
    }

    private Warehouse addWarehouseAndItsInventory(){
        System.out.println("\n🏢 Adding warehouse and inventory...\n");
        Address warehouseLocation = new Address(230011, "city", "state");

        Inventory inventory = new Inventory();

        inventory.addCategory(0001, "🥤 Coco Cola Cold Drink", 100);
        inventory.addCategory(0004, "🧼 Lux Small Soap", 50);

        System.out.println("📦 Categories added to inventory ✅\n");

        // Create 3 Products
        Product product1 = new Product();
        product1.productId = 1;
        product1.productName = "🥤 Coco Cola";

        Product product2 = new Product();
        product2.productId = 2;
        product2.productName = "🥤 Coco Cola";

        Product product3 = new Product();
        product3.productId = 3;
        product3.productName = "🧼 Lux";

        inventory.addProduct(product1, 0001);
        inventory.addProduct(product2, 0001);
        inventory.addProduct(product3, 0004);

        System.out.println("🛒 Products added to inventory ✅");

        // Print inventory nicely formatted
        printInventory(inventory);
        Warehouse warehouse = new Warehouse(warehouseLocation, inventory);
        return warehouse;
    }

    private void printInventory(Inventory inventory) {
        System.out.println("\n📜 Current Inventory List:");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        for (ProductCategory category : inventory.productCategoryList) {
            System.out.println("🆔 ID: " + category.productCategoryId);
            System.out.println("📌 Category: " + category.categoryName);
            System.out.println("📦 Stock: " + category.getStock());
            System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        }
    }

    private User createUser(){
        System.out.println("\n👤 Creating user...");
        User user = new User();
        user.userId = 1;
        user.userName = "Mrunmai";
        user.address = new Address(230011, "City", "State");
        System.out.println("✅ User created: " + user.userName + " 🎉 with pincode: " + user.address.getPinCode());
        return user;
    }

    private void runDeliveryFlow(ProductDeliverySystem productDeliverySystem, int userId){
        System.out.println("\n🚚 Running delivery flow for user ID: " + userId);

        // 1. Get the user object
        User user = productDeliverySystem.getUser(userId);
        System.out.println("👤 User retrieved: " + user.userName);

        // 2. Get warehouse based on user preference
        System.out.println("👤 Finding the nearest warehouse for the pincode " + user.address.getPinCode() + "!");
        Warehouse warehouse = productDeliverySystem.getWarehouse(new NearestWarehouseSelectionStrategy());
        System.out.println("🏢 Warehouse selected.");

        // 3. Get all inventory to show the user
        Inventory inventory = productDeliverySystem.getInventory(warehouse);
        System.out.println("📦 Inventory retrieved.");

        printInventory(inventory);  // Display inventory to the user

        // 4. Select product to order
        ProductCategory productCategoryIWantToOrder = null;
        for (ProductCategory productCategory : inventory.productCategoryList) {
            if (productCategory.categoryName.equals("🥤 Coco Cola Cold Drink")) {
                productCategoryIWantToOrder = productCategory;
                System.out.println("🛍️ Product selected for order: " + productCategory.categoryName);
                break;
            }
        }
        if (productCategoryIWantToOrder == null) {
            System.out.println("❌ Error: Product category not found in inventory!");
            return;  // Stop execution to prevent a crash
        }

        // 5. Add product to the cart
        productDeliverySystem.addProductToCart(user, productCategoryIWantToOrder, 2);
        System.out.println("🛒 Product added to cart.");

        // 6. Place order
        Order order = productDeliverySystem.placeOrder(user, warehouse);
        System.out.println("📦 Order placed successfully! 🎉");

        // 7. Checkout
        productDeliverySystem.checkout(order);
        System.out.println("✅ Checkout completed. Order is on the way! 🚚💨");
    }
}
