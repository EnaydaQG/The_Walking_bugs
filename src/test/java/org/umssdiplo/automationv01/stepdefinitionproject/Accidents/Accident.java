package org.umssdiplo.automationv01.stepdefinitionproject.Accidents;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.umssdiplo.automationv01.core.customwebdriver.ManageDriver;
import org.umssdiplo.automationv01.core.utils.CommonEvents;

import java.util.List;

public class Accident {

    ManageDriver manageDriver = ManageDriver.getInstance();
    WebDriver driver = manageDriver.getWebDriver();
    @And("^Lleno los campos con los siguentes datos del accidente$")
    public void llenoLosDatosCon(DataTable datos) {
        manageDriver.setExplicitTimeWait(60);
        manageDriver.setImplicitTimeWait(60);
        List<List<String>> values = datos.raw();
        String tituloAccidente = values.get(1).get(0);
        String lugarAccidente = values.get(1).get(1);
        String grabedadAccidente = values.get(1).get(2);
        String descripcionAccidente = values.get(1).get(3);
        String fechaAccidente = values.get(1).get(4);
        String horaAccidente = values.get(1).get(5);
        String TipoAccidente = values.get(1).get(6);
        String Area = values.get(1).get(7);
        WebElement nombre = ((FirefoxDriver) driver).findElementById("nameAccidentado");
        manageDriver.getWebDriverWait().until(ExpectedConditions.visibilityOf(nombre));
        CommonEvents.setInputField(nombre, tituloAccidente);

        WebElement placeAccident = ((FirefoxDriver) driver).findElementById("place_accident");
        manageDriver.getWebDriverWait().until(ExpectedConditions.visibilityOf(placeAccident));
        CommonEvents.setInputField(placeAccident, lugarAccidente);

        WebElement gravityAccident = ((FirefoxDriver) driver).findElementById("gravity_accident");
        manageDriver.getWebDriverWait().until(ExpectedConditions.visibilityOf(gravityAccident));
        CommonEvents.setInputField(gravityAccident, grabedadAccidente);

        WebElement descriptionAccident = ((FirefoxDriver) driver).findElementById("description_accident");
        manageDriver.getWebDriverWait().until(ExpectedConditions.visibilityOf(descriptionAccident));
        CommonEvents.setInputField(descriptionAccident,descripcionAccidente);

        WebElement dateAccident = ((FirefoxDriver) driver).findElementById("date_accident");
        manageDriver.getWebDriverWait().until(ExpectedConditions.visibilityOf(dateAccident));
        CommonEvents.setInputField(dateAccident, fechaAccidente);

        WebElement hour_accident = ((FirefoxDriver) driver).findElementById("hour_accident");
        manageDriver.getWebDriverWait().until(ExpectedConditions.visibilityOf(hour_accident));
        CommonEvents.selectDropdownOption(hour_accident, horaAccidente);

        WebElement accidentTypeId = ((FirefoxDriver) driver).findElementById("accidentTypeId");
        manageDriver.getWebDriverWait().until(ExpectedConditions.visibilityOf(accidentTypeId));
        CommonEvents.selectDropdownOption(accidentTypeId, TipoAccidente);

        WebElement areaId = ((FirefoxDriver) driver).findElementById("areaId");
        manageDriver.getWebDriverWait().until(ExpectedConditions.visibilityOf(areaId));
        CommonEvents.selectDropdownOption(areaId, Area);
    }
    @And("^Verifico que los datos sean los ingresados$")
    public void VerificoQuelosDatosSeanlosIngresados(DataTable datos) {
        manageDriver.setImplicitTimeWait(60);
        List<List<String>> values = datos.raw();
        String expectedTituloAccidente = values.get(1).get(0);
        String expectedlugarAccidente = values.get(1).get(1);
        String expectedgrabedadAccidente = values.get(1).get(2);
        String expecteddescripcionAccidente = values.get(1).get(3);
        String expectedfechaAccidente = values.get(1).get(4);
        String expectedhoraAccidente = values.get(1).get(5);
        String expectedTipoAccidente = values.get(1).get(6);
        String expectedArea = values.get(1).get(7);
        WebElement nombreAccidentado = ((FirefoxDriver) driver).findElementById("nameAccidentado");
        manageDriver.getWebDriverWait().until(ExpectedConditions.visibilityOf(nombreAccidentado));
        String result = CommonEvents.getFromElement(nombreAccidentado, "ng-reflect-model");
        Assert.assertEquals(result, expectedTituloAccidente);

        WebElement placeAccident = ((FirefoxDriver) driver).findElementById("place_accident");
        manageDriver.getWebDriverWait().until(ExpectedConditions.visibilityOf(placeAccident));
        result = CommonEvents.getFromElement(placeAccident, "ng-reflect-model");
        Assert.assertEquals(result, expectedlugarAccidente);

        WebElement GravityAccident = ((FirefoxDriver) driver).findElementById("gravity_accident");
        manageDriver.getWebDriverWait().until(ExpectedConditions.visibilityOf(GravityAccident));
        result = CommonEvents.getFromElement(GravityAccident, "ng-reflect-model");
        Assert.assertEquals(result, expectedgrabedadAccidente);

        WebElement descriptionAccident = ((FirefoxDriver) driver).findElementById("description_accident");
        manageDriver.getWebDriverWait().until(ExpectedConditions.visibilityOf(descriptionAccident));
        result = CommonEvents.getFromElement(descriptionAccident , "ng-reflect-model");
        Assert.assertEquals(result,expecteddescripcionAccidente);

        WebElement dateAccident = ((FirefoxDriver) driver).findElementById("date_accident");
        manageDriver.getWebDriverWait().until(ExpectedConditions.visibilityOf(dateAccident));
        result = CommonEvents.getFromElement(dateAccident , "ng-reflect-model");
        Assert.assertEquals(result, expectedfechaAccidente);

        WebElement hourAccident = ((FirefoxDriver) driver).findElementById("hour_accident");
        manageDriver.getWebDriverWait().until(ExpectedConditions.visibilityOf(hourAccident));
        result = CommonEvents.getFromElement(hourAccident, "ng-reflect-model");
        Assert.assertEquals(result, expectedhoraAccidente);

        WebElement accidentTypeId = ((FirefoxDriver) driver).findElementById("accidentTypeId");
        manageDriver.getWebDriverWait().until(ExpectedConditions.visibilityOf(accidentTypeId));
        result = CommonEvents.getFromElement(accidentTypeId, "ng-reflect-model");
        Assert.assertEquals(result, expectedTipoAccidente);

        WebElement areaId = ((FirefoxDriver) driver).findElementById("areaId");
        manageDriver.getWebDriverWait().until(ExpectedConditions.visibilityOf(areaId));
        result = CommonEvents.getFromElement(areaId, "ng-reflect-model");
        Assert.assertEquals(result, expectedArea);




    }

}
