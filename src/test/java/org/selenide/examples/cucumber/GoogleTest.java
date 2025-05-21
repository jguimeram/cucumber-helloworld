package org.selenide.examples.cucumber;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.junit.TextReport;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestRule;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty", "html:target/cucumber.html", "json:target/cucumber.json"})
public class GoogleTest {
  @Rule
  public TestRule report = new TextReport().onFailedTest(true).onSucceededTest(true);

  @Before
  public void setUp() {
    Configuration.reportsFolder = "target/surefire-reports";
	Configuration.browser = "ie";
  }
}

