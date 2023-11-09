package seminars.six;

import java.util.List;

public class ListAverageCompare {

    public void compareAverageNumberList(List<Integer> firstList, List<Integer> secondList) {
        if (getListAverage(firstList) > getListAverage(secondList)) {
            System.out.println("Первый список имеет большее среднее значение");
        } else if (getListAverage(firstList) < getListAverage(secondList)) {
            System.out.println("Второй список имеет большее среднее значение");
        } else {
            System.out.println("Средние значения равны");
        }
    }

    private int getListAverage(List<Integer> list) {
        if (list == null) {
            throw new IllegalArgumentException("Список не может быть null");
        }
        if (list.isEmpty()) {
            throw new IllegalArgumentException("Список не может быть пустым");
        }
        int average = 0;
        for (Integer integer : list) {
            average += integer;
        }
        return average;
    }
}
