package demo.qa.user.tests.web;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.Step;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class LoginTests {

    @BeforeAll
    static void setup() {
        Configuration.baseUrl = "http://demo_frontend";
//        Configuration.baseUrl = "http://localhost:8080";
        Configuration.browserSize = "1920x1200";
        Configuration.remote = "http://selenoid:4444/wd/hub";
        Configuration.timeout = 10000;
        Configuration.browser = "chrome";
        Configuration.browserVersion = "125.0";
        Configuration.pageLoadStrategy = "eager";
        Map<String, Boolean> options = new HashMap<>();
        options.put("enableVNC", true);
        options.put("enableVideo", false);
        options.put("enableLog", true);

        Configuration.browserCapabilities.setCapability("selenoid:options", options);
    }

    @Test
    @Step("Success login")
    void loginShouldSucceedAndShowUsers() {
        open("/");
        $("#username").setValue("admin");
        $("#password").setValue("admin123");
        $("button").click();
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        $x("//div[@id = 'app']/h2").shouldHave(text("User List"));
    }
}