import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;

public class DoctorListPage {
    private final SelenideElement titlePage = $x("//h1[@class='top-seo-text__title']");
    private final ElementsCollection actualPriceLabel = $$x("//span[@class='DoctorPrice__label_2zVL']");
    private final ElementsCollection collectionSpecDocMiniCard = $$x("//div[@data-test-id='doctor-list-page-card-details__specialities']");

    public final SelenideElement nextPage = $x("//a[@data-test-id='pagination__next']").shouldBe(visible);
    private final ElementsCollection pageNumButtonNotActive = $$x("//a[@class='button']");
    private final SelenideElement pageNumButtonActive = $x("//a[@class='button active']");

    /*
     * Возвращает заголовок страницы выдачи по специальности
     * */
    public String getTitlePage() {
        return titlePage.getText();
    }

    /*
     * Метод получения специальности в мини карточке врачей на выдаче.
     * Проверяет, что в мини анкетах всех врачей специальность
     * соответствует искомой (Все страницы)
     * */
    public void specAllDocInMiniCard(String searchString) {
        String finish_page_num = pageNumButtonNotActive.last().getText();//Получил номер последней страницы
        int finish_page_num_int = Integer.parseInt(finish_page_num);//Преобразовал String в int
        System.out.println(finish_page_num_int);
        for (int j = 72; j <= finish_page_num_int; j++) {//Цикл перебора всех страниц
            try {
                System.out.println(j);
                List<String> specDoc = new ArrayList<>();//Лист со всеми специальностями врачей с одной страницы
                for (int i = 0; i < collectionSpecDocMiniCard.size(); i++) {//Цикл, добавляющий спец-ти врачей в лист
                    specDoc.add(collectionSpecDocMiniCard.get(i).getText());
                }
                System.out.println(specDoc);
                for (int i = 0; i < specDoc.size(); i++) {//Цикл, проверяющий лист спец-тей на соответствие искомой
                    String listSpec = specDoc.get(i);
                    Assert.assertEquals(searchString, listSpec);
                }
                //Selenide.clearBrowserCookies();
                //Selenide.clearBrowserLocalStorage();

                paginationNext();
                //Если поймали ошибку отсутствия элемента, меняем URL и идем дальше
            } catch (com.codeborne.selenide.ex.ElementNotFound ex) {
                System.out.println(ex.getMessage() + " на странице " + j + " нет кнопки пагинации");
                String url = url();//Получил текущий URL
                String urlCut = url.substring(0, url.lastIndexOf('/') + 1);//Обрезали конец URL
                j++;//Увеличил счетчик, чтобы попасть на новую страницу
                Selenide.open(urlCut + j);
                j--;//Уменьшил счетчик, чтобы не ломать счетчик страниц у цикла
            }


        }
    }


    //specialityDoctorMiniCard.


    /*
     * Метод пагинации вперед*/
    public void paginationNext() {
        nextPage.scrollTo().click();
    }


}
