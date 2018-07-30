package org.umssdiplo.automationv01.stepdefinitionproject.Projects;

import cucumber.api.DataTable;
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
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.umssdiplo.automationv01.core.customwebdriver.Firefox;
import org.umssdiplo.automationv01.core.customwebdriver.ManageDriver;
import org.umssdiplo.automationv01.core.utils.CommonEvents;

import java.util.List;
import java.util.stream.Collectors;

public class ProjectList {
    ManageDriver manageDriver = ManageDriver.getInstance();
    WebDriver driver = manageDriver.getWebDriver();

    @Given("^ingreso a la lista de proyectos registrados \"([^\"]*)\"$")
    public void ingresoALaListaDeProyectosRegistrados(String link)  {
        ManageDriver.getInstance().getWebDriver().manage().window().maximize();
        ManageDriver.getInstance().getWebDriver().navigate().to(link);
        WebDriverWait wait = new WebDriverWait(driver, 60);
        ManageDriver.getInstance().setWebDriverWait(wait);
    }

    @Then("^Hago click en Create new Project$")
    public void hagoClickEnCreateNewProject(){
        manageDriver.setImplicitTimeWait(60);
        WebElement newProject =  ((FirefoxDriver)driver).findElementByXPath("/html/body/app-root/div/div/div[2]/app-project/div/div[1]/div/div/div/a");
        manageDriver.getWebDriverWait().until(ExpectedConditions.visibilityOf(newProject));
        newProject.click();
    }

    @Then("^Verificar que se muestra el proyecto creado con nombre \"([^\"]*)\"$")
    public void verificoQueSeMuestraElProyectoCreadoConNombre(String nombre) {
        // mat-table[@class='mat-table']
        manageDriver.setImplicitTimeWait(60);
        WebElement newProject =  ((FirefoxDriver)driver).findElementByXPath("/html/body/app-root/div/div/div[2]/app-project/div/div[1]/div/div/div/a");
        manageDriver.getWebDriverWait().until(ExpectedConditions.visibilityOf(newProject));
        WebElement elementTable = ((FirefoxDriver)driver).findElementByXPath("//mat-table[@class='mat-table']/mat-row[3]/mat-cell[3]");
        String nombreActual=  elementTable.getText();
        String nombreEsperado = nombre;
        Assert.assertEquals(nombreEsperado,nombreActual,"Los nombres de los proyectos no son iguales");
  }

    @When("^hago click en el boton editar del proyecto creado.$")
    public void hagoClickEnElBotonEditarDelProyectoCreado(){
        WebElement btnEditar = ((FirefoxDriver)driver).findElementByXPath("//mat-table[@class='mat-table']/mat-row[3]/mat-cell[4]/button[1]");
        btnEditar.click();
    }

    @And("^verificar que no existe proyecto con nombre \"([^\"]*)\"$")
    public void verificarQueNoExisteProyectoConNombre(String arg0) {
        String expectedName = arg0;
        WebElement nameElement = ((FirefoxDriver) driver)
                .findElement(By.xpath("//mat-table"));
        manageDriver.getWebDriverWait().until(ExpectedConditions.visibilityOf(nameElement));
        String result = CommonEvents.getFromElement(nameElement,"mat-row[3]");
        if(result == null)
            result="NotFound";
        Assert.assertNotEquals(result,expectedName);
    }
}
