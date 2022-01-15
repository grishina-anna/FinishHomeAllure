package qa.guru.allure;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.nio.charset.StandardCharsets;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static javax.swing.text.html.parser.DTDConstants.NUMBER;
import static qa.guru.allure.LyamdaTest.REPOSITORY;

public class WebSteps {

    @Step("Открываем главную страницу")
    public void openMainPage() {
        open("https://github.com");
    }

    @Step("Ищем репозиторий {repository}")
    public void searchForRepository(String repository) {
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(repository);
        $(".header-search-input").submit();
    }

    @Step("Переходим в найденный репозиторий {repository}")
    public void openRepositoryPage(String repository) {
        $(By.linkText("grishina-anna/FinishHomeAllure")).click();
    }

    @Step("Открываем tab Issues")
    public void openIssuesTab(){
        attachPageSource();
        $(By.partialLinkText("Issues")).click();
    }
    @Step("Проверяем наличие Issues с неверным номером {number}")
    public void shouldSeeIssuesWithNumber(int number) {
        $(withText("#" + number)).should(Condition.visible);
    }

    @Attachment(value = "Screenhot", type = "text/html", fileExtension = "html")
    public byte[] attachPageSource() {
        return WebDriverRunner.source().getBytes(StandardCharsets.UTF_8);
    }

    @Owner("grishinaaf")
    @Feature("Issues")
    @Story("Проверка названия Issue в репозитории через Web-интерфейс")
    @DisplayName("Проверка названия Issue в репозитории через Web-интерфейс")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Github", url = "http://github.com")
    @Test

    public void annotatedStepsTest() {
        WebSteps steps = new WebSteps();
        steps.openMainPage();
        steps.searchForRepository(REPOSITORY);
        steps.openRepositoryPage(REPOSITORY);
        steps.openIssuesTab();
        steps.shouldSeeIssuesWithNumber(NUMBER);

    }
}
