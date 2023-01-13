import com.codeborne.selenide.Selenide;
import org.junit.Assert;
import org.junit.Test;

public class SberHealthTest extends BaseTest {
    private final static String BASE_URL = "https://front.mdannikov.docdoc.pro";
    private final static String SEARCH_STRING = "Акушер";
    @Test
    public void checkCorrectTitlePage() {
        MainPage mainPage = new MainPage(BASE_URL);
        mainPage.enterStringInSearchForm(SEARCH_STRING);
        DoctorListPage doctorListPage = new DoctorListPage();
        String title = doctorListPage.getTitlePage();
        Selenide.sleep(1000);
        Assert.assertTrue(title.contains(SEARCH_STRING));
    }
    @Test
    public void checkCorrectDoctorPrice(){
        //MainPage mainPage = new MainPage(BASE_URL);
        Selenide.open(BASE_URL+"/doctor");

    }
}
