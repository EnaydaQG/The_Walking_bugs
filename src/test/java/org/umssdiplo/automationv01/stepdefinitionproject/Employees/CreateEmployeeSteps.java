package org.umssdiplo.automationv01.stepdefinitionproject.Employees;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
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

    @When("^Selecciono Registrar Empleado$")
    public void seleccionoRegistrarEmpleado(){
        WebElement createEmployee = ((FirefoxDriver) driver).findElementById("registrar-empleado");
        createEmployee.click();
    }

    /*Click en crear*/
    //WebElement create = ((FirefoxDriver) driver).findElementById("btn-create");
    //create.click();

    @Then("^Lleno el campo Nombre con \"([^\"]*)\"$")
    public void llenoElCampoNombreCon(String name) {
        WebElement nombre = ((FirefoxDriver) driver).findElementById("employeeName");
        CommonEvents.setInputField(nombre, name);
    }

    @Then("^Lleno el campo Apellido con \"([^\"]*)\"$")
    public void llenoElCampoApellidoCon(String lastName) {
        WebElement lastNameElement = ((FirefoxDriver) driver).findElementById("lastName");
        CommonEvents.setInputField(lastNameElement, lastName);
    }

    @Then("^Lleno el campo Ci \"([^\"]*)\"$")
    public void llenoElCampoCi(String ci) {
        WebElement ciElement = ((FirefoxDriver) driver).findElementById("ci");
        CommonEvents.setInputField(ciElement, ci);
    }

    @Then("^Lleno el campo Fecha de Nacimiento \"([^\"]*)\"$")
    public void llenoElCampoFechaDeNacimiento(String birthDate) {
        WebElement birthDateElement = ((FirefoxDriver) driver).findElementById("birthDate");
        CommonEvents.setInputField(birthDateElement,birthDate);
    }

    @Then("^Lleno el campo telefono con \"([^\"]*)\"$")
    public void llenoElCampoTelefonoCon(String phone) {
        WebElement phoneNumber = ((FirefoxDriver) driver).findElementById("phoneNumber");
        CommonEvents.setInputField(phoneNumber, phone);
    }

    @Then("^Selecciono en Estado civil la opcion \"([^\"]*)\"$")
    public void seleccionoEnEstadoCivilLaOpcion(String civilState) {
        WebElement civilStateElement = ((FirefoxDriver) driver).findElementById("civilState");
        CommonEvents.selectDropdownOption(civilStateElement, civilState);
    }

    @Then("^Lleno el campo Numero de Dependientes con \"([^\"]*)\"$")
    public void llenoElCampoNumeroDeDependientesCon(String noDep) {
        WebElement depAmount = ((FirefoxDriver) driver).findElementById("depAmount");
        CommonEvents.setInputField(depAmount, noDep);
    }

    @Then("^Lleno el campo Genero con \"([^\"]*)\"$")
    public void llenoElCampoGeneroCon(String gender) {
        WebElement genre = ((FirefoxDriver) driver).findElementById("genre");
        CommonEvents.selectDropdownOption(genre, gender);
    }

    @Then("^Lleno el campo Experiencia con \"([^\"]*)\"$")
    public void llenoElCampoExperienciaCon(String experience) {
        WebElement experienceElement = ((FirefoxDriver) driver).findElementById("experience");
        CommonEvents.setInputField(experienceElement, experience);
    }

    @Then("^Selecciono en Cargo de Empleado la opcion \"([^\"]*)\"$")
    public void seleccionoEnCargoDeEmpleadoLaOpcion(String position) {
        WebElement positionElement = ((FirefoxDriver) driver).findElementById("positionSelector");
        CommonEvents.selectDropdownOption(positionElement, position);
    }

    @Then("^Selecciono en Supervisor la opcion \"([^\"]*)\"$")
    public void seleccionoEnSupervisorLaOpcion(String supervisor) {
        WebElement supervisorElement = ((FirefoxDriver) driver).findElementById("supervisorSelector");
        CommonEvents.selectDropdownOption(supervisorElement, supervisor);
    }

    @Then("^Selecciono en Proyecto la opcion \"([^\"]*)\"$")
    public void seleccionoEnProyectoLaOpcion(String project) {
        WebElement projectElement = ((FirefoxDriver) driver).findElementById("projectSelector");
        CommonEvents.selectDropdownOption(projectElement, project);
    }

    @Then("^Lleno el campo Fecha de Inicio de Contrato con \"([^\"]*)\"$")
    public void llenoElCampoFechaDeInicioDeContratoCon(String initDate) {
        WebElement initDateElement = ((FirefoxDriver) driver).findElementById("initDate");
        CommonEvents.setInputField(initDateElement, initDate);
    }

    @Then("^Lleno el campo Fecha de Finalizacion de Contrato con \"([^\"]*)\"$")
    public void llenoElCampoFechaDeFinalizacionDeContratoCon(String finishDate) {
        WebElement finishDateElement = ((FirefoxDriver) driver).findElementById("finishDate");
        CommonEvents.setInputField(finishDateElement, finishDate);
    }

    @Then("^Lleno el campo Fecha de Salario con \"([^\"]*)\"$")
    public void llenoElCampoFechaDeSalarioCon(String salary) {
        WebElement salaryElement = ((FirefoxDriver) driver).findElementById("salary");
        CommonEvents.setInputField(salaryElement, salary);
    }

    @Then("^Lleno el campo Fecha de Descripcion con \"([^\"]*)\"$")
    public void llenoElCampoFechaDeDescripcionCon(String description) {
        WebElement descriptionElement = ((FirefoxDriver) driver).findElementById("conctractDescription");
        CommonEvents.setInputField(descriptionElement, description);
    }
}
