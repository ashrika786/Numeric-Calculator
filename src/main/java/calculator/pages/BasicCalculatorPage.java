package calculator.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

/**
 * Holds objects and methods to work with Calculator page
 * @author Ashrika Agarwal
 *
 */
public class BasicCalculatorPage {
	
	@FindBy(id="selectBuild")
	private WebElement buildDropdown;
	@FindBy(id="number1Field")
	private WebElement firstNumber;
	@FindBy(id="number2Field")
	private WebElement secondNumber;
	@FindBy(id="selectOperationDropdown")
	private WebElement operationDropdown;
	@FindBy(id="calculateButton")
	private WebElement calculateButton;
	@FindBy(id="numberAnswerField")
	private WebElement answerField;
	@FindBy(id="integerSelect")
	private WebElement integersCheckbox;
	@FindBy(id="clearButton")
	private WebElement clearButton;
	@FindBy(id="errorMsgField")
	private WebElement errorMessage;
	
	WebDriver driver;
	Actions action;
	JavascriptExecutor js ;
	
	public BasicCalculatorPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		action = new Actions(driver);
		js = (JavascriptExecutor) driver;
	}
	
	// Scroll webpage down
	public void scrollIntoView() {
		js.executeScript("arguments[0].scrollIntoView();", buildDropdown);
	}
	
	// Select Dropdown for build
	public void selectBuild(String build) {
		Select buildValue = new Select(buildDropdown);
		buildValue.selectByVisibleText(build);
	}
	
	// Steps to perform operation without Integer only result
	public void performOperation(String val1,String val2,String operation) throws InterruptedException {
		firstNumber.clear();
		secondNumber.clear();
		clearButton.click();
		firstNumber.sendKeys(val1);
		secondNumber.sendKeys(val2);
		Select operationValue = new Select(operationDropdown);
		operationValue.selectByVisibleText(operation);
		calculateButton.click();
		Thread.sleep(2000);
	}
	
	// Steps to perform operation without Integer only result
	public void performOperationInteger(String val1,String val2,String operation) throws InterruptedException {
		firstNumber.clear();
		secondNumber.clear();
		clearButton.click();
		firstNumber.sendKeys(val1);
		secondNumber.sendKeys(val2);
		Select operationValue = new Select(operationDropdown);
		operationValue.selectByVisibleText(operation);
		integersCheckbox.click();
		calculateButton.click();
		Thread.sleep(2000);
	}
	
	// Retrieve result shown on UI
	public String getResult() {
		return answerField.getAttribute("value");
	}
	
	// Retrieve error message shown
	public String getErrorMessage() {
		return errorMessage.getText();
	}
	
}
