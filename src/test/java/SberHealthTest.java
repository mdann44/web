import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class SberHealthTest extends BaseTest {
    protected final static String BASE_URL = "https://front.mdannikov.docdoc.pro";
    private final static String SEARCH_STRING = "Акушер";



    /*
    * Тест проверяет, что в заголовке результатов поиска врачей по специальности
    * присутствует название искомой специальности*/
    @Test
    public void checkCorrectTitlePage() {
        MainPage mainPage = new MainPage(BASE_URL);
        mainPage.enterStringInSearchForm(SEARCH_STRING);
        DoctorListPage doctorListPage = new DoctorListPage();
        String title = doctorListPage.getTitlePage();
        Selenide.sleep(1000);
        Assert.assertTrue(title.contains(SEARCH_STRING));
    }
    /*
    * Тест проверяет, что специальность всех врачей на странице, найденных по специальности
    * соответствует искомой специальности*/
    @Test
    public void checkCorrectDoctorSpeciality(){
        Selenide.open(BASE_URL+"/doctor/akusher/page/72");
        DoctorListPage doctorListPage = new DoctorListPage();
        doctorListPage.specAllDocInMiniCard(SEARCH_STRING);

        //Selenide.sleep(3000);

    }
}
