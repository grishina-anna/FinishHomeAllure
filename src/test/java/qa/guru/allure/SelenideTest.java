package qa.guru.allure;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class SelenideTest {

    @Test
            public void testIssueSearch(){
        SelenideLogger.addListener("allure", new AllureSelenide());
        open("https://github.com");
        $(".header-search-input").click();
        $(".header-search-input").sendKeys("grishina-anna/FinishHomeAllure");
        $(".header-search-input").submit();
        $(By.linkText("grishina-anna/FinishHomeAllure")).click();
        $(By.partialLinkText("Issues")).click();
        $(withText("11")).should(Condition.visible);
        sleep(3000);
    }

}
