package org.umssdiplo.automationv01.stepdefinitionproject.Employees;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.umssdiplo.automationv01.core.customwebdriver.ManageDriver;
import org.umssdiplo.automationv01.core.utils.CommonEvents;

import java.util.List;

import static org.testng.AssertJUnit.assertFalse;

public class Employee {

    ManageDriver manageDriver = ManageDriver.getInstance();
    WebDriver driver = manageDriver.getWebDriver();

    @And("^Verifico que los datos del empleado sean$")
    public void verificoSiEsElEmpleadoCreado(DataTable datos) {
        manageDriver.setImplicitTimeWait(60);
        List<List<String>> values = datos.raw();
        String expectedName = values.get(1).get(0);
        String expectedLastName = values.get(1).get(1);
        String expectedCi = values.get(1).get(2);
        String expectedBirthDate = values.get(1).get(3);
        String expectedPhone = values.get(1).get(4);
        String expectedCivilState = values.get(1).get(5);
        String expectedNoDep = values.get(1).get(6);
        String expectedGender = values.get(1).get(7);
        String expectedExperience = values.get(1).get(8);
        String expectedPosition = values.get(1).get(9);
        String expectedSupervisor = values.get(1).get(10);
        String expectedProject = values.get(1).get(11);
        String expectedInitDate = values.get(1).get(12);
        String expectedEndDate = values.get(1).get(13);
        String expectedSalary = values.get(1).get(14);
        String expectedDescription = values.get(1).get(15);

        WebElement nombre = ((FirefoxDriver) driver).findElementById("employeeName");
        String result = CommonEvents.getFromElement(nombre, "ng-reflect-model");
        Assert.assertEquals(result,expectedName);

        WebElement lastNameElement = ((FirefoxDriver) driver).findElementById("lastName");
        result = CommonEvents.getFromElement(lastNameElement, "ng-reflect-model");
        Assert.assertEquals(result,expectedLastName);

        WebElement ciElement = ((FirefoxDriver) driver).findElementById("ci");
        result = CommonEvents.getFromElement(ciElement, "ng-reflect-model");
        Assert.assertEquals(result,expectedCi);

        WebElement birthDateElement = ((FirefoxDriver) driver).findElementById("birthDate");
        result = CommonEvents.getFromElement(birthDateElement, "ng-reflect-model");
        Assert.assertEquals(result,expectedBirthDate);

        WebElement phoneNumber = ((FirefoxDriver) driver).findElementById("phoneNumber");
        result = CommonEvents.getFromElement(phoneNumber, "ng-reflect-model");
        Assert.assertEquals(result,expectedPhone);

        WebElement civilStateElement = ((FirefoxDriver) driver).findElementById("civilState");
        result = CommonEvents.getFromElement(civilStateElement, "ng-reflect-model");
        Assert.assertEquals(result,expectedCivilState);

        WebElement depAmount = ((FirefoxDriver) driver).findElementById("depAmount");
        result = CommonEvents.getFromElement(depAmount, "ng-reflect-model");
        Assert.assertEquals(result,expectedNoDep);

        WebElement genre = ((FirefoxDriver) driver).findElementById("genre");
        result = CommonEvents.getFromElement(genre, "ng-reflect-model");
        Assert.assertEquals(result,expectedGender);

        WebElement experienceElement = ((FirefoxDriver) driver).findElementById("experience");
        result = CommonEvents.getFromElement(experienceElement, "ng-reflect-model");
        Assert.assertEquals(result,expectedExperience);

        WebElement positionElement = ((FirefoxDriver) driver).findElementById("positionSelector");
        result = CommonEvents.getSelectedOption(positionElement);
        Assert.assertEquals(result,expectedPosition);

        WebElement supervisorElement = ((FirefoxDriver) driver).findElementById("supervisorSelector");
        result = CommonEvents.getSelectedOption(supervisorElement);
        Assert.assertEquals(result,expectedSupervisor);

        WebElement projectElement = ((FirefoxDriver) driver).findElementById("projectSelector");
        result = CommonEvents.getSelectedOption(projectElement);
        Assert.assertEquals(result,expectedProject);

        WebElement initDateElement = ((FirefoxDriver) driver).findElementById("initDate");
        result = CommonEvents.getFromElement(initDateElement, "ng-reflect-model");
        Assert.assertEquals(result,expectedInitDate);

        WebElement finishDateElement = ((FirefoxDriver) driver).findElementById("finishDate");
        result = CommonEvents.getFromElement(finishDateElement, "ng-reflect-model");
        Assert.assertEquals(result,expectedEndDate);

        WebElement salaryElement = ((FirefoxDriver) driver).findElementById("salary");
        result = CommonEvents.getFromElement(salaryElement, "ng-reflect-model");
        Assert.assertEquals(result,expectedSalary);

        WebElement descriptionElement = ((FirefoxDriver) driver).findElementById("conctractDescription");
        result = CommonEvents.getFromElement(descriptionElement, "ng-reflect-model");
        Assert.assertEquals(result,expectedDescription);
    }

    @And("^Selecciono la opcion de editar$")
    public void seleccionoLaOpcionDeEditar() {
        WebElement editBtn = driver.findElement(By.id("edit"));
        CommonEvents.clickButton(editBtn);
    }

    @And("^LLeno los datos con$")
    public void llenoLosDatosCon(DataTable datos) {
        manageDriver.setExplicitTimeWait(60);
        manageDriver.setImplicitTimeWait(60);
        List<List<String>> values = datos.raw();

        String name = values.get(1).get(0);
        String lastName = values.get(1).get(1);
        String ci = values.get(1).get(2);
        String birthDate = values.get(1).get(3);
        String phone = values.get(1).get(4);
        String civilState = values.get(1).get(5);
        String noDep = values.get(1).get(6);
        String gender = values.get(1).get(7);
        String experience = values.get(1).get(8);
        String position = values.get(1).get(9);
        String supervisor = values.get(1).get(10);
        String project = values.get(1).get(11);
        String initDate = values.get(1).get(12);
        String finishDate = values.get(1).get(13);
        String salary = values.get(1).get(14);
        String description = values.get(1).get(15);

        WebElement nombre = ((FirefoxDriver) driver).findElementById("employeeName");
        CommonEvents.setInputField(nombre, name);

        WebElement lastNameElement = ((FirefoxDriver) driver).findElementById("lastName");
        CommonEvents.setInputField(lastNameElement, lastName);

        WebElement ciElement = ((FirefoxDriver) driver).findElementById("ci");
        CommonEvents.setInputField(ciElement, ci);

        WebElement birthDateElement = ((FirefoxDriver) driver).findElementById("birthDate");
        CommonEvents.setInputField(birthDateElement,birthDate);

        WebElement phoneNumber = ((FirefoxDriver) driver).findElementById("phoneNumber");
        CommonEvents.setInputField(phoneNumber, phone);

        WebElement civilStateElement = ((FirefoxDriver) driver).findElementById("civilState");
        CommonEvents.selectDropdownOption(civilStateElement, civilState);

        WebElement depAmount = ((FirefoxDriver) driver).findElementById("depAmount");
        CommonEvents.setInputField(depAmount, noDep);

        WebElement genre = ((FirefoxDriver) driver).findElementById("genre");
        CommonEvents.selectDropdownOption(genre, gender);

        WebElement experienceElement = ((FirefoxDriver) driver).findElementById("experience");
        CommonEvents.setInputField(experienceElement, experience);

        WebElement positionElement = ((FirefoxDriver) driver).findElementById("positionSelector");
        CommonEvents.selectDropdownOption(positionElement, position);

        WebElement supervisorElement = ((FirefoxDriver) driver).findElementById("supervisorSelector");
        CommonEvents.selectDropdownOption(supervisorElement, supervisor);

        WebElement projectElement = ((FirefoxDriver) driver).findElementById("projectSelector");
        CommonEvents.selectDropdownOption(projectElement, project);

        WebElement initDateElement = ((FirefoxDriver) driver).findElementById("initDate");
        CommonEvents.setInputField(initDateElement, initDate);

        WebElement finishDateElement = ((FirefoxDriver) driver).findElementById("finishDate");
        CommonEvents.setInputField(finishDateElement, finishDate);

        WebElement salaryElement = ((FirefoxDriver) driver).findElementById("salary");
        CommonEvents.setInputField(salaryElement, salary);

        WebElement descriptionElement = ((FirefoxDriver) driver).findElementById("conctractDescription");
        CommonEvents.setInputField(descriptionElement, description);
    }

    @Then("^Hago click en guardar cambios$")
    public void hagoClickEnGuardarCambios() {
        manageDriver.setImplicitTimeWait(60);
        WebElement create = ((FirefoxDriver) driver).findElementById("btn-create");
        create.click();
    }

    @And("^Verifico que los datos del empleado no sean$")
    public void verificoQueLosDatosDelEmpleadoNoSean(DataTable datos) {
        manageDriver.setImplicitTimeWait(60);
        List<List<String>> values = datos.raw();
        String expectedCi = values.get(1).get(2);

        WebElement ciElement = ((FirefoxDriver) driver).findElementById("ci");
        String result = CommonEvents.getFromElement(ciElement, "ng-reflect-model");
        Assert.assertNotEquals(result,expectedCi);
    }

    @And("^Hago click en eliminar empleado$")
    public void hagoClickEnEliminarEmpleado() {
        WebElement deleteBtn = driver.findElement(By.id("delete"));
        CommonEvents.clickButton(deleteBtn);
    }
}
