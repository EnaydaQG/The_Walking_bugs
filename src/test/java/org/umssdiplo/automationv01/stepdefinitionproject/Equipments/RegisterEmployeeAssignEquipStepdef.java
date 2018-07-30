package org.umssdiplo.automationv01.stepdefinitionproject.Equipments;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.umssdiplo.automationv01.core.customwebdriver.ManageDriver;

import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

public class RegisterEmployeeAssignEquipStepdef {
    ManageDriver manageDriver = ManageDriver.getInstance();
    WebDriver driver = manageDriver.getWebDriver();

    @Given("^Accedo a lista de asignación \"([^\"]*)\"$")
    public void accedoALaListaDeEmpleados(String link) {
        ManageDriver.getInstance().getWebDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        ManageDriver.getInstance().getWebDriver().manage().window().maximize();
        ManageDriver.getInstance().getWebDriver().navigate().to(link);
        WebDriverWait wait = new WebDriverWait(driver, 60);
        ManageDriver.getInstance().setWebDriverWait(wait);
    }

    @When("^Hago click en botón Añadir de asignación$")
    public void hagoClickEnBotonAnadir(){
        WebDriverWait wait = new WebDriverWait(driver, 60);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//button[@ng-reflect-router-link='/assign-equipment-add']")));
        getAddButton().click();
    }

    @Then("^Hago click en selector de empleado$")
    public void hagoClickEnSelectorDeEmpleado() {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("selectEmployee")));
        getSelectEmployee().click();
    }

    @And("^Selecciono al empleado \"([^\"]*)\"$")
    public void seleccionoAlEmpleado(String employee) {
        getEmployee(employee).click();
    }

    @Then("^Hago click para desplegar Datepicker$")
    public void hagoClickParaDesplegarDatepicker(){
        getTableDate().click();
        WebDriverWait wait = new WebDriverWait(driver, 60);
        //WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(
                //By.id("//*[@id=\"mat-datepicker-0\"]/div/mat-month-view/table")));
    }

    @And("^Selecciono la fecha actual$")
    public void seleccionoLaFechaActual(){
        String today = getCurrentDay();
        List<WebElement> columns = getDatePicker().findElements(By.tagName("td"));

        for (WebElement cell: columns) {
            //Select Today's Date
            if (cell.getText().equals(today)) {
                cell.click();
                break;
            }
        }

        //Wait for 4 Seconds to see Today's date selected.
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Then("^Lleno el campo descripción con \"([^\"]*)\"$")
    public void llenoElCampoDescripcionCon(String descripcion){
        getDescription().sendKeys(descripcion);
    }

    @And("^Hago click en botón Guardar de asignación$")
    public void hagoClickEnBotonGuardar() {
        getSaveButton().click();
    }

    @And("^Verifico que el último registro sea igual a los siguientes campos$")
    public void verificoQueElUltimoRegistroSeaIgualALosSiguientesCampos(DataTable datos){
        WebDriverWait wait = new WebDriverWait(driver, 60);
        String nameActual = getLastNameRegister().getText();
        String descripcionActual = getLastDescription().getText();

        List<List<String>> datosProfile = datos.raw();
        for (List<String> dato:datosProfile){
            switch (dato.get(0)){
                case "Empleado":
                    Assert.assertEquals(dato.get(1),nameActual,"El nombre no es igual");
                    break;
                case "Descripcion":
                    Assert.assertEquals(dato.get(1),descripcionActual, "La descripción no es la misma");
                    break;
            }
        }
    }

    private WebElement getAddButton(){
        return driver.findElement(By.xpath("//button[@ng-reflect-router-link='/assign-equipment-add']"));
    }
    private WebElement getSelectEmployee(){
        return driver.findElement(By.id("selectEmployee"));
    }

    private WebElement getEmployee(String employee){
        return driver.findElement(By.xpath("//*[@id=\"cdk-overlay-0\"]/div/div/mat-option/span[contains(text(),'Miranda')]"));
        //return driver.findElement(By.xpath("//*[@id=\"mat-option-201\"]/span/text()['"+employee+"']"));
    }
    private WebElement getTableDate(){
        return driver.findElement(By.xpath("//*[@id=\"datePicker1\"]/button"));
    }

    private WebElement getDatePicker(){
        return driver.findElement(By.xpath("//*[@id=\"mat-datepicker-0\"]/div/mat-month-view/table/tbody"));
    }
    private WebElement getDescription(){
        return driver.findElement(By.id("inputDescription"));
    }

    private WebElement getSaveButton(){
        return driver.findElement(By.id("btnSave"));
    }

    private WebElement getLastNameRegister(){
        return driver.findElement(By.xpath("//*[@id=\"listAssign\"]/mat-row[last()]/mat-cell[@class='mat-cell cdk-column-fullNameEmp mat-column-fullNameEmp ng-star-inserted']"));
    }

    private WebElement getLastDescription(){
        return driver.findElement(By.xpath("//*[@id=\"listAssign\"]/mat-row[last()]/mat-cell[@class='mat-cell cdk-column-description mat-column-description ng-star-inserted']"));
    }

    private String getCurrentDay (){
        //Create a Calendar Object
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());

        //Get Current Day as a number
        int todayInt = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println("Today Int: " + todayInt +"\n");

        //Integer to String Conversion
        String todayStr = Integer.toString(todayInt);
        System.out.println("Today Str: " + todayStr + "\n");

        return todayStr;
    }

}
