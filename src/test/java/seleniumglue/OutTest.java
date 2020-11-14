package seleniumglue;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class OutTest {
    public static WebDriver driver;
    
    @Given("^user is on LandingPage$")
    public void user_is_on_homepage() throws Throwable {     
    	System.setProperty("webdriver.chrome.driver","C:\\\\Users\\\\Va185060\\\\Desktop\\\\sag\\\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://automationpractice.com/index.php");
    }
    
    @When("^user navigates to LandingPage Page$")
    public void user_navigates_to_Login_Page() throws Throwable {
        driver.findElement(By.linkText("Sign in")).click();
    }
    //for string parameter use .* and for integer(//d+) for more "http://www.automationtestinghub.com/practical-examples-cucumber-data-driven-testing/"
    @When("^user enters ([^\"]*) and ([^\"]*)")
    public void user_enters_username_and_Password(String username, String Password) throws Throwable {
    	driver.findElement(By.id("email")).sendKeys(username);
    	//driver.findElement(By.id("email")).sendKeys("blog.cucumber@gmail.com");
        //driver.findElement(By.id("passwd")).sendKeys("Cucumber@blog");
    	driver.findElement(By.id("passwd")).sendKeys(Password);
        driver.findElement(By.id("SubmitLogin")).click();   
    }
    
    @Then("^success message is populated$")
    public void success_message_is_displayed() throws Throwable {
    	String exp_message = "Welcome to your account. Here you can manage all of your personal information and orders.";
    	String actual = driver.findElement(By.cssSelector(".info-account")).getText();
        Assert.assertEquals(exp_message, actual);
        driver.quit();  
    }      
}