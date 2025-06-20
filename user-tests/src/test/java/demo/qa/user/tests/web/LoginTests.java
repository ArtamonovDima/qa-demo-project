package demo.qa.user.tests.web;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class LoginTests {

    @BeforeAll
    static void setup() {
        Configuration.baseUrl = "http://demo_frontend/";       // имя контейнера фронтенда
        Configuration.browserSize = "1920x1200";
        Configuration.remote = "http://selenoid:4444/wd/hub";
        Configuration.timeout = 10000;
        Configuration.browser = "chrome";
        Configuration.browserVersion = "125.0";
        Configuration.pageLoadStrategy = "eager";
//        Configuration.browserCapabilities = new ChromeOptions()
//                .addArguments("--enable-automation")
//                .addArguments("--no-sandbox")
//                .addArguments("--disable-extensions")
//                .addArguments("--disable-accelerated-2d-canvas")
//                .addArguments("--use-gl=angle");
//        Configuration.browserCapabilities.setCapability("enableVNC", true);  // ВАЖНО: должно быть true
//        Configuration.browserCapabilities.setCapability("enableVideo", false);
    }

    @Test
    void loginShouldSucceedAndShowUsers() {
        open("/");
        $("#username").setValue("admin");
        $("#password").setValue("admin123");
        $("button").click();
//        screenshot("after-login");
//        $x("//div[@id = 'app']/h2").shouldHave(text("User List"));
    }
}