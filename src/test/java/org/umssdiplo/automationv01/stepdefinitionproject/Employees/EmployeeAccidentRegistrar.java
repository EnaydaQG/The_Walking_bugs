package org.umssdiplo.automationv01.stepdefinitionproject.Employees;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.umssdiplo.automationv01.core.customwebdriver.ManageDriver;
import org.umssdiplo.automationv01.core.utils.CommonEvents;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class EmployeeAccidentRegistrar {
    ManageDriver manageDriver = ManageDriver.getInstance();
    WebDriver driver = manageDriver.getWebDriver();


    private String idEmpleado;
    private String zonaLesion;
    private String detalleLesion;
    private String tipoLesion;
    private String fullname;

    @Given("^Accedo a la vista de todos los accidentes$")
    public void accedoALaListaDeAccidentes() {
        ManageDriver.getInstance().getWebDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        ManageDriver.getInstance().getWebDriver().manage().window().maximize();
        ManageDriver.getInstance().getWebDriver().navigate().to("http://localhost:4200/accidentes");
        WebDriverWait wait = new WebDriverWait(driver, 60);
        ManageDriver.getInstance().setWebDriverWait(wait);
    }
    @And("^Selecciono ver el detalle del primer accidente$")
    public void seleccionoVerDetalleDelPrimerAccidente() {
        WebElement primerAccidente = ((ChromeDriver)driver).findElementByCssSelector("mat-table mat-row .mat-column-actions a");
        manageDriver.getWebDriverWait().until(ExpectedConditions.visibilityOf(primerAccidente));
        primerAccidente.click();
    }

    @And("^Cuando hago click en agregar empleados accidentados$")
    public void CuandoHagoClickAgregarEmpleadosAccidentados() {
        WebElement agregarAccidente = ((ChromeDriver)driver).findElementByCssSelector("mat-table mat-header-cell.mat-column-actions button");
        manageDriver.getWebDriverWait().until(ExpectedConditions.visibilityOf(agregarAccidente));
        agregarAccidente.click();

    }

    @And("^LLeno los datos del accidentado$")
    public void llenoLosDatosCon(DataTable datos) {
        manageDriver.setImplicitTimeWait(60);
        List<List<String>> values = datos.raw();
        this.idEmpleado = values.get(1).get(0);
        this.zonaLesion = values.get(1).get(1);
        this.detalleLesion = values.get(1).get(2);
        this.tipoLesion = values.get(1).get(3);
        this.fullname = values.get(1).get(4);
        // seleccionar selector empleado
        WebElement selectorEmpleado = ((ChromeDriver)driver).findElementByCssSelector("app-employee-accident-add form .mat-form-field-type-mat-select");
        manageDriver.getWebDriverWait().until(ExpectedConditions.visibilityOf(selectorEmpleado));
        selectorEmpleado.click();
        // seleccionar el tercer empleado
        WebElement opcionEmpleado = ((ChromeDriver)driver).findElementByCssSelector(".mat-select-content mat-option[ng-reflect-value='"+idEmpleado+"']");
        manageDriver.getWebDriverWait().until(ExpectedConditions.visibilityOf(opcionEmpleado));
        opcionEmpleado.click();
        // zona de lesion
        WebElement empleadoZonaLesion = ((ChromeDriver)driver).findElementByCssSelector("app-employee-accident-add form textarea[name='zonaLesion']");
        manageDriver.getWebDriverWait().until(ExpectedConditions.visibilityOf(empleadoZonaLesion));
        CommonEvents.setInputField(empleadoZonaLesion,zonaLesion);
        // detalle de lesion
        WebElement empleadoDetalleLesion = ((ChromeDriver)driver).findElementByCssSelector("app-employee-accident-add form input[name='detalleLesion']");
        manageDriver.getWebDriverWait().until(ExpectedConditions.visibilityOf(empleadoDetalleLesion));
        CommonEvents.setInputField(empleadoDetalleLesion, detalleLesion);
        // tipo de lesion
        WebElement empleadoTipoLesion = ((ChromeDriver)driver).findElementByCssSelector("app-employee-accident-add form textarea[name='tipoLesion']");
        manageDriver.getWebDriverWait().until(ExpectedConditions.visibilityOf(empleadoTipoLesion));
        CommonEvents.setInputField(empleadoTipoLesion, tipoLesion);



    }

    @When("^Hago click en el boton save$")
    public void hagoClickBotonSave(){
        WebElement formulario = ((ChromeDriver)driver).findElementByCssSelector("app-employee-accident-add form .mat-dialog-actions button");
        manageDriver.getWebDriverWait().until(ExpectedConditions.visibilityOf(formulario));
        formulario.click();
    }
    @Then("^Recargo la pagina$")
    public void recargarPagina() {
        driver.navigate().refresh();
    }

    @And("^Reviso que el empleado a sido creado$")
    public void revisoQueElEmpleadoASidoCreado() {
        // full name
        WebElement fullname = ((ChromeDriver)driver).findElementByCssSelector("mat-table mat-cell.mat-column-fullname");
        manageDriver.getWebDriverWait().until(ExpectedConditions.visibilityOf(fullname));
        String resultFullName = fullname.getText();
        Assert.assertEquals(resultFullName, this.fullname);
        // zona Lesion
        WebElement zonaLesion = ((ChromeDriver)driver).findElementByCssSelector("mat-table mat-cell.mat-column-zonaLesion");
        manageDriver.getWebDriverWait().until(ExpectedConditions.visibilityOf(zonaLesion));
        String resultZonaLesion = zonaLesion.getText();
        Assert.assertEquals(resultZonaLesion, this.zonaLesion);
        // detalle Lesion
        WebElement detalleLesion = ((ChromeDriver)driver).findElementByCssSelector("mat-table mat-cell.mat-column-detalleLesion");
        manageDriver.getWebDriverWait().until(ExpectedConditions.visibilityOf(detalleLesion));
        String resultDetalleLesion = detalleLesion.getText();
        Assert.assertEquals(resultDetalleLesion, this.detalleLesion);
        //
        List<WebElement> lista = ((ChromeDriver)driver).findElementsByCssSelector("mat-table mat-row");
        Assert.assertEquals(lista.size(), 1);

    }

    @And("^Cierro el navegador$")
    public void cierroNavegador() {
        manageDriver.getWebDriver().close();
    }



}
