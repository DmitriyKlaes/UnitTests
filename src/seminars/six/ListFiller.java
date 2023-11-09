package seminars.six;

import java.util.List;
import java.util.Random;

public class ListFiller {

    private static final Random rnd = new Random();

    public void fillListRandomNumbers(List<Integer> listForFill, int listSize, int bottomLimit, int upperLimit) {
        if (listForFill == null) {
            throw new IllegalArgumentException("Список не может быть null");
        }
        if (listSize < 1) {
            throw new IllegalArgumentException("Размер списка не может быть меньше 1");
        }
        if (bottomLimit >= upperLimit) {
            throw new IllegalArgumentException("Нижняя граница должна быть меньше верхней границы");
        }
        for (int i = 0; i < listSize; i++) {
            listForFill.add(rnd.nextInt(bottomLimit, upperLimit + 1));
        }
    }
}
