package org.umssdiplo.automationv01.stepdefinitionproject.Accidents;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.umssdiplo.automationv01.core.customwebdriver.ManageDriver;

import java.util.concurrent.TimeUnit;

public class StepsDefRegisterAccidents {
    WebDriver driver = ManageDriver.getInstance().getWebDriver();
    @Given("^Accedo a la lista de Accidentes \"([^\"]*)\"$")
    public void accedoALaListaDeEmpleados(String link) {
        ManageDriver.getInstance().getWebDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        ManageDriver.getInstance().getWebDriver().manage().window().maximize();
        ManageDriver.getInstance().getWebDriver().navigate().to(link);
        WebDriverWait wait = new WebDriverWait(driver, 60);
        ManageDriver.getInstance().setWebDriverWait(wait);
    }
    @Then("^Selecciono Registrar a empleado accidentado$")
    public void seleccionoRegistrarAccidente(){
        WebElement createAccident = ((FirefoxDriver) driver).findElementById("registrar-empleado");
        createAccident.click();
    }
}
