import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$;

public class SearchPage {
    private final SelenideElement sortingPriceButton = $("[data-autotest-id=aprice]");//Локатор кнопки сортировки по цене

    public void sortingPrice(){
        sortingPriceButton.sendKeys(Keys.ENTER);
    }
}
