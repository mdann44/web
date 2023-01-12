import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;


//Здесь описываем все базовые методы для тестов
abstract public class BaseTest {
        public void setUp(){
        WebDriverManager.chromedriver().setup();
        Configuration.browser = "chrome";
        Configuration.driverManagerEnabled = true;//Присутствует библиотека webdrivermanager-её и будем использовать
        Configuration.browserSize = "1920x1200";
        Configuration.headless = false; //Будем ли мы видеть браузер во время теста?
        Configuration.browserVersion="110";
    }
    //Метод, запускаемый ПЕРЕД тестами
    @Before
    public void init() {
        setUp();//Инициализируем браузер
    }
    //Метод, запускаемый ПОСЛЕ тестов
    @After
    public void tearDown(){
        Selenide.close();//Закрываем браузер
    }

}
