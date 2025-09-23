package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PIMPage extends BasePage {
	 private By addEmployee = By.xpath("//a[text()='Add Employee']");
	    private By firstName = By.name("firstName");
	    private By lastName  = By.name("lastName");
	    private By saveBtn   = By.xpath("//button[@type='submit']");
	    private By employeeList = By.xpath("//a[text()='Employee List']");

	    public PIMPage(WebDriver driver) {
	        super(driver);
	    }

	    public void addEmployee(String fName, String lName) {
	        click(addEmployee);
	        type(firstName, fName);
	        type(lastName, lName);
	        click(saveBtn);
	    }

	    public void openEmployeeList() {
	        click(employeeList);
	    }


}
