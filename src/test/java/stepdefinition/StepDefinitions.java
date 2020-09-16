package stepdefinition;

import com.google.common.io.Files;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pages.CreateIssues;
import pages.HomePage;
import pages.LoginPage;
import utils.WebDriverFactory;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class StepDefinitions {
  private WebDriver driver = null;

  @Before
  public void beforeCucumberScenario(Scenario scenario) {
    WebDriverFactory.createInstance("Chrome");
  }

  @After
  public void afterCucumberScenario(Scenario scenario) {
    if (scenario.getStatus().toString().contains("FAILED")) {
      try {
        takeScreenshot();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    WebDriverFactory.getDriver().close();
  }

  public void takeScreenshot() throws IOException {
    File scrFile = ((TakesScreenshot) WebDriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);
    File trgtFile = new File(System.getProperty("user.dir") + "//screenshots/screenshot.png");
    System.out.println("SAVING Screenshot to " + trgtFile.getAbsolutePath());
    trgtFile.getParentFile().mkdir();
    trgtFile.createNewFile();
    Files.copy(scrFile, trgtFile);
  }

  @Then("^I navigate to Jira Login Page$")
  public void navigateToLoginPage() {
    new LoginPage().navigateTo();
  }

  @Then("^I enter user name - \"(.*?)\"$")
  public void enterUserName(String userName) {
    new LoginPage().enterUserName(userName);
  }

  @Then("^I enter password - \"(.*?)\"$")
  public void enterPassword(String password) {
    new LoginPage().enterPassword(password);
  }

  @Then("^I click on the login button$")
  public void clickLoginButton() {
    new LoginPage().clickLogin();
  }

  @When("^I am on the Home Page$")
  public void atTheHomePage() {
    assert new HomePage().onPage();
  }

  @When("^I am on an error page$")
  public void onTheErrorPage() {
    assert new HomePage().messageError();
  }

  @Then("^I click on Create button$")
  public void clickButtonCreate() {
    new CreateIssues().clickButtonCreate();
  }

  @Then("^Create Issues for is opened$")
  public void waitToOpenCreate() {
    new HomePage().openCreateIssues();
  }

  @Then("^I fill all mandatory fields$")
  public void fillMandatoryFields() {
    new CreateIssues().mandatoryFields("Webinar (WEBINAR)", "Bug", "Bug", "VladKryvenko", "VladKryvenko found bug");
  }

  @Then("^An issues is create$")
  public void bushButtonCreate() {
    new CreateIssues().pushTheButtonCreate();
  }

  @Then("^The issues number is shown$")
  public void showsNumberIssues() {
    new HomePage().messageAddIssues();
  }

  @When("^I debug$")
  public void debug() {
    int a = 0;
  }
}
