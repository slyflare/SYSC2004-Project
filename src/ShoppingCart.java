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

    public ArrayList<Product> getCart(){
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

    //Setters
    public void setCartID(int newID){
        this.cartID = newID;
    }

    //Other Methods

    public void addToCart(int amount, Product product){
        if((getStock(product.getItemID())-amount) > 0) {
            this.cartItems.put(product, amount);
        }
        else{
            System.out.println("Insufficient stock of " + product.getItemName());
        }
    }

    public void removeFromCart(Product product){
        for(Product p: this.cartItems.keySet()){
            if (p.equals(product)){
                this.cartItems.remove(p);
            }
        }
    }

}
