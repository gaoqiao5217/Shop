import java.util.ArrayList;
import java.util.List;

public class Store {
    private List<Product> products = new ArrayList<>();
    private Cart cart = new Cart();

    public Store() {
        products.add(new Product("Товар 1", 100.0, "Производитель 1"));
        products.add(new Product("Товар 2", 200.0, "Производитель 2"));
        products.add(new Product("Товар 3", 150.0, "Производитель 3"));
    }

    public void showProducts() {
        for (Product product : products) {
            System.out.println(product);
        }
    }

    public void addToCart(int index) {
        if (index < products.size() && index >= 0) {
            cart.addProduct(products.get(index));
            System.out.println("Товар добавлен в корзину: " + products.get(index));
        } else {
            System.out.println("Некорректный индекс товара.");
        }
    }

    public void checkout() {
        System.out.println("Общая стоимость: " + cart.calculateTotal());
        cart.clear();
        System.out.println("Корзина очищена после оформления заказа.");
    }

    public List<Product> getProducts() {
        return products;
    }
}