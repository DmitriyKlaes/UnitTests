package seminars.first.hw.Shop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.Assertions.*;

public class ShopTest {

    public static void main(String[] args) {
        Product milk = new Product(95, "Молоко");
        Product beer = new Product(175, "Пиво");
        Product meat = new Product(390, "Мясо");
        Product bread = new Product(67, "Хлеб");
        Product chocolate = new Product(59, "Шоколад");
        List<Product> productList = new ArrayList<>(Arrays.asList(milk, beer, meat, bread, chocolate));
        Shop shop = new Shop(productList);

//        1. Напишите тесты, чтобы проверить, что магазин хранит верный список продуктов
//                (правильное количество продуктов, верное содержимое корзины).
        assertThat(shop.getProducts()).hasSize(5)
                                      .contains(milk, beer, meat, bread, chocolate);

//        2. Напишите тесты для проверки корректности работы метода getMostExpensiveProduct.
        assertThat(shop.getMostExpensiveProduct().getCost()).isEqualTo(390);

//        3. Напишите тесты для проверки корректности работы метода sortProductsByPrice
//        (проверьте правильность сортировки).
        int[] expectedSortCosts = {59, 67, 95, 175, 390};
        for (int i = 0; i < expectedSortCosts.length; i++) {
            assertThat(shop.sortProductsByPrice().get(i).getCost()).isEqualTo(expectedSortCosts[i]);
        }
    }
}