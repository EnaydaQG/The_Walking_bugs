package org.umssdiplo.automationv01.stepdefinitionproject.Accidents;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.umssdiplo.automationv01.core.customwebdriver.ManageDriver;
import org.umssdiplo.automationv01.core.utils.CommonEvents;

import java.util.concurrent.TimeUnit;

public class StepsDefRegisterAccidents {
    ManageDriver manageDriver = ManageDriver.getInstance();
    WebDriver driver = ManageDriver.getInstance().getWebDriver();
    @Given("^Accedo a la lista de Accidentes \"([^\"]*)\"$")
    public void accedoALaListaDeAccidente(String link) {
        ManageDriver.getInstance().getWebDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        ManageDriver.getInstance().getWebDriver().manage().window().maximize();
        ManageDriver.getInstance().getWebDriver().navigate().to(link);
        WebDriverWait wait = new WebDriverWait(driver, 60);
        ManageDriver.getInstance().setWebDriverWait(wait);
    }

    @Then("^Selecciono boton Registrar Accidente$")
    public void seleccionoRegistrarAccidente(){
        WebElement registraAccidente = ((FirefoxDriver) driver).findElementById("REGISTRAR_ACCIDENTE");
        manageDriver.getWebDriverWait().until(ExpectedConditions.visibilityOf(registraAccidente));
        registraAccidente.click();
    }
    @Then("^Hago click en SAVE$")
    public void HagoClickEnSAVE() {
        WebElement save = ((FirefoxDriver) driver).findElementById("registrar");
        manageDriver.getWebDriverWait().until(ExpectedConditions.visibilityOf(save));
        save.click();
    }
    @Then("^Selecciono el ultimo Registro De Accidente$")
    public void seleccionoElUltimoEmpleadoCreado() {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id=\"mat-option-2\"]/span")));
        manageDriver.getWebDriverWait().until(ExpectedConditions.visibilityOf(element));
        CommonEvents.jsClickElement(driver.findElement(By.xpath("/html/body/app-root/div/div/div[2]/app-accident-list/div/div[2]/mat-table/mat-row[17]/mat-cell[5]/button[1]/span/mat-icon")));

        WebElement element2 = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id=\"mat-dialog-0\"]/app-accident-edit-component/div/form/div[9]/button[1]/span")));
    }
    @Then("^Cierro el navegador$")
    public void cierroElNavegador() {
        driver.close();
}}
