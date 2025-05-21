package org.selenide.examples.cucumber;

import com.codeborne.selenide.Configuration;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.screenshot;
import static com.codeborne.selenide.CollectionCondition.sizeGreaterThanOrEqual;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class GoogleSearchStepDefinitions {
  static boolean primerRetraso = false;	
	
  @Given("an open browser with bing.com")
  public void openGoogleSearch() {
    Configuration.reportsFolder = "target/surefire-reports";
    open("https://bing.com/");
	
	// RETRASO PARA QUE ME DÉ TIEMPO A SUBIR LA PANTALLA AL OTRO MONITOR
	if (!primerRetraso)
	{
		primerRetraso = true;
		try { Thread.sleep(5000); } catch(Exception e) {}
	}
  }

  @When("a keyword {string} is entered in input field")
  public void enterKeyword(String keyword) {
    $(By.name("q")).val(keyword).pressEnter();
	screenshot(keyword);
  }

  @Then("at least top {int} matches should be shown")
  public void topTenMatchesShouldBeShown(int resultsCount) {
    $$(".b_algo").shouldHave(sizeGreaterThanOrEqual(resultsCount));
  }

  @Then("the first one should contain {string}")
  public void theFirstOneShouldContainKeyword(String expectedText) {
    $(".b_algo").shouldHave(text(expectedText));
  }
}
