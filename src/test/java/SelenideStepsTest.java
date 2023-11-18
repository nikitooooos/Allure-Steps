import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class SelenideStepsTest {
    private static final String repository = "nikitooooos/Files";
    private static final String issue = "Welcome to issues!";

    @Test
    public void stepsTest(){
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем главную страницу", () -> {
            open("https://github.com");
        });
        step("Поиск репозитория" + repository, () -> {
            $(".search-input-container").click();
            $("#query-builder-test").click();
            $("#query-builder-test").sendKeys("nikitooooos/Files");
            $("#query-builder-test").submit();
        });
        step("Переходим по ссылке репозитория" + repository, () -> {
            $(linkText(repository)).click();
        });
        step("Открываем таб Issues", () -> {
            $("#issues-tab").click();
        });
        step("Проверяем наличие надписи" + issue, () -> {
            $(withText(issue)).should(Condition.exist);
        });
    }
}
