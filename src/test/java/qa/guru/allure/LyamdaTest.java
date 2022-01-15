package qa.guru.allure;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class LyamdaTest {

    static final String REPOSITORY = "grishina-anna/FinishHomeAllure";
    private static final int NUMBER = 11;

    @Test
    public void testIssueSearch() {
        step("Открываем главную страницу", () -> {
            open("https://github.com");
        });

        step("Ищем репозиторий" + REPOSITORY, () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(REPOSITORY);
            $(".header-search-input").submit();
        });

        step("Переходим в найденный репозиторий" + REPOSITORY, () -> {
            $(By.linkText("grishina-anna/FinishHomeAllure")).click();
        });

        step("Открываем tab Issues", () -> {
            $(By.partialLinkText("Issues")).click();
        });

        step("Проверяем наличие Issues с неверным номером " + NUMBER, () -> {
            $(withText("#" + NUMBER)).should(Condition.visible);
        });
    }
}

