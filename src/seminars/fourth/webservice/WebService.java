package seminars.fourth.webservice;

public class WebService {

    HTTPClient httpClient;

    public WebService(HTTPClient httpClient) {
        this.httpClient = httpClient;
    }

    void getHTTPRequest(String url) {
        System.out.println(httpClient.get(url));
    }
}
