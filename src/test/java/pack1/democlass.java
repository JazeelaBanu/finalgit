package pack1;



import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.cucumber.datatable.DataTable;
import junit.framework.Assert;

public class democlass  {
    WebDriver driver;
	@Given("user enters the login page")
	public void user_enters_the_login_page() {
	System.setProperty("webdriver.chrome.driver","C:\\Work_Jazeela\\drivers\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.get("http://10.232.237.143:443/TestMeApp/");
	driver.manage().window().maximize();
	driver.findElement(By.partialLinkText("SignIn")).click();
	}
	@And("user enters the {string} and {string} in the field")
	public void user_enters_the_in_the_field(String string,String string2,DataTable dt) {
    	List<Map<String,String>> lt = dt.asMaps();
    
    	
    	driver.findElement(By.name("userName")).sendKeys(lt.get(0).get("username"));
		driver.findElement(By.name("password")).sendKeys(lt.get(0).get("password"));

	 }
	@And("verify the login details")
	public void verify_the_login_details() {
		driver.findElement(By.name("Login")).click();
			}
	@Then("verify the page title")
	public void verify_the_page_title() {
		Assert.assertEquals("Home",driver.getTitle());
		driver.findElement(By.partialLinkText("SignOut")).click();
	}
	
}

