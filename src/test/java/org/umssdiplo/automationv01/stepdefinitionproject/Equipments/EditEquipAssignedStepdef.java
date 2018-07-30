package org.umssdiplo.automationv01.stepdefinitionproject.Equipments;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.umssdiplo.automationv01.core.customwebdriver.ManageDriver;

public class EditEquipAssignedStepdef {

    ManageDriver manageDriver = ManageDriver.getInstance();
    WebDriver driver = manageDriver.getWebDriver();

    @And("^Hago click en botón Editar del primero en la lista de equipos$")
    public void hagoClickEnBotonEditarDelPrimeroEnLaListaDeEquipos() {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id=\"listEquip\"]/mat-row[1]/mat-cell[@class='mat-cell cdk-column-editEquipment mat-column-editEquipment ng-star-inserted'] ")));
        getEditButton().click();
    }

    @Then("^Hago click en selector de equipo para editar$")
    public void hagoClickEnSelectorDeEquipoParaEditar(){
        WebDriverWait wait = new WebDriverWait(driver, 60);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("selectEquip")));
        getSelectEquip().click();
    }

    @And("^Selecciono equipo para editar \"([^\"]*)\"$")
    public void seleccionoEquipoParaEditar(String equipo) {
        getEquipo(equipo).click();
    }

    @And("^Hago click en botón Guardar de edición de equipo$")
    public void hagoClickEnBotonGuardarDeEdicionDeEquipo() {
        getButtonSave().click();
    }

    @And("^Verifico que el primer equipo sea  \"([^\"]*)\"$")
    public void verificoQueElPrimerEquipoSea(String equipo) throws Throwable {
        String equipoActual = getFirstEquipo().getText();
        Assert.assertEquals(equipo,equipoActual,"El equipo ha sido editado");
    }

    private WebElement getEditButton(){
        return driver.findElement(By.xpath("//*[@id=\"listEquip\"]/mat-row[1]/mat-cell[@class='mat-cell cdk-column-editEquipment mat-column-editEquipment ng-star-inserted']/a"));
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

    private WebElement getFirstEquipo(){
        return driver.findElement(By.xpath("//*[@id=\"listEquip\"]/mat-row[1]/mat-cell[@class='mat-cell cdk-column-nameEquipment mat-column-nameEquipment ng-star-inserted']"));
    }
}
