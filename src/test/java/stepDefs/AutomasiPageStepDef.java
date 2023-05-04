package stepDefs;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.v112.webauthn.model.CredentialAsserted;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import PageClass.AutomasiPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AutomasiPageStepDef {

	WebDriver driver = Hooks.driver;
	AutomasiPage automasi = new AutomasiPage(driver);

	@Given("user lands on TestAutomasi website")
	public void user_lands_on_test_automasi_website() {

		System.out.println("Landed on Automasi Page");

	}

	@Given("click on elearning")
	public void click_on_elearning() {

		automasi.clickElearning();
	}

//	@When("user searches for course {string}")
//	public void user_searches_for_course_coursename(String courseName) {
//	}

//	@Then("verify title of course contains jmeter")
//	public void verify_title_of_course_contains_jmeter() {
//		System.out.println("Verified");
//	}
	
	
	@When("user clicks on search bar")
	public void user_clicks_on_search_bar() {
	   Set<String> windowHandles = driver.getWindowHandles();

		String mainWindowHandle = driver.getWindowHandle();
		for (String childWindowHandle : windowHandles) {
			if (!childWindowHandle.equals(mainWindowHandle)) {
				driver.switchTo().window(childWindowHandle);
				automasi.clickSearch();
		}
		}
	}

	@When("user searches for course {string}")
	public void user_searches_for_course_and_verify_title_of_course_contains_jmeter(String courseName) throws InterruptedException {
		automasi.enterCourseName(courseName);
		Thread.sleep(2000);
		System.out.println("Verified course Name");		
	}
	
	@Then("verify title of course contains {string}")
	public void verify_title_of_course_contains_jmeter(String course) {
	
		String actualCourseName = automasi.getCourseName();
		assertTrue(actualCourseName.contains(course));
	}
	
	@Then("click on View More button")
	public void click_on_view_more_button() {
		
	    automasi.clickViewMoreButton();
	}
	
	@Then("click on Buy More button")
	public void click_on_buy_more_button() {
	    
		automasi.clickBuyNowButton();
	}
	
	@Then("verify the error message")
	public void verify_the_error_message() {
		
		String actualMessage = automasi.getErrorMessage();
		String expectedMessage = "Please log in to enroll in the course!";
		assertEquals(expectedMessage, actualMessage);
	}
}
