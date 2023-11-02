package seminars.fourth.database;

/*
Задание №6
Вам требуется протестировать класс, который обрабатывает запросы к базе данных.
Условие: У вас есть класс Database с методом public List<String> query(String sql),
который выполняет SQLзапрос и возвращает результат.
Вам необходимо проверить правильность работы класса DataProcessor, который использует Database для
выполнения запроса и обработки результатов.
 */

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.*;

class DataProcessorTest {

    @Test
    void testDataProcessor() {
        Database db = mock(Database.class);
        DataProcessor dP = new DataProcessor(db);
        when(db.query(anyString())).thenReturn(Arrays.asList("строка1", "строка2"));

        List<String> result = db.query("строка");

        verify(db).query("строка");
        assertThat(result).isNotEmpty().hasSize(2).isEqualTo(Arrays.asList("строка1", "строка2"));



    }
}