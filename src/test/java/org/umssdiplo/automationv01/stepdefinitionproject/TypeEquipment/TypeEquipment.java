package org.umssdiplo.automationv01.stepdefinitionproject.TypeEquipment;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
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

import static org.testng.AssertJUnit.assertFalse;


public class TypeEquipment {
    ManageDriver manageDriver = ManageDriver.getInstance();
    WebDriver driver = manageDriver.getWebDriver();

    @And("^Verifico que los datos del tipo de Equipo sean$")
    public void verificoSiEsElTipoDeEquipoCreado(DataTable datos) {

        manageDriver.setImplicitTimeWait(60);
        List<List<String>> values = datos.raw();
        String expectedName = values.get(1).get(0);
        String expectedDescription = values.get(1).get(1);

        WebElement nombre = ((FirefoxDriver) driver).findElementById("mat-input-flex mat-form-field-flex");
        manageDriver.getWebDriverWait().until(ExpectedConditions.visibilityOf(nombre));
        String result = CommonEvents.getFromElement(nombre, "ng-reflect-model");
        Assert.assertEquals(result,expectedName);

        WebElement descripcion = ((FirefoxDriver) driver).findElementById("mat-input-wrapper mat-form-field-wrapper");
        manageDriver.getWebDriverWait().until(ExpectedConditions.visibilityOf(descripcion));
        result = CommonEvents.getFromElement(descripcion, "ng-reflect-model");
        Assert.assertEquals(result,expectedDescription);


    }
    @And("^LLeno los datos con$")
    public void llenoLosDatosCon(DataTable datos) {
        manageDriver.setExplicitTimeWait(60);
        manageDriver.setImplicitTimeWait(60);
        List<List<String>> values = datos.raw();

        String name = values.get(1).get(0);
        String descriptionTypeEquipment = values.get(1).get(1);

        WebElement nombre = ((FirefoxDriver) driver).findElementById("name");
        manageDriver.getWebDriverWait().until(ExpectedConditions.visibilityOf(nombre));
        CommonEvents.setInputField(nombre, name);

        WebElement descripcion = ((FirefoxDriver) driver).findElementById("descriptionTypeEquipment");
        manageDriver.getWebDriverWait().until(ExpectedConditions.visibilityOf(descripcion));
        CommonEvents.setInputField(descripcion, descriptionTypeEquipment);

    }



}
