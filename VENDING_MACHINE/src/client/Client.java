package client;


import services.VendingMachine;

public class Client {

    public static void main(String[] args) {

        // ----------------------------
        // 1. Get machine instance
        // ----------------------------
        VendingMachine vm = VendingMachine.getInstance();

        // ----------------------------
        // 2. Add products (admin)
        // ----------------------------
        vm.addProduct("C1", "Coke", 40, 5);
        vm.addProduct("P1", "Pepsi", 35, 3);

        // ----------------------------
        // 3. User selects item
        // ----------------------------
        vm.selectItem("C1");

        // ----------------------------
        // 4. Insert money
        // ----------------------------
        vm.insertMoney(50f);

        // ----------------------------
        // 5. Dispense item
        // ----------------------------
        vm.dispense();

        // ----------------------------
        // 6. Try insufficient money flow
        // ----------------------------
        System.out.println("\n--- Insufficient Money Case ---");

        vm.selectItem("P1");
        vm.insertMoney(20f);   // less than price
        vm.dispense();        // should fail (based on your next state logic)

        // ----------------------------
        // 7. Cancel flow
        // ----------------------------
        System.out.println("\n--- Cancel Flow ---");

        vm.selectItem("P1");
        vm.insertMoney(40f);
        vm.cancel();          // should refund

        // ----------------------------
        // 8. Out of stock case
        // ----------------------------
        System.out.println("\n--- Out of Stock Case ---");

        // Reduce stock manually (simulate)
        for (int i = 0; i < 5; i++) {
            vm.selectItem("C1");
            vm.insertMoney(40f);
            vm.dispense();
        }

        // Now no stock
        vm.selectItem("C1");  // should say not available
    }
}