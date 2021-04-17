package myStore;

// Nikita Volochay 101162520 //
// Vimal Gunasegaran 101155249//

// Coded by Vimal. Other class overrides by Nikita //

public interface ProductStockContainer {

    public int getProductQuantity(Product p);

    public void addProductQuantity(Product p, int i);

    public void removeProductQuantity(Product p, int i);

    public int getNumOfProducts();
}
