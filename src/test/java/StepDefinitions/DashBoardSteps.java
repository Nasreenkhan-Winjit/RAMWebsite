package StepDefinitions;

import Runner.TestBase;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.PageObjectManager;

public class DashBoardSteps extends TestBase {
    public DashBoardSteps() {
        pageObjectManager=new PageObjectManager(driver);
    }
// private PageObjectManager pageObjectManager;

    @And("Logged out")
    public void loggedOut() {
        pageObjectManager.getDashboard().clickLogOut();
    }

    @Then("User {string} registered and navigate to dashboard")
    public void userShouldNavigateToDashboard(String firstname) {
        String username = firstname;
        System.out.println(username);
        Assert.assertTrue(pageObjectManager.getDashboard().isUserLogged(username));
    }

    public void userRegisteredAndNavigateToDashboard(String arg0) {
    }
    @Then("Get error message and user User should not navigate to dashboard")
    public void getErrorMessageAndUserUserShouldNotNavigateToDashboard() {

    }
}
