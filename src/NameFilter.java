import java.util.ArrayList;
import java.util.List;

public class NameFilter implements ProductFilter{
    private String contains;

    public NameFilter(String contains) {
        this.contains = contains;
    }


    @Override
    public List<Product> filter(List<Product> products) {
        List<Product> filteredProducts = new ArrayList<>();
        for (Product product : products) {
            if (product.getName().contains(contains)) {
                filteredProducts.add(product);
            }
        }
        return filteredProducts;
    }
}
