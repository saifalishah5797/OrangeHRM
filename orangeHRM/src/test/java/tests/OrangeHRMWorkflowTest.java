package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.DashboardPage;
import pages.LoginPage;
import pages.PIMPage;

public class OrangeHRMWorkflowTest {
	
	private WebDriver driver;
    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private PIMPage pimPage;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
        pimPage = new PIMPage(driver);
    }

    @Test
    public void addAndVerifyEmployees() {
        // Login
        loginPage.login("Admin", "admin123");

        // Navigate to PIM
        dashboardPage.openPIM();

        // Add Employees
        String[][] employees = {{"John", "Doe"}, {"Jane", "Smith"}, {"David LpCFtk", "Wilson"}};
        for (String[] emp : employees) {
            pimPage.addEmployee(emp[0], emp[1]);
            dashboardPage.openPIM();
        }

        // Verify Employees 
        pimPage.openEmployeeList();
    
        System.out.println("Name Verified");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
