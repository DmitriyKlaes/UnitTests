package seminars.first.hw.Shop;

/*
*Задание 2. (необязательное) *
Мы хотим улучшить функциональность нашего интернет-магазина.
* Ваша задача - добавить два новых метода в класс Shop:
Метод sortProductsByPrice(), который сортирует список продуктов по стоимости.
* Метод getMostExpensiveProduct(), который возвращает самый дорогой продукт.
* Напишите тесты, чтобы проверить, что магазин хранит верный список продуктов
* (правильное количество продуктов, верное содержимое корзины).
Напишите тесты для проверки корректности работы метода getMostExpensiveProduct.
* Напишите тесты для проверки корректности работы метода sortProductsByPrice
* (проверьте правильность сортировки). Используйте класс Product
* для создания экземпляров продуктов и класс Shop для написания методов сортировки и тестов.
 */

import java.util.Comparator;
import java.util.List;

public class Shop {
    private List<Product> products;

    public Shop(List<Product> products) {
        this.products = products;
    }

    // Геттеры, сеттеры:
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    // Метод должен вернуть отсортированный по возрастанию по цене список продуктов
    public List<Product> sortProductsByPrice() {
        this.products.sort((o1, o2) -> {
            if (o1.getCost() > o2.getCost()) return 1;
            else if (o1.getCost() < o2.getCost()) return -1;
            return 0;
        });
        return this.products;
    }

    // Метод должен вернуть самый дорогой продукт
    public Product getMostExpensiveProduct() {
        return sortProductsByPrice().get(getProducts().size() - 1);
    }

}