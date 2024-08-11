package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

    public class TestBase {



        @BeforeAll
        static void beforeAll() {
            Configuration.browserSize = "1920x1080";
            //Configuration.browser = System.getProperty("browser", "chrome");
            //Configuration.browserVersion = System.getProperty("browserVersion", "126");
            //Configuration.pageLoadStrategy = "eager";
            Configuration.baseUrl = "https://www.psbank.ru";
            //Configuration.holdBrowserOpen = true;
            //Configuration.timeout = 50000;
            //Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                    "enableVNC", true,
                    "enableVideo", true
            ));
            Configuration.browserCapabilities = capabilities;
        }
        @BeforeEach

        void setUpBeforeEach() {
            SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        }
        @AfterEach

        void addAttachments() {
            Attach.screenshotAs("Last screenshot");
            Attach.pageSource();
            Attach.browserConsoleLogs();
            Attach.addVideo();
            Selenide.closeWebDriver();
        }
    }
