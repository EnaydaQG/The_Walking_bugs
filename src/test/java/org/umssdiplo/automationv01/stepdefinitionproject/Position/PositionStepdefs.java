package org.umssdiplo.automationv01.stepdefinitionproject.Position;

import cucumber.api.CucumberOptions;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.umssdiplo.automationv01.core.customwebdriver.ManageDriver;
import org.umssdiplo.automationv01.core.utils.CommonEvents;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class PositionStepdefs {

    ManageDriver manageDriver = ManageDriver.getInstance();
    WebDriver driver = manageDriver.getWebDriver();

    @Given("^Accedo a la lista de posiciones \"([^\"]*)\"$")
    public void accedoALaListaDePosiciones(String link) throws Throwable {
        ManageDriver.getInstance().getWebDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        ManageDriver.getInstance().getWebDriver().manage().window().maximize();
        ManageDriver.getInstance().getWebDriver().navigate().to(link);
        WebDriverWait wait = new WebDriverWait(driver, 60);
        ManageDriver.getInstance().setWebDriverWait(wait);;
    }

    @Then("^Hago click en Crear Cargo$")
    public void hagoClickEnCrearCargo() {
        WebElement create = ((FirefoxDriver) driver).findElementById("btn-create");
        manageDriver.getWebDriverWait().until(ExpectedConditions.visibilityOf(create));
        create.click();
    }

    @And("^LLeno los datos para posición con$")
    public void llenoLosDatosCon(DataTable datos) {
        manageDriver.setExplicitTimeWait(60);
        manageDriver.setImplicitTimeWait(60);
        List<List<String>> values = datos.raw();

        String code = values.get(1).get(0);
        String name = values.get(1).get(1);
        String higherWorkPosition = values.get(1).get(2);
        String area = values.get(1).get(3);
        String process = values.get(1).get(4);
        String purpose = values.get(1).get(5);

        WebElement codeElement = ((FirefoxDriver) driver).findElementById("code");
        manageDriver.getWebDriverWait().until(ExpectedConditions.visibilityOf(codeElement));
        CommonEvents.setInputField(codeElement, code);

        WebElement nameElement = ((FirefoxDriver) driver).findElementById("name");
        manageDriver.getWebDriverWait().until(ExpectedConditions.visibilityOf(nameElement));
        CommonEvents.setInputField(nameElement, name);

        WebElement higherWorkPositionElement = ((FirefoxDriver) driver).findElement(By.id("higherWorkPosition"));
        higherWorkPositionElement.click();
        WebElement option = ((FirefoxDriver) driver)
                .findElement(By.xpath("//span[contains(@class,'mat-option-text')] [contains(text(),'"+higherWorkPosition+"')]"));
        option.click();

        WebElement areaElement = ((FirefoxDriver) driver).findElement(By.id("area"));
        areaElement.click();
        WebElement areaoption = ((FirefoxDriver) driver)
                .findElement(By.xpath("//span[contains(@class,'mat-option-text')] [contains(text(),'"+area+"')]"));
        areaoption.click();

        WebElement processElement = ((FirefoxDriver) driver).findElementById("process");
        manageDriver.getWebDriverWait().until(ExpectedConditions.visibilityOf(processElement));
        CommonEvents.setInputField(processElement, process);

        WebElement purposeElement = ((FirefoxDriver) driver).findElementById("purpose");
        manageDriver.getWebDriverWait().until(ExpectedConditions.visibilityOf(purposeElement));
        CommonEvents.setInputField(purposeElement, purpose);
    }

    @Then("^Hago click en guardar cambios para posición$")
    public void hagoClickEnGuardarCambios() {
        manageDriver.setImplicitTimeWait(60);
        WebElement create = ((FirefoxDriver) driver).findElementById("btn-save");
        manageDriver.getWebDriverWait().until(ExpectedConditions.visibilityOf(create));
        create.click();
    }

    @Then("^Verificar los datos de la position nueva$")
    public void verificarLosDatosDeLaPositionNueva(DataTable datos){
        manageDriver.setExplicitTimeWait(60);
        manageDriver.setImplicitTimeWait(60);
        List<List<String>> values = datos.raw();

        String expectedName = values.get(1).get(1);
        WebElement nameElement = ((FirefoxDriver) driver)
                .findElement(By.xpath("//span[contains(@class,'mat-button-wrapper')] [contains(text(),'"+expectedName+"')]"));
        nameElement.click();
        WebElement nameNew = ((FirefoxDriver) driver).findElementById("name");
        String result = CommonEvents.getFromElement(nameNew, "ng-reflect-model");

        Assert.assertEquals(result,expectedName);
    }
    @And("^Verifico que la position no existe$")
    public void verificoQueLaPositionNoExiste(DataTable datos) {
        manageDriver.setExplicitTimeWait(60);
        manageDriver.setImplicitTimeWait(60);
        List<List<String>> values = datos.raw();
        String expectedName = values.get(1).get(0);
        WebElement nameElement = ((FirefoxDriver) driver)
                .findElement(By.xpath("//span[contains(@class,'mat-button-wrapper')]"));
        manageDriver.getWebDriverWait().until(ExpectedConditions.visibilityOf(nameElement));
        String result = CommonEvents.getFromElement(nameElement,"mat-button-wrapper");
        if(result == null)
            result="NotFound";
        Assert.assertNotEquals(result,expectedName);
    }
    @Then("^Hago click en eliminar position$")
    public void hagoClickEnEliminarPosition() {
        WebElement deleteBtn = driver.findElement(By.id("btn-delete"));
        manageDriver.getWebDriverWait().until(ExpectedConditions.visibilityOf(deleteBtn));
        CommonEvents.clickButton(deleteBtn);
    }


    /*@Then("^Cierro el navegador$")
    public void cierroElNavegador() {
        driver.close();
    }*/
}
