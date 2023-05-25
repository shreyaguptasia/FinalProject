package automation;

import java.io.FileOutputStream;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class FinalProject {
	
	public WebDriver driver;

	/*
	 * This method launches the Chrome browser and navigates to the given URL.
	 * WebDriver location and application URL is provided into excel sheet named
	 * 'AppLink'
	 * 
	 */
	@BeforeMethod
	public void launchapp() throws Exception { 

		
		driver = new ChromeDriver();
		driver.get("https://test-nf.com/english.html");
	}

	/*
	 * This method verifies the availability of tabs and their respective URLs and
	 * writes the results to an Excel file.
	 * 
	 * @throws Exception if any error occurs while performing the verification.
	 */
	@Test
	public void verifyelement() throws Exception {
		/*
		 * Scenario-2 : Verifying the Availability of Each Tab. Importing the Page
		 * Object Model From Different class to test the Availability of Element. Soft
		 * Assertion will proceed to next test case even if there is any element is not
		 * present. Print Method will show the availability message of tabs in Console
		 */
		PModel p = PageFactory.initElements(driver, PModel.class); 
		SoftAssert soft = new SoftAssert();

		// Verify availability of Home tab
		boolean HomeAvailable = p.HomeTab.isDisplayed();
		soft.assertEquals(HomeAvailable, true);
		System.out.println("Home Tab is Available");

		// Verify availability of Football tab
		boolean footballavailable = p.FootballTab.isDisplayed();
		soft.assertEquals(footballavailable, true);
		System.out.println("Football Tab is Available");

		// Verify availability of Basketball tab
		boolean basketballavail = p.BusketBallTab.isDisplayed();
		soft.assertEquals(basketballavail, true);
		System.out.println("BasketBall Tab is Available");

		// Verify availability of Cricket tab
		boolean Cricketavail = p.KricketTab.isDisplayed();
		soft.assertEquals(Cricketavail, true);
		System.out.println("Kriket Tab is Available");

		// Verify availability of CyberSport tab
		boolean cybersportavail = p.CibersportTab.isDisplayed();
		soft.assertEquals(cybersportavail, true);
		System.out.println("CiberSports Tab is Available");

		/*
		 * Storing the Current URL of Each Tab in Excel Sheet. 
		 * Creating boolean object to check whether the Tabs contains specified values. 
		 * Assert Method Will check whether specified value condition is true or not. 
		 * Print method will give the the current URL in console.
		 */

		// Scenario-3: Verify URL of each tab contains the tab name.

		// Click on Home tab and verify its URL
		p.HomeTab.click();
		Thread.sleep(2000);
		String Homeurl = driver.getCurrentUrl();
		System.out.println(Homeurl);
		boolean homecheck = Homeurl.contains("Home");
		soft.assertEquals(homecheck, true); //

		// Click on Football tab and verify its URL
		p.FootballTab.click();
		String FootballUrl = driver.getCurrentUrl();
		System.out.println(FootballUrl);
		boolean Footballcheck = FootballUrl.contains("Football");
		soft.assertEquals(Footballcheck, true);

		// Click on Basketball tab and verify its URL
		p.BusketBallTab.click();
		String BasketballUrl = driver.getCurrentUrl();
		System.out.println(BasketballUrl);
		boolean Basketballcheck = BasketballUrl.contains("busketball");
		soft.assertEquals(Basketballcheck, true);

		// Click on Cricket tab and verify its URL
		p.KricketTab.click();
		String CricketUrl = driver.getCurrentUrl();
		System.out.println(CricketUrl);
		boolean Cricketcheck = CricketUrl.contains("kriket");
		soft.assertEquals(Cricketcheck, true);

		// Click on CyberSport tab and verify its URL
		p.CibersportTab.click();
		String CyberUrl = driver.getCurrentUrl();
		System.out.println(CyberUrl);
		boolean Cybercheck = CyberUrl.contains("Cibersport");
		soft.assertEquals(Cybercheck, true);

		// Scenario-4:Store all the current URL in excel sheet.

		// Using FileOutputStream to Set the Excel sheet location on System.
		FileOutputStream f = new FileOutputStream("C:\\Users\\Shreya Gupta\\Documents\\FinalProject\\final.xls");

		// Opening a Writable workbook to store Excel sheet.
		WritableWorkbook wb = Workbook.createWorkbook(f);

		// Creating a Sheet on the Opened workbook.
		WritableSheet sheet = wb.createSheet("WebPage URL ", 1);

		// Creating Cell on the opened sheet to store the specified values.
		Label cell1 = new Label(0, 0, "Home Tab Url is: " + Homeurl);
		Label cell2 = new Label(0, 2, "Football Tab URL is: " + FootballUrl);
		Label cell3 = new Label(0, 3, "Busketball Tab URL is: " + BasketballUrl);
		Label cell4 = new Label(0, 4, "Kriket Tab URL is: " + CricketUrl);
		Label cell5 = new Label(0, 5, "CiberSport URL is: " + CyberUrl);

		// Adding the cell to the Opened Sheet
		sheet.addCell(cell1);
		sheet.addCell(cell2);
		sheet.addCell(cell3);
		sheet.addCell(cell4);
		sheet.addCell(cell5);

		// Saving the writable Workbook.
		wb.write();

		// Closing the Opened Workbook
		wb.close();

	}

	@AfterMethod // Using After method to close the window after every test case Execution
	public void closeapp() {

		driver.close();
	}


}
