package org.umssdiplo.automationv01.stepdefinitionproject.Employees;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.umssdiplo.automationv01.core.customwebdriver.ManageDriver;

public class SeleccionarCausa {
    ManageDriver manageDriver = ManageDriver.getInstance();
    WebDriver driver = manageDriver.getWebDriver();

    @When("^Hago click en el checkbox primero$")
    public void CuandoHagoClickEliminarEmpleadosAccidentados() {
        WebElement seleccionarCausa= ((ChromeDriver)driver).findElementByCssSelector("mat-list mat-checkbox");
        manageDriver.getWebDriverWait().until(ExpectedConditions.visibilityOf(seleccionarCausa));
        seleccionarCausa.click();
    }

    @Then("^Reviso si esta seleccionado la primera causa$")
    public void revisoEstaSeleccionadoPrimeraCausa() {
        WebElement formulario = ((ChromeDriver)driver).findElementByCssSelector("mat-list mat-list-item input[type='checkbox']");
        Assert.assertTrue(formulario.isSelected());
    }

}
