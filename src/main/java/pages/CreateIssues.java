package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.WebDriverFactory;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class CreateIssues {



 private By createLink = By.id("create_link");
  private By projectField = By.id("project-field");
  private By issueTypeField = By.id("issuetype-field");
  private By summary = By.id("summary");
  private By reporterField = By.id("reporter-field");
  private By buttonText = By.xpath("//a[contains(text(),'Text')]");
  private By descriptionField = By.id("description");
  private By createIssue = By.id("create-issue-submit");

  public void  clickButtonCreate (){
    try {
      Thread.sleep(Long.parseLong("5000"));
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    WebDriverFactory.getDriver().findElement(createLink).click();
  }
  public void mandatoryFields (String textProjectField,String textIssueType,String textSummery,String nameReporter,String textDescription){
    WebDriverFactory.getDriver().findElement(projectField).click();
    WebDriverFactory.getDriver().findElement(projectField).clear();
    WebDriverFactory.getDriver().findElement(projectField).sendKeys(textProjectField);
    WebDriverFactory.getDriver().findElement(projectField).sendKeys(Keys.TAB);
    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    WebDriverFactory.getDriver().findElement(issueTypeField).click();
    WebDriverFactory.getDriver().findElement(issueTypeField).clear();
    WebDriverFactory.getDriver().findElement(issueTypeField).sendKeys(textIssueType);
    WebDriverFactory.getDriver().findElement(issueTypeField).sendKeys(Keys.TAB);
    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    WebDriverFactory.getDriver().findElement(summary).sendKeys(textSummery);

    WebDriverFactory.getDriver().findElement(reporterField).click();
    WebDriverFactory.getDriver().findElement(reporterField).sendKeys(nameReporter);

    WebDriverFactory.getDriver().findElements(buttonText).get(1).click();

    WebDriverFactory.getDriver().findElement(descriptionField).sendKeys(textDescription);

  }

  public void pushTheButtonCreate (){
    WebDriverFactory.getDriver().findElement(createIssue).click();
  }
}

