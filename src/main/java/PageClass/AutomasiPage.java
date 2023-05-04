package PageClass;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class AutomasiPage {
	
	WebDriver driver;
	WebDriverWait wait;
	
//	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	
	@FindBy (xpath = "//div[@id='navbarNav']/ul/li//a[text()='E-Learning']")
	WebElement elearning;
	
	@FindBy (xpath = "//input[@placeholder='Search courses...']")
	WebElement search;
	
	@FindBy (xpath = "//div[@class='course-item']//span[@class='course-instructor']/following-sibling::a")
	WebElement courseName;
	
	@FindBy (xpath = "//div[@class='course-readmore']//a")
	WebElement viewMoreButton;
	
	@FindBy (xpath = "//button[contains(text(),'Buy Now')]")
	WebElement buyNow;
	
	@FindBy (xpath = "//div[@class='learn-press-message error']")
	WebElement verifyText;
	
	public AutomasiPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
	}
	

	public void clickElearning() {
		elearning.click();
	}
	

	
	public void clickSearch() {
		wait.until(ExpectedConditions.visibilityOf(search));
		search.click();
	}
	
	public void enterCourseName(String name) {
		search.sendKeys(name);
	}
	
	public String getCourseName() {
		
		String name = courseName.getText();
		System.out.println(name);
		return name;
	}
	
	public void clickViewMoreButton() {
		
		viewMoreButton.click();
	}
	
	public void clickBuyNowButton() {
		
		buyNow.click();
		wait.until(ExpectedConditions.visibilityOf(verifyText));
	}
	
	public String getErrorMessage() {
		
		String message = verifyText.getText();
		return message;
	}
	
}
