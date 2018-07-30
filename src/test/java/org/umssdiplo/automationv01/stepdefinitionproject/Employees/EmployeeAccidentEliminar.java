package org.umssdiplo.automationv01.stepdefinitionproject.Employees;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.umssdiplo.automationv01.core.customwebdriver.ManageDriver;
import org.umssdiplo.automationv01.core.utils.CommonEvents;

import java.util.List;

public class EmployeeAccidentEliminar {
    ManageDriver manageDriver = ManageDriver.getInstance();
    WebDriver driver = manageDriver.getWebDriver();


    private String idEmpleado;
    private String zonaLesion;
    private String detalleLesion;
    private String tipoLesion;
    private String fullname;


    @And("^Cuando hago click en eliminar empleado accidentado$")
    public void CuandoHagoClickEliminarEmpleadosAccidentados() {
        WebElement agregarAccidente = ((ChromeDriver)driver).findElementByCssSelector("mat-table mat-cell.mat-column-actions button:nth-child(1)");
        manageDriver.getWebDriverWait().until(ExpectedConditions.visibilityOf(agregarAccidente));
        agregarAccidente.click();

    }




    @When("^Hago click en el boton delete para confirmar la seleccion$")
    public void hagoClickBotonSave(){
        WebElement formulario = ((ChromeDriver)driver).findElementByCssSelector("app-employee-accident-delete  .mat-dialog-actions button");
        manageDriver.getWebDriverWait().until(ExpectedConditions.visibilityOf(formulario));
        formulario.click();
    }
    @And("^Reviso que se elimino el detalle del empleado accidentado$")
    public void revisoEliminoDetalleEmpleadoAccidentado() {

    }



}
