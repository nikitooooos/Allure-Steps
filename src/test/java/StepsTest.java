import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

public class StepsTest {

    private static final String repository = "nikitooooos/Files";
    private static final String issue = "Welcome to issues!";

    @Test
    public void stepTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        Steps steps = new Steps();

        steps.openMainPage();
        steps.searchRepository(repository);
        steps.clickOnRepository(repository);
        steps.openIssue();
        steps.checkResult(issue);
    }


}