package automation;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PModel {

	@FindBy (xpath = "//*[text()='Home']" ) WebElement HomeTab;
	@FindBy(xpath ="//*[text()='Football']" ) WebElement FootballTab;
	@FindBy(xpath = "//*[text()='Busketball']")WebElement BusketBallTab;
	@FindBy(xpath = "//*[text()='Kriket']")WebElement KricketTab;
	@FindBy(xpath = "//*[text()='Cibersport']")WebElement CibersportTab;
	
}
