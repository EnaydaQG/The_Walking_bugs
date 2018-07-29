package org.umssdiplo.automationv01.stepdefinitionproject.Accidents;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.umssdiplo.automationv01.core.customwebdriver.ManageDriver;
import org.umssdiplo.automationv01.core.utils.CommonEvents;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TypeAccidents {
    ManageDriver manageDriver = ManageDriver.getInstance();
    WebDriver driver = ManageDriver.getInstance().getWebDriver();
    @Given("^Accedo al campo tipos de Accidentes \"([^\"]*)\"$")
    public void accedoAlTipoAccidentes(String link) {
        ManageDriver.getInstance().getWebDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        ManageDriver.getInstance().getWebDriver().manage().window().maximize();
        ManageDriver.getInstance().getWebDriver().navigate().to(link);
        WebDriverWait wait = new WebDriverWait(driver, 60);
        ManageDriver.getInstance().setWebDriverWait(wait);
    }
    @And("^Llenando los campos con$")
    public void llenoLosDatosCon(DataTable datos) {
        manageDriver.setExplicitTimeWait(60);
        manageDriver.setImplicitTimeWait(60);
        List<List<String>> values = datos.raw();
        String nameTypeAccident = values.get(1).get(0);
        String codeTypeAccident = values.get(1).get(1);
        WebElement nameTypeAccident1 = ((FirefoxDriver) driver).findElementById("nameTypeAccident");
        manageDriver.getWebDriverWait().until(ExpectedConditions.visibilityOf(nameTypeAccident1));
        CommonEvents.setInputField(nameTypeAccident1, nameTypeAccident);

        WebElement codeTypeAccident1 = ((FirefoxDriver) driver).findElementById("codeTypeAccident");
        manageDriver.getWebDriverWait().until(ExpectedConditions.visibilityOf(codeTypeAccident1));
        CommonEvents.setInputField(codeTypeAccident1, codeTypeAccident);
    }
    @Then("^Hago click en editar$")
    public void HagoClickEneditar() {
        WebElement editar = ((FirefoxDriver) driver).findElementById("editar");
        manageDriver.getWebDriverWait().until(ExpectedConditions.visibilityOf(editar));
        editar.click();
    }
}
