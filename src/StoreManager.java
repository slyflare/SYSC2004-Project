//Vimal Gunasegaran, 101155249//

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
            for (int[] i : inventory.getArrayStock()) {
                if (c[0] == i[0]) {
                    assert (c[1] < i[1]) : "Not enough " + inventory.getProductInfo(i[0]) +" in stock";
                    inventory.sellStock(c[0], c[1]);
                    for (Product p : inventory.getProductList()) {
                        if (c[0] == p.getItemID()) {
                            totalPrice += p.getItemCost() * c[1];
                            }
                        }
                    }
                }
            }
        return "Total price: $" + totalPrice;
    }
}
