package seminars.first.hw.Calculator;

import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {
    public static void main(String[] args) {
        // Проверка базового функционала с целыми числами:
        if (8 != Calculator.calculation(2, 6, '+')) {
            throw new AssertionError("Ошибка в методе");
        }

        if (0 != Calculator.calculation(2, 2, '-')) {
            throw new AssertionError("Ошибка в методе");
        }

        if (14 != Calculator.calculation(2, 7, '*')) {
            throw new AssertionError("Ошибка в методе");
        }

        if (2 != Calculator.calculation(100, 50, '/')) {
            throw new AssertionError("Ошибка в методе");
        }

        // Случаи с неправильными аргументами
        // аргумент operator типа char, должен вызывать исключение, если он получает не базовые символы (+-*/)
        // try {
        //     seminars.first.hw.Calculator.Calculator.calculation(8, 4, '_');
        // } catch (IllegalStateException e) {
        //     if (!e.getMessage().equals("Unexpected value operator: _")) {
        //         throw new AssertionError("Ошибка в методе");
        //     }
        // }

        // Проверка базового функционала с целыми числами, с использованием утверждений:
        assert 8 == Calculator.calculation(2, 6, '+');
        assert 0 == Calculator.calculation(2, 2, '-');
        assert 14 == Calculator.calculation(2, 7, '*');
        assert 2 == Calculator.calculation(100, 50, '/');

        // Проверка базового функционала с целыми числами, с использованием утверждений AssertJ:
//        assertThat(Calculator.calculation(2, 6, '+')).isEqualTo(8);
//        assertThat(Calculator.calculation(2, 2, '-')).isEqualTo(0);
//        assertThat(Calculator.calculation(2, 7, '*')).isEqualTo(14);
//        assertThat(Calculator.calculation(100, 50, '/')).isEqualTo(2);

        // Проверка ожидаемого исключения, с использованием утверждений AssertJ:
//        assertThatThrownBy(() ->
//                Calculator.calculation(8, 4, '_')
//        ).isInstanceOf(IllegalStateException.class);

//        System.out.println(Calculator.calculation(2_147_483_647, 1, '+')); // integer overflow
//        System.out.println(Calculator.squareRootExtraction(169));

        // Примерные решения домашних заданий из 1 лекции:

        // HW1.1: Придумайте и опишите (можно в псевдокоде) функцию извлечения корня и
        // необходимые проверки для него используя граничные случаи
        // assertThatThrownBy(() ->
        //         seminars.first.hw.Calculator.Calculator.squareRootExtraction(0, 1, -1)
        // ).isInstanceOf(SomeStateException.class);

        // HW1.2: Как будет выглядеть проверка для случая деления на ноль? (с использованием AssertJ)
        // assertThatThrownBy(() ->
        //        seminars.first.hw.Calculator.Calculator.calculation(5, 0, '/')
        // ).isInstanceOf(ArithmeticException.class);

        // HW1.3: Сравните одну и ту же проверку с использованием условий, ассертов, AssertJ
        // в каком случае стандартное сообщение об ошибке будет более информативным?
        // if (0 != seminars.first.hw.Calculator.Calculator.calculation(2, 6, '+')) {
        //     throw new AssertionError("Ошибка в методе");
        // }
        //   assert 0 == seminars.first.hw.Calculator.Calculator.calculation(2, 6, '+');
        //    assertThat(seminars.first.hw.Calculator.Calculator.calculation(2, 6, '+')).isEqualTo(0);


        //---------------------------------------------------------
        //Домашняя работа с семинара
        /*
        Задание 1. ** В классе Calculator создайте метод calculateDiscount,
        который принимает сумму покупки и процент скидки и возвращает сумму с учетом скидки.
        Ваша задача - проверить этот метод с использованием библиотеки AssertJ.
        Если метод calculateDiscount получает недопустимые аргументы,
        он должен выбрасывать исключение ArithmeticException.
        Не забудьте написать тесты для проверки этого поведения.
         */

        // Проверка корректного расчета скидки
        assertThat(Calculator.calculatingDiscount(100.0, 10)).isEqualTo(90);

        // Проверка расчета скидки для суммы покупки 0
        assertThat(Calculator.calculatingDiscount(0.0, 10)).isEqualTo(0);

        // Проверка ожидаемого исключения при отрицательной сумме покупки
        assertThatThrownBy(() -> Calculator.calculatingDiscount(-100.0, 10))
                .isInstanceOf(ArithmeticException.class);

        // Проверка ожидаемого исключения при отрицательном проценте скидки
        assertThatThrownBy(() -> Calculator.calculatingDiscount(100.0, -10))
                .isInstanceOf(ArithmeticException.class);

        // Проверка ожидаемого исключения при проценте скидки больше 100
        assertThatThrownBy(() -> Calculator.calculatingDiscount(100.0, 100))
                .isInstanceOf(ArithmeticException.class);
    }
}