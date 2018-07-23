package org.umssdiplo.automationv01.stepdefinitionproject.Employees;

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

public class EmployeeList {
    ManageDriver manageDriver = ManageDriver.getInstance();
    WebDriver driver = manageDriver.getWebDriver();

    @Given("^Accedo a la lista de empleados \"([^\"]*)\"$")
    public void accedoALaListaDeEmpleados(String link) {
        ManageDriver.getInstance().getWebDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        ManageDriver.getInstance().getWebDriver().manage().window().maximize();
        ManageDriver.getInstance().getWebDriver().navigate().to(link);
        WebDriverWait wait = new WebDriverWait(driver, 60);
        ManageDriver.getInstance().setWebDriverWait(wait);
    }

    @Then("^Selecciono Registrar Empleado$")
    public void seleccionoRegistrarEmpleado(){
        WebElement createEmployee = ((FirefoxDriver) driver).findElementById("registrar-empleado");
        createEmployee.click();
    }

    @Then("^Hago click en Crear Empleado$")
    public void hagoClickEnCrearEmpleado() {
        WebElement create = ((FirefoxDriver) driver).findElementById("btn-create");
        create.click();
    }

    @Then("^Selecciono el ultimo Empleado creado$")
    public void seleccionoElUltimoEmpleadoCreado() {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("registrar-empleado")));
        CommonEvents.jsClickElement(driver.findElement(By.xpath("//*[@id=\"employee-list\"]/tbody/tr[last()]")));

        WebElement element2 = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("edit")));
    }

    @Then("^Cierro el navegador$")
    public void cierroElNavegador() {
        driver.close();
    }

}
