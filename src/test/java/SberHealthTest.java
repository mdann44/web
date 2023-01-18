import com.codeborne.selenide.Selenide;
import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static com.codeborne.selenide.Selenide.$;
@RunWith(JUnitParamsRunner.class)
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
        @FileParameters("src/test/java/resources/sector.csv")
        public void checkCorrectDoctorSpeciality(String name, String rewrite_name) {
            Selenide.open(BASE_URL + "/doctor/" + rewrite_name);
            DoctorListPage doctorListPage = new DoctorListPage();
            doctorListPage.specAllDocInMiniCard(name);


    }
    //Selenide.sleep(3000);

}

