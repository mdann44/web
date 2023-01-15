import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;


/*
* Главная страница яндекс маркет
* */
public class MainPage {
    private final SelenideElement openSearchForm = $x("//div[@data-test-id='search_input']");//Локатор открытия поля поиска
    private final SelenideElement inputSearchForm2 = $x("//input[@placeholder='Врач, клиника, болезнь, услуга']");//Локатор ввода поля поиска
    private final SelenideElement searchButton = $x("//button[@data-test-id='search_button']");
    private final SelenideElement sortingPriceButton =$x("//*[@id='adaptive_page']/div/section/section/div/div[7]/div[2]/div[2]/div[2]/div/div/div");
    public MainPage(String url){//Конструктор для передачи аргумента при инициализации класса гл. страницы
        Selenide.open(url);
    }
    //Метод ввода в поле поиска.
    /*
    *В поле поиска передаем текст и, нажимаем ENTER*/
    public void enterStringInSearchForm(String searchString){
        openSearchForm.click();
        inputSearchForm2.setValue(searchString);
        Selenide.sleep(1000);
        inputSearchForm2.sendKeys(Keys.ENTER);
        searchButton.click();

    }


}
