package seminars.fourth.webservice;

/*
Задание №7
Вам нужно написать тест с использованием моков для класса, который выполняет HTTP-запросы.
Условие: У вас есть класс HttpClient с методом public String get(String url), который выполняет
HTTP-запрос и возвращает результат. Вам необходимо проверить правильность работы класса
WebService, который использует HttpClient для получения данных с веб-сайта.
*/

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class WrbServiceTest {
    @Test
    void httpRequestTest() {
        HTTPClient httpClient = mock(HTTPClient.class);
        WebService webService = new WebService(httpClient);
        when(httpClient.get(anyString())).thenReturn("Site");
        String url = "pam.com";

        webService.getHTTPRequest(url);

        verify(httpClient, times(1)).get(anyString());
    }
}
