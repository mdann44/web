import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class DoctorListPage {
    private final SelenideElement titlePage = $x("//h1[@class='top-seo-text__title']");

    /*
    * Возвращает заголовок страницы выдачи по специальности
    * */
    public String getTitlePage() {
        return titlePage.getText();
    }
}
