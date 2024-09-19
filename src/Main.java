import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Store store = new Store();
        Scanner scanner = new Scanner(System.in);
        ProductFilter filter = null;
        boolean running = true;

        while (running) {
            System.out.println("1. Показать все товары");
            System.out.println("2. Добавить товар в корзину");
            System.out.println("3. Оформить заказ");
            System.out.println("4. Фильтровать товары");
            System.out.println("5. Выход");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    store.showProducts();
                    break;
                case 2:
                    System.out.print("Введите индекс товара: ");
                    int index = scanner.nextInt() - 1;
                    store.addToCart(index);
                    break;
                case 3:
                    store.checkout();
                    break;
                case 4:
                    System.out.println("Фильтр по:");
                    System.out.println("1. Цена");
                    System.out.println("2. Название");
                    int filterBy = scanner.nextInt();
                    switch (filterBy) {
                        case 1:
                            System.out.println("Минимальная цена:");
                            int min = scanner.nextInt();
                            System.out.println("Максимальная цена:");
                            int max = scanner.nextInt();
                            filter = new PriceFilter(min, max);
                            break;
                        case 2:
                            System.out.println("Введите слово для поиска в имени товара:");
                            String name = scanner.nextLine();
                            filter = new NameFilter(name);
                            break;
                    }
                    for (Product product : filter.filter(store.getProducts())) {
                        System.out.println(product);
                    }
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Некорректный выбор. Попробуйте снова.");
            }
        }
        scanner.close();
    }
}

