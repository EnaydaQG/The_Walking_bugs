package org.umssdiplo.automationv01.stepdefinitionproject.Employees;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.umssdiplo.automationv01.core.customwebdriver.ManageDriver;
import org.umssdiplo.automationv01.core.managepage.Login.Login;
import org.umssdiplo.automationv01.core.utils.CommonEvents;
import org.umssdiplo.automationv01.core.utils.LoadPage;

import java.util.concurrent.TimeUnit;

public class CreateEmployeeSteps {
    WebDriver driver = ManageDriver.getInstance().getWebDriver();

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

    @When("^Lleno el campo Nombre con \"([^\"]*)\"$")
    public void llenoElCampoNombreCon(String name) {
        WebElement nombre = ((FirefoxDriver) driver).findElementById("employeeName");
        CommonEvents.setInputField(nombre, name);
    }

    @And("^Lleno el campo Apellido con \"([^\"]*)\"$")
    public void llenoElCampoApellidoCon(String lastName) {
        WebElement lastNameElement = ((FirefoxDriver) driver).findElementById("lastName");
        CommonEvents.setInputField(lastNameElement, lastName);
    }

    @And("^Lleno el campo Ci \"([^\"]*)\"$")
    public void llenoElCampoCi(String ci) {
        WebElement ciElement = ((FirefoxDriver) driver).findElementById("ci");
        CommonEvents.setInputField(ciElement, ci);
    }

    @And("^Lleno el campo Fecha de Nacimiento \"([^\"]*)\"$")
    public void llenoElCampoFechaDeNacimiento(String birthDate) {
        WebElement birthDateElement = ((FirefoxDriver) driver).findElementById("birthDate");
        CommonEvents.setInputField(birthDateElement,birthDate);
    }

    @And("^Lleno el campo telefono con \"([^\"]*)\"$")
    public void llenoElCampoTelefonoCon(String phone) {
        WebElement phoneNumber = ((FirefoxDriver) driver).findElementById("phoneNumber");
        CommonEvents.setInputField(phoneNumber, phone);
    }

    @And("^Selecciono en Estado civil la opcion \"([^\"]*)\"$")
    public void seleccionoEnEstadoCivilLaOpcion(String civilState) {
        WebElement civilStateElement = ((FirefoxDriver) driver).findElementById("civilState");
        CommonEvents.selectDropdownOption(civilStateElement, civilState);
    }

    @And("^Lleno el campo Numero de Dependientes con \"([^\"]*)\"$")
    public void llenoElCampoNumeroDeDependientesCon(String noDep) {
        WebElement depAmount = ((FirefoxDriver) driver).findElementById("depAmount");
        CommonEvents.setInputField(depAmount, noDep);
    }

    @And("^Lleno el campo Genero con \"([^\"]*)\"$")
    public void llenoElCampoGeneroCon(String gender) {
        WebElement genre = ((FirefoxDriver) driver).findElementById("genre");
        CommonEvents.selectDropdownOption(genre, gender);
    }

    @And("^Lleno el campo Experiencia con \"([^\"]*)\"$")
    public void llenoElCampoExperienciaCon(String experience) {
        WebElement experienceElement = ((FirefoxDriver) driver).findElementById("experience");
        CommonEvents.setInputField(experienceElement, experience);
    }

    @And("^Selecciono en Cargo de Empleado la opcion \"([^\"]*)\"$")
    public void seleccionoEnCargoDeEmpleadoLaOpcion(String position) {
        WebElement positionElement = ((FirefoxDriver) driver).findElementById("positionSelector");
        CommonEvents.selectDropdownOption(positionElement, position);
    }

    @And("^Selecciono en Supervisor la opcion \"([^\"]*)\"$")
    public void seleccionoEnSupervisorLaOpcion(String supervisor) {
        WebElement supervisorElement = ((FirefoxDriver) driver).findElementById("supervisorSelector");
        CommonEvents.selectDropdownOption(supervisorElement, supervisor);
    }

    @And("^Selecciono en Proyecto la opcion \"([^\"]*)\"$")
    public void seleccionoEnProyectoLaOpcion(String project) {
        WebElement projectElement = ((FirefoxDriver) driver).findElementById("projectSelector");
        CommonEvents.selectDropdownOption(projectElement, project);
    }

    @And("^Lleno el campo Fecha de Inicio de Contrato con \"([^\"]*)\"$")
    public void llenoElCampoFechaDeInicioDeContratoCon(String initDate) {
        WebElement initDateElement = ((FirefoxDriver) driver).findElementById("initDate");
        CommonEvents.setInputField(initDateElement, initDate);
    }

    @And("^Lleno el campo Fecha de Finalizacion de Contrato con \"([^\"]*)\"$")
    public void llenoElCampoFechaDeFinalizacionDeContratoCon(String finishDate) {
        WebElement finishDateElement = ((FirefoxDriver) driver).findElementById("finishDate");
        CommonEvents.setInputField(finishDateElement, finishDate);
    }

    @And("^Lleno el campo de Salario con \"([^\"]*)\"$")
    public void llenoElCampoFechaDeSalarioCon(String salary) {
        WebElement salaryElement = ((FirefoxDriver) driver).findElementById("salary");
        CommonEvents.setInputField(salaryElement, salary);
    }

    @And("^Lleno el campo de Descripcion con \"([^\"]*)\"$")
    public void llenoElCampoFechaDeDescripcionCon(String description) {
        WebElement descriptionElement = ((FirefoxDriver) driver).findElementById("conctractDescription");
        CommonEvents.setInputField(descriptionElement, description);
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
        CommonEvents.jsClickElement(driver.findElement(By.xpath("/html/body/app-root/div/div/div[2]/app-employee-list/div[2]/table/tbody/tr[last()]")));
        WebElement element2 = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("edit")));
    }

    @Then("^Verifico si el nombre es \"([^\"]*)\"$")
    public void verificoSiElNombreEs(String expectedName) {
        WebElement nombre = ((FirefoxDriver) driver).findElementById("employeeName");
        String result = CommonEvents.getFromElement(nombre, "ng-reflect-model");
        Assert.assertEquals(result,expectedName);
    }

    @Then("^Verifico si el apellido es \"([^\"]*)\"$")
    public void verificoSiElApellidoEs(String expectedLastName) {
        WebElement lastNameElement = ((FirefoxDriver) driver).findElementById("lastName");
        String result = CommonEvents.getFromElement(lastNameElement, "ng-reflect-model");
        Assert.assertEquals(result,expectedLastName);
    }

    @Then("^Verifico si el ci es \"([^\"]*)\"$")
    public void verificoSiElCiEs(String expectedCi) {
        WebElement ciElement = ((FirefoxDriver) driver).findElementById("ci");
        String result = CommonEvents.getFromElement(ciElement, "ng-reflect-model");
        Assert.assertEquals(result,expectedCi);
    }

    @Then("^Verifico si la fecha de nacimiento es \"([^\"]*)\"$")
    public void verificoSiLaFechaDeNacimientoEs(String expectedBirthDate) {
        WebElement birthDateElement = ((FirefoxDriver) driver).findElementById("birthDate");
        String result = CommonEvents.getFromElement(birthDateElement, "ng-reflect-model");
        Assert.assertEquals(result,expectedBirthDate);
    }

    @Then("^Verifico si el telefono es \"([^\"]*)\"$")
    public void verificoSiElTelefonoEs(String expectedPhone) {
        WebElement phoneNumber = ((FirefoxDriver) driver).findElementById("phoneNumber");
        String result = CommonEvents.getFromElement(phoneNumber, "ng-reflect-model");
        Assert.assertEquals(result,expectedPhone);
    }

    @Then("^Verifico si el estado civil es \"([^\"]*)\"$")
    public void verificoSiElEstadoCivilEs(String expectedCivilState) {
        WebElement civilStateElement = ((FirefoxDriver) driver).findElementById("civilState");
        String result = CommonEvents.getFromElement(civilStateElement, "ng-reflect-model");
        Assert.assertEquals(result,expectedCivilState);
    }

    @Then("^Verifico si el no de dependientes es \"([^\"]*)\"$")
    public void verificoSiElNoDeDependientesEs(String expectedNoDep) {
        WebElement depAmount = ((FirefoxDriver) driver).findElementById("depAmount");
        String result = CommonEvents.getFromElement(depAmount, "ng-reflect-model");
        Assert.assertEquals(result,expectedNoDep);
    }

    @Then("^Verifico si el gender es \"([^\"]*)\"$")
    public void verificoSiElGenderEs(String expectedGender) {
        WebElement genre = ((FirefoxDriver) driver).findElementById("genre");
        String result = CommonEvents.getFromElement(genre, "ng-reflect-model");
        Assert.assertEquals(result,expectedGender);
    }

    @Then("^Verifico si la experiencia es \"([^\"]*)\"$")
    public void verificoSiLaExperienciaEs(String expectedExperience) {
        WebElement experienceElement = ((FirefoxDriver) driver).findElementById("experience");
        String result = CommonEvents.getFromElement(experienceElement, "ng-reflect-model");
        Assert.assertEquals(result,expectedExperience);
    }

    @Then("^Verifico si el cargo es \"([^\"]*)\"$")
    public void verificoSiElCargoEs(String expectedPosition) {
        WebElement positionElement = ((FirefoxDriver) driver).findElementById("positionSelector");
        String result = CommonEvents.getSelectedOption(positionElement);
        Assert.assertEquals(result,expectedPosition);
    }

    @Then("^Verifico si el supervisor es \"([^\"]*)\"$")
    public void verificoSiElSupervisorEs(String expectedSupervisor) {
        WebElement supervisorElement = ((FirefoxDriver) driver).findElementById("supervisorSelector");
        String result = CommonEvents.getSelectedOption(supervisorElement);
        Assert.assertEquals(result,expectedSupervisor);
    }

    @Then("^Verifico si el proyecto es \"([^\"]*)\"$")
    public void verificoSiElProyectoEs(String expectedProject) {
        WebElement projectElement = ((FirefoxDriver) driver).findElementById("projectSelector");
        String result = CommonEvents.getSelectedOption(projectElement);
        Assert.assertEquals(result,expectedProject);
    }

    @Then("^Verifico si la fecha de inicio es \"([^\"]*)\"$")
    public void verificoSiLaFechaDeInicioEs(String expectedInitDate) {
        WebElement initDateElement = ((FirefoxDriver) driver).findElementById("initDate");
        String result = CommonEvents.getFromElement(initDateElement, "ng-reflect-model");
        Assert.assertEquals(result,expectedInitDate);
    }

    @Then("^Verifico si la fecha de finalzacion es \"([^\"]*)\"$")
    public void verificoSiLaFechaDeFinalzacionEs(String expectedEndDate) {
        WebElement finishDateElement = ((FirefoxDriver) driver).findElementById("finishDate");
        String result = CommonEvents.getFromElement(finishDateElement, "ng-reflect-model");
        Assert.assertEquals(result,expectedEndDate);
    }

    @Then("^Verifico si el salario es \"([^\"]*)\"$")
    public void verificoSiElSalarioEs(String expectedSalary) {
        WebElement salaryElement = ((FirefoxDriver) driver).findElementById("salary");
        String result = CommonEvents.getFromElement(salaryElement, "ng-reflect-model");
        Assert.assertEquals(result,expectedSalary);
    }

    @Then("^Verifico si la descripcion es \"([^\"]*)\"$")
    public void verificoSiLaDescripcionEs(String expectedDescription) {
        WebElement descriptionElement = ((FirefoxDriver) driver).findElementById("conctractDescription");
        String result = CommonEvents.getFromElement(descriptionElement, "ng-reflect-model");
        Assert.assertEquals(result,expectedDescription);
    }

    @Then("^Cierro el navegador$")
    public void cierroElNavegador() throws Throwable {
        driver.close();
    }
}
