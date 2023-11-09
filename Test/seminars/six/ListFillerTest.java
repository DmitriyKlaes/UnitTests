package seminars.six;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ListFillerTest {

    ListFiller listFiller;

    @BeforeEach
    void setUp() {
        listFiller = new ListFiller();
    }

    @Test
    void fillListRandomNumbersSizeTest() {
        List<Integer> integerList = new ArrayList<>();
        int size = 3;
        int bottomLimit = 1;
        int upperLimit = 10;

        listFiller.fillListRandomNumbers(integerList, size, bottomLimit, upperLimit);

        assertEquals(integerList.size(), size);
    }

    @Test
    void fillListRandomNumbersValidateContentTest() {
        List<Integer> integerList = new ArrayList<>();
        int size = 100;
        int bottomLimit = 1;
        int upperLimit = 10;

        listFiller.fillListRandomNumbers(integerList, size, bottomLimit, upperLimit);

        for (Integer integer : integerList) {
            assertTrue(integer >= bottomLimit && integer <= upperLimit);
        }
    }

    @Test
    void fillListRandomNumbersNullArgumentTest() {
        List<Integer> integerList = null;
        int size = 3;
        int bottomLimit = 1;
        int upperLimit = 10;

        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () ->
                        listFiller.fillListRandomNumbers(integerList, size, bottomLimit, upperLimit),
                "Ожидалось исключение IllegalArgumentException");

        assertEquals("Список не может быть null", thrown.getMessage());
    }

    @Test
    void fillListRandomNumbersWrongSizeTest() {
        List<Integer> integerList = new ArrayList<>();
        int size = 0;
        int bottomLimit = 1;
        int upperLimit = 10;

        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () ->
                        listFiller.fillListRandomNumbers(integerList, size, bottomLimit, upperLimit),
                "Ожидалось исключение IllegalArgumentException");

        assertEquals("Размер списка не может быть меньше 1", thrown.getMessage());
    }

    @Test
    void fillListRandomNumbersWrongLimitsTest() {
        List<Integer> integerList = new ArrayList<>();
        int size = 3;
        int bottomLimit = 10;
        int upperLimit = 10;

        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () ->
                        listFiller.fillListRandomNumbers(integerList, size, bottomLimit, upperLimit),
                "Ожидалось исключение IllegalArgumentException");

        assertEquals("Нижняя граница должна быть меньше верхней границы", thrown.getMessage());
    }
}
