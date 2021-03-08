import java.util.ArrayList;
import java.util.HashMap;

public class ShoppingCart extends Inventory{

    private int cartID;
    private HashMap<Product, Integer> cartItems;

    public ShoppingCart(int cartID){
        this.cartID = cartID;
        this.cartItems = new HashMap<>();
    }

    //Getters
    public int getCartID() {
        return cartID;
    }

    public ArrayList<Product> getItems(){
        return new ArrayList<>(cartItems.keySet());
    }

    public int getCartAmount(int pID){
        for(Product p: cartItems.keySet()){
            if(p.getItemID() == pID){
                return cartItems.get(p);
            }
        }
        return 0;
    }

    public String getCartInfo(){
        StringBuilder s = new StringBuilder();
        for(Product p : this.cartItems.keySet()){
            s.append(p.getItemName()).append(", ").append(this.cartItems.get(p)).append(", ID: ").append(p.getItemID()).append("\n");
        }
        return s.toString();
    }

    //Setters
    public void setCartID(int newID){
        this.cartID = newID;
    }

    //Other Methods

    public void addToCart(int amount, int ID){
            if (getProduct(ID).getItemID() != 0) {
                if(cartItems.get(getProduct(ID)) != null){
                    int total = amount + cartItems.get(getProduct(ID));
                    this.cartItems.put(getProduct(ID), total);
                } else {
                        this.cartItems.put(getProduct(ID), amount);
                }
                System.out.println("Item(s) successfully added to cart");
            } else {
                System.out.println("Item does not exist in inventory.");
            }
    }

    public void removeFromCart(int amount, int ID){
        for(Product p: this.cartItems.keySet()){
            if (p.getItemID() == ID){
                int total = cartItems.get(getProduct(ID)) - amount;
                if(total > 0) {
                    this.cartItems.put(getProduct(ID), total);
                }
                else{
                    this.cartItems.remove(p);
                }
                System.out.println("Item(s) successfully removed from cart");
            }
        }

    }

    public void clearCart(){
        for(Product p: this.cartItems.keySet()){
            this.cartItems.remove(p);
        }
    }

}
