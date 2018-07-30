package org.umssdiplo.automationv01.stepdefinitionproject.Equipments;

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

import java.util.concurrent.TimeUnit;

public class DeleteEquipAssignedStepdef {

    ManageDriver manageDriver = ManageDriver.getInstance();
    WebDriver driver = manageDriver.getWebDriver();


    @When("^Hago click en botón Ver equipos del primero en la lista$")
    public void hagoClickEnBotonVerEquiposDelPrimeroEnLaLista(){
        getButtonEquip().click();
    }

    @And("^Hago click en botón Añadir de lista de equipos$")
    public void hagoClickEnBotonAnadirDeListaDeEquipos(){
        WebDriverWait wait = new WebDriverWait(driver, 60);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("addEquip")));
        getAddButton().click();
    }

    @Then("^Hago click en selector de equipo$")
    public void hagoClickEnSelectorDeEquipo(){
        WebDriverWait wait = new WebDriverWait(driver, 60);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("selectEquip")));
        getSelectEquip().click();
    }

    @And("^Selecciono equipo \"([^\"]*)\"$")
    public void seleccionoEquipo(String equipo){
        getEquipo(equipo).click();
    }

    @And("^Hago click en botón Guardar de selección de equipo$")
    public void hagoClickEnBotonGuardarDeSeleccionDeEquipo() {
        getButtonSave().click();
    }

    @Then("^Hago click en Editar del último equipo$")
    public void hagoClickEnEditarDelUltimoEquipo(){
        WebDriverWait wait = new WebDriverWait(driver, 60);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id=\"listEquip\"]/mat-row[last()]/mat-cell[@class='mat-cell cdk-column-editEquipment mat-column-editEquipment ng-star-inserted']/a")));
        getEditEquip().click();
    }


    @And("^Hago click en botón Eliminar del equipo$")
    public void hagoClickEnBotonEliminarDelEquipo(){
        WebDriverWait wait = new WebDriverWait(driver, 60);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("btnEliminar")));
        getDeleteButton().click();
    }

    @And("^Verifico que no se encuentre el equipo  \"([^\"]*)\"$")
    public void verificoQueNoSeEncuentreElEquipo(String equipo) {
        String equipoActual = getLastEquipo().getText();
        Assert.assertNotEquals(equipo,equipoActual);
    }

    private WebElement getButtonEquip(){
        return driver.findElement(By.xpath("//*[@id=\"listAssign\"]/mat-row[1]/mat-cell/a[@href='/view-detail-AssignEquip/1']"));
    }

    private WebElement getAddButton(){
        return driver.findElement(By.id("addEquip"));
    }

    private WebElement getSelectEquip(){
        return driver.findElement(By.id("selectEquip"));
    }

    private WebElement getEquipo(String equip){
        return driver.findElement(By.xpath("//*[@id=\"cdk-overlay-0\"]/div/div/mat-option/span[contains(text(),'"+equip+"')]"));
    }

    private WebElement getButtonSave(){
        return driver.findElement(By.id("btnGuardar"));
    }

    private WebElement getEditEquip(){
        return driver.findElement(By.xpath("//*[@id=\"listEquip\"]/mat-row[last()]/mat-cell[@class='mat-cell cdk-column-editEquipment mat-column-editEquipment ng-star-inserted']/a"));
    }

    private WebElement getDeleteButton(){
        return driver.findElement(By.id("btnEliminar"));
    }

    private WebElement getLastEquipo(){
        return driver.findElement(By.xpath("//*[@id=\"listEquip\"]/mat-row[last()]/mat-cell[@class='mat-cell cdk-column-nameEquipment mat-column-nameEquipment ng-star-inserted']"));
    }



}
