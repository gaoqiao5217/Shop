import java.util.List;

class Order {
    private List<Product> products;
    private boolean isDelivered;

    public Order(List<Product> products) {
        this.products = products;
        this.isDelivered = false;
    }

    public void deliver() { isDelivered = true; }
}