package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.WebDriverFactory;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class HomePage {
  public boolean onPage(){
    WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), Duration.ofSeconds(10).getSeconds());
    return wait.until(presenceOfElementLocated(By.id("header-details-user-fullname"))).isDisplayed();
  }
  public boolean messageError (){
    WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), Duration.ofSeconds(5).getSeconds());
    return wait.until(presenceOfElementLocated(By.id("usernameerror"))).isDisplayed();
  }
  public boolean openCreateIssues (){
    WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), Duration.ofSeconds(5).getSeconds());
    return wait.until(presenceOfElementLocated(By.id("summary"))).isDisplayed();
  }
  public boolean messageAddIssues(){
    WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), Duration.ofSeconds(5).getSeconds());
    return wait.until(presenceOfElementLocated(By.className("issue-created-key"))).isDisplayed();
  }
}
