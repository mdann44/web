import org.junit.Test;

public class YandexMarketTest extends BaseTest {
    private final static String BASE_URL = "https://market.yandex.ru";
    private final static String SEARCH_STRING = "iPhone 13";
    @Test
    public void checkCorrectPrice(){
        MainPage mainPage = new MainPage(BASE_URL);
        mainPage.enterStringInSearchForm(SEARCH_STRING);

    }
}
