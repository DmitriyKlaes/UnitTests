package seminars.six;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ListAverageCompareTest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    ListAverageCompare listAverageCompare;

    @BeforeEach
    void setUp() {
        listAverageCompare = new ListAverageCompare();
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    void compareAverageNumberListFirstBiggerTest() {
        List<Integer> firstList = new ArrayList<>(Arrays.asList(9, 9, 9));
        List<Integer> secondList = new ArrayList<>(Arrays.asList(1, 1, 1));
        String expectedMessage = "Первый список имеет большее среднее значение";

        listAverageCompare.compareAverageNumberList(firstList, secondList);
        assertEquals(expectedMessage, outputStreamCaptor.toString().trim());
    }

    @Test
    void compareAverageNumberListSecondBiggerTest() {
        List<Integer> firstList = new ArrayList<>(Arrays.asList(1, 1, 1));
        List<Integer> secondList = new ArrayList<>(Arrays.asList(9, 9, 9));
        String expectedMessage = "Второй список имеет большее среднее значение";

        listAverageCompare.compareAverageNumberList(firstList, secondList);
        assertEquals(expectedMessage, outputStreamCaptor.toString().trim());
    }

    @Test
    void compareAverageNumberListSameValuesTest() {
        List<Integer> firstList = new ArrayList<>(Arrays.asList(9, 9, 9));
        List<Integer> secondList = new ArrayList<>(Arrays.asList(9, 9, 9));
        String expectedMessage = "Средние значения равны";

        listAverageCompare.compareAverageNumberList(firstList, secondList);
        assertEquals(expectedMessage, outputStreamCaptor.toString().trim());
    }

    @Test
    void compareAverageNumberListNullArgumentTest() {
        List<Integer> firstList = null;
        List<Integer> secondList = new ArrayList<>(Arrays.asList(9, 9, 9));

        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () ->
                        listAverageCompare.compareAverageNumberList(firstList, secondList),
                "Ожидалось исключение IllegalArgumentException");

        assertEquals("Список не может быть null", thrown.getMessage());
    }

    @Test
    void compareAverageNumberListEmptyArgumentTest() {
        List<Integer> firstList = new ArrayList<>();
        List<Integer> secondList = new ArrayList<>(Arrays.asList(9, 9, 9));

        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () ->
                        listAverageCompare.compareAverageNumberList(firstList, secondList),
                "Ожидалось исключение IllegalArgumentException");

        assertEquals("Список не может быть пустым", thrown.getMessage());
    }
}
