package org.umssdiplo.automationv01.stepdefinitionproject.TypeEquipment;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.umssdiplo.automationv01.core.customwebdriver.ManageDriver;
import org.umssdiplo.automationv01.core.utils.CommonEvents;


import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertFalse;


public class TypeEquipmentList {
    ManageDriver manageDriver = ManageDriver.getInstance();
    WebDriver driver = manageDriver.getWebDriver();

    @Given("^Accedo a la lista de tipo de Equipos \"([^\"]*)\"$")
    public void accedoALaListaDeEmpleados(String link) {
        ManageDriver.getInstance().getWebDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        ManageDriver.getInstance().getWebDriver().manage().window().maximize();
        ManageDriver.getInstance().getWebDriver().navigate().to(link);
        WebDriverWait wait = new WebDriverWait(driver, 60);
        ManageDriver.getInstance().setWebDriverWait(wait);
    }

    @Then("^Selecciono Add$")
    public void seleccionoAddTypeEquipment(){
        WebElement createTypeEquipment = ((FirefoxDriver) driver).findElementById("butonAdd");
        manageDriver.getWebDriverWait().until(ExpectedConditions.visibilityOf(createTypeEquipment));
        createTypeEquipment.click();
    }

    @Then("^Hago click en Save$")
    public void hagoClickEnSaveTypeEquipment() {
        WebElement save = ((FirefoxDriver) driver).findElementById("butonSave");
        manageDriver.getWebDriverWait().until(ExpectedConditions.visibilityOf(save));
        save.click();
    }

    @Then("^Ingreso a editar el primer tipo de Equipo creado$")
    public void editoElPrimerTipoDeEquipoCreado() {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id=\"nameType\"][last()]")));
        manageDriver.getWebDriverWait().until(ExpectedConditions.visibilityOf(element));
         CommonEvents.jsClickElement(driver.findElement(By.id("butonEdit")));


    }

    @Then("^Hago click en Delete$")
    public void hagoClickEnDeleteTypeEquipment() {
        WebElement delete = ((FirefoxDriver) driver).findElementById("butonDelete");
        manageDriver.getWebDriverWait().until(ExpectedConditions.visibilityOf(delete));
        delete.click();
    }


   @Then("^Cierro el navegador$")
    public void cierroElNavegador() {
        driver.close();
    }


}
