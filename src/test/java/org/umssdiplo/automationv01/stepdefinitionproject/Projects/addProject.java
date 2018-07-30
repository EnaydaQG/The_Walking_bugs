package org.umssdiplo.automationv01.stepdefinitionproject.Projects;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.umssdiplo.automationv01.core.customwebdriver.ManageDriver;
import org.umssdiplo.automationv01.core.utils.CommonEvents;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class addProject {
    ManageDriver manageDriver = ManageDriver.getInstance();
    WebDriver driver = manageDriver.getWebDriver();

    @When ("^Ingreso el nombre de proyecto y gestion con$")
    public void llenarDatosCon(DataTable datos){
        List<List<String>> valores = datos.raw();
        String projectName = valores.get(1).get(0);
        String projectgestion = valores.get(1).get(1);
        WebElement elementName = ((FirefoxDriver) driver).findElementById("mat-input-0");
        manageDriver.getWebDriverWait().until(ExpectedConditions.visibilityOf(elementName));
        CommonEvents.setInputField(elementName, projectName);

        WebElement elementGestion = ((FirefoxDriver) driver).findElementById("mat-input-1");
        manageDriver.getWebDriverWait().until(ExpectedConditions.visibilityOf(elementGestion));
        CommonEvents.setInputField(elementGestion, projectgestion);
    }


    @And("^guardo haciendo  click en Save$")
    public void hagoClickEnSave(){
        WebElement save = ((FirefoxDriver) driver).findElementByXPath("//button[@class='background-primary text-floral-white mat-button']");
        WebElement cancel = ((FirefoxDriver) driver).findElementByXPath("/html/body/app-root/div/div/div[2]/app-add-project/div/form/button[1]");
        save.click();
    }
}
