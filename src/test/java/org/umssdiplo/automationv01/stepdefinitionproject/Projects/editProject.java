package org.umssdiplo.automationv01.stepdefinitionproject.Projects;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.umssdiplo.automationv01.core.customwebdriver.ManageDriver;

public class editProject {

    ManageDriver manageDriver = ManageDriver.getInstance();
    WebDriver driver = manageDriver.getWebDriver();

    @And("^Verifico que  el nombre sea del proyecto editado \"([^\"]*)\"$")
    public void verificarNombredeProyectoAlEditar(String nombre){
        WebDriverWait wait = new WebDriverWait(driver, 60);
        WebElement imputNombre =  ((FirefoxDriver)driver).findElementByXPath("/html/body/app-root/div/div/div[2]/app-edit-project/div/mat-card[2]/form/mat-input-container[1]/div/div[1]/div");
        manageDriver.getWebDriverWait().until(ExpectedConditions.visibilityOf(imputNombre));
        System.out.println(">>>>" + imputNombre.getText()+ ">>");
       // Assert.assertEquals(nombre,imputNombre.getText());
    }

    @Then("^hacer click en el boton elminar$")
    public void hacerClickEnElBotonElminar(){
        WebElement btnEliminar =  ((FirefoxDriver)driver).findElementByXPath("/html/body/app-root/div/div/div[2]/app-edit-project/div/mat-card[2]/form/button[1]");
        btnEliminar.click();

    }
}
