package techproed.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class AmazonStepDefinition {
    @Given("kullanici_amazon_sayfasina_gider")
    public void kullanici_amazon_sayfasina_gider() {
        Driver.getDriver().get(ConfigReader.getProperty("amazon_Url"));
        
    }

    @Then("arama_kutusunda_iphone_aratilir")
    public void arama_kutusunda_iphone_aratilir() {
        Driver.getDriver().findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);
        
    }

    @And("sayfayi_kapatir")
    public void sayfayi_kapatir() {
        Driver.closeDriver();
    }

    @And("arama_kutusunda_iphone_Selenium_aratir")
    public void arama_kutusunda_iphone_selenium_aratir() {
        Driver.getDriver().findElement(By.id("twotabsearchtextbox")).sendKeys("selenium", Keys.ENTER);
    }
}
