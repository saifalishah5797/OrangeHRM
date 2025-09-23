package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage extends BasePage{
	 private By pimMenu = By.xpath("//span[text()='PIM']");

	    public DashboardPage(WebDriver driver) {
	        super(driver);
	    }

	    public void openPIM() {
	        click(pimMenu);
	    }

}
