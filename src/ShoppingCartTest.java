package storetest;

import org.junit.*;
import store.Product;
import store.ShoppingCart;

import java.util.ArrayList;

public class ShoppingCartTest {
    ShoppingCart cart;

    @Before
    public void init(){
        cart = new ShoppingCart(1);
    }

    @Test
    public void getCartID(){
        assert cart.getCartID() == 1 : "Cart ID retrieved using getCartID is different";
    }

    @Test
    public void getItems(){
        ArrayList<Product> test = new ArrayList<>();
        //idk if i should add something into cart and compare that instead
        assert cart.getItems().equals(test) : "Items in cart was not empty";
    }

    @Test
    public void getCartAmount(){
        cart.addToCart(5,1);
        assert cart.getCartAmount(1) == 5 : "Amount of specific item ";
    }

    @Test
    public void getCartInfo(){
        cart.addToCart(5,1);
        String output = "Apple, 5, ID: 1\n";
        assert cart.getCartInfo().compareTo(output) == 0: "getCartInfo is outputting the wrong format or wrong values";
    }

    @Test
    public void setCartID(){
        cart.setCartID(5);
        assert cart.getCartID() == 5 : "Cart ID was not set to 5";
    }

    @Test
    public void addToCart(){
        cart.addToCart(5,1);
        String output = "Apple, 5, ID: 1\n";
        assert cart.getCartInfo().compareTo(output) == 0: "addToCart didn't add item to cart";
    }

    @Test
    public void removeFromCart(){
        cart.addToCart(5,1);
        cart.removeFromCart(1,1);
        String output = "Apple, 4, ID: 1\n";
        assert cart.getCartInfo().compareTo(output) == 0: "addToCart didn't add item to cart";
    }

    @Test
    public void clearCart(){
        cart.addToCart(5,1);
        cart.clearCart();
        assert cart.getItems().size() == 0: "clearCart didn't clear items from cart";
    }
}
