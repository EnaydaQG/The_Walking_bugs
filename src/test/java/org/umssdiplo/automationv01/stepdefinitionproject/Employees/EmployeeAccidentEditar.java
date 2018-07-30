package org.umssdiplo.automationv01.stepdefinitionproject.Employees;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.umssdiplo.automationv01.core.customwebdriver.ManageDriver;
import org.umssdiplo.automationv01.core.utils.CommonEvents;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class EmployeeAccidentEditar {
    ManageDriver manageDriver = ManageDriver.getInstance();
    WebDriver driver = manageDriver.getWebDriver();


    private String idEmpleado;
    private String zonaLesion;
    private String detalleLesion;
    private String tipoLesion;
    private String fullname;


    @And("^Cuando hago click en editar empleado accidentado$")
    public void CuandoHagoClickAgregarEmpleadosAccidentados() {
        WebElement agregarAccidente = ((ChromeDriver)driver).findElementByCssSelector("mat-table mat-cell.mat-column-actions button:nth-child(2)");
        manageDriver.getWebDriverWait().until(ExpectedConditions.visibilityOf(agregarAccidente));
        agregarAccidente.click();

    }

    @And("^LLeno los datos del empleado accidentado a editar$")
    public void llenoLosDatosDelEmpleadoAccidentadoEditar(DataTable datos) {
        manageDriver.setImplicitTimeWait(60);
        List<List<String>> values = datos.raw();
        this.zonaLesion = values.get(1).get(0);
        this.detalleLesion = values.get(1).get(1);
        this.tipoLesion = values.get(1).get(2);
        this.fullname = values.get(1).get(3);

        // zona de lesion
        WebElement empleadoZonaLesion = ((ChromeDriver)driver).findElementByCssSelector("app-employee-accident-edit form textarea[name='zonaLesion']");
        manageDriver.getWebDriverWait().until(ExpectedConditions.visibilityOf(empleadoZonaLesion));
        CommonEvents.setInputField(empleadoZonaLesion,zonaLesion);
        // detalle de lesion
        WebElement empleadoDetalleLesion = ((ChromeDriver)driver).findElementByCssSelector("app-employee-accident-edit form input[name='detalleLesion']");
        manageDriver.getWebDriverWait().until(ExpectedConditions.visibilityOf(empleadoDetalleLesion));
        CommonEvents.setInputField(empleadoDetalleLesion, detalleLesion);
        // tipo de lesion
        WebElement empleadoTipoLesion = ((ChromeDriver)driver).findElementByCssSelector("app-employee-accident-edit form input[name='tipoLesion']");
        manageDriver.getWebDriverWait().until(ExpectedConditions.visibilityOf(empleadoTipoLesion));
        CommonEvents.setInputField(empleadoTipoLesion, tipoLesion);

    }

    @And("^Reviso que el empleado a sido editado$")
    public void revisoEmpleadoEditado() {

    }


    @When("^Hago click en el boton save de editar$")
    public void hagoClickBotonSave(){
        WebElement formulario = ((ChromeDriver)driver).findElementByCssSelector("app-employee-accident-edit form .mat-dialog-actions button");
        manageDriver.getWebDriverWait().until(ExpectedConditions.visibilityOf(formulario));
        formulario.click();
    }



}
