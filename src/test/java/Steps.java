import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class Steps {
    private static final String repository = "nikitooooos/Files";
    private static final String issue = "Welcome to issues!";

    @Step("Открываем главную страницу")
    public void openMainPage(){
        open("https://github.com");
    }

    @Step("Поиск репозитория")
    public void searchRepository(String repository){
        $(".search-input-container").click();
        $("#query-builder-test").click();
        $("#query-builder-test").sendKeys("nikitooooos/Files");
        $("#query-builder-test").submit();
    }

    @Step("Переходим по ссылке репозитория")
    public void clickOnRepository(String repository){
        $(linkText(this.repository)).click();
    }

    @Step("Открываем таб Issues")
    public void openIssue(){
        $("#issues-tab").click();
    }

    @Step("Проверяем наличие надписи")
    public void checkResult(String issue){
        $(withText(this.issue)).should(Condition.exist);
    }
}
