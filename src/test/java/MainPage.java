import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$;


/*
* Главная страница яндекс маркет
* */
public class MainPage {
    private final SelenideElement searchForm = $("#header-search");//Локатор поля поиска
    public MainPage(String url){//Конструктор для передачи аргумента при инициализации класса гл. страницы
        Selenide.open(url);
    }
    //Метод ввода в поле поиска.
    /*В поле поиска передаем текст и, нажимаем ENTER*/
    public void enterStringInSearchForm(String searchString){
        searchForm.setValue(searchString);
        searchForm.sendKeys(Keys.ENTER);

    }

}
