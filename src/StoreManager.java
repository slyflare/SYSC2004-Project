// Vimal Gunasegaran 101155249 //
// Nikita Volochay 101162520 //

// Coded by Vimal. Reviewed and refactored by Nikita //

private static Inventory inventory;
        private ArrayList<ShoppingCart> cartList;

        public StoreManager() {
        this.inventory = new Inventory();
        this.cartList = new ArrayList<>();
    }

      /*  public int checkStock(String name) {
            int id = 0;
            for (Product p : inventory.getProductList()) {
                if (p.getItemName().equals(name)) {
                    id = p.getItemID();
                }
            }
            return inventory.getStock(id);
        } */ 
        
        // Code above replaced with code below so that item id is not returned as 0 by default if item name not found.
        
         public int checkStock(String name) {
            for (Product p : inventory.getProductList()) {
                if (p.getItemName().equals(name)) {
                    return inventory.getStock(p.getItemID());
                }
            }
           return -1;
        }

        public String checkOut(ShoppingCart cart) {
        double totalPrice = 0;
        for (Product c: cart.getCart()) {
            for (Product p : inventory.getProductList()) {
                if (c.getItemID() == p.getItemID() && c.getItemName().equals(p.getItemName())){
                    assert (cart.getCartAmount(c.getItemID()) < p.getItemStock()) : "Not enough " + inventory.getProductInfo(p.getItemID()) + " in stock";
                    inventory.sellStock(c.getItemID(), cart.getCartAmount(c.getItemID()));
                    totalPrice += c.getItemCost() * cart.getCartAmount(c.getItemID());
                }
            }
        }

        /* Changed code
        for (int[] c : cart) {
            for (Product p1 : inventory.getProductList()) {
                if (c[0] == p1.getItemID()) {
                    assert (c[1] < p1.getItemStock()) : "Not enough " + inventory.getProductInfo(p1.getItemID()) + " in stock";
                    inventory.sellStock(c[0], c[1]);
                    totalPrice += p1.getItemCost() * c[1];
                }
            }
        }*/

        return "Total price: $" + totalPrice;
    }

    //Shopping cart methods
    public ShoppingCart initialiseCart(){
        int newID = this.cartList.size()+1;
        ShoppingCart cart = new ShoppingCart(newID);
        this.cartList.add(cart);
        return cart;
    }
}
