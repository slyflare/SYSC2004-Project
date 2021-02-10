// Vimal Gunasegaran 101155249 //
// Nikita Volochay 101162520 //

// Coded by Vimal. Reviewed and refactored by Nikita //

public class StoreManager {
        private Inventory inventory;

        public StoreManager(Inventory i) {
            this.inventory = i;
        }

        public int checkStock(String name) {
            int id = 0;
            for (Product p : inventory.getProductList()) {
                if (p.getItemName().equals(name)) {
                    id = p.getItemID();
                }
            }
            return inventory.getStock(id);
        }

        public String checkOut(int[][] cart) {
            double totalPrice = 0;
            for (int[] c : cart) {
                for (Product p1 : inventory.getProductList()) {
                    if (c[0] == p1.getItemID()) {
                        assert (c[1] < p1.getItemStock()) : "Not enough " + inventory.getProductInfo(p1.getItemID()) + " in stock";
                        inventory.sellStock(c[0], c[1]);
                        totalPrice += p1.getItemCost() * c[1];
                    }
                }
            }
            return "Total price: $" + totalPrice;
        }
    }
