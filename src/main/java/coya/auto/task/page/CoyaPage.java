package coya.auto.task.page;

import static coya.auto.task.TestProperties.getHomePageUrl;
import static coya.auto.task.TestProperties.getImpreesumUrl;
import static coya.auto.task.TestProperties.getCoyaCareUrl;
import static coya.auto.task.TestProperties.getHomePageEnUrl;
import static org.openqa.selenium.By.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CoyaPage {

	private static final String POPUP_ID = "consest-popup";
	private static final String EMAILADD_ID = "mce-EMAIL";
	private static final String SUBSCRIBE_ID = "mc-embedded-subscribe";
	private static final String IMPRESSUM_XPATH = "//ul[@class='footer-links f-legal']/li[2]/a";
	private static final String COYACARE_XPATH = "//nav[@class='navigation']/ul/li[3]/a";
	private static final String EN_XPATH = "//ul[@class='lang-switcher']/li/a";
	private static final String ACCEPT_POPUP_XPATH = "/html/body/article/div/div/div[1]";
	private static final String DE_XPATH = "//ul[@class='lang-switcher']/li[@class='nav-item']/a";
	private static final String LOGIN_XPATH = "//ul[@class='app-nav']/li/a";
	private static final String ABOUT_US_XPATH = "//ul[@class='menu']/li[2]/a";
	private static final String ERROR_XPATH = "//div[@class='errorText']";

	private final WebDriver driver;

	public CoyaPage(WebDriver webDriver) {
		this.driver = webDriver;
	}

	public void goToHomePage() {
		driver.get(getHomePageUrl());
	}

	public void goToImpressumPage() {
		closePopIfExists();
		driver.findElement(xpath(IMPRESSUM_XPATH)).click();
	}

	public void closePopIfExists(){
		if (isPopupDisplayed()) {
			driver.findElement(xpath(ACCEPT_POPUP_XPATH)).click();
		}
	}
	public void goToCoyaCarePage() {
		driver.findElement(xpath(COYACARE_XPATH)).click();
	}

	public boolean isPopupDisplayed() {
		return driver.findElement(id(POPUP_ID)).isDisplayed();
	}

	public boolean isRedirectionToImpressumSucceed() {
		return driver.getCurrentUrl().contains(getImpreesumUrl());
	}

	public boolean isRedirectionToCoyaCareSucceed() {
		return driver.getCurrentUrl().contains(getCoyaCareUrl());
	}

	public boolean isRedirectionToEnglishPageSucceed() {
		return driver.getCurrentUrl().contains(getHomePageEnUrl());
	}

	public boolean isLoginTextInGerman() {
		WebElement element = driver.findElement(xpath(LOGIN_XPATH));
		return element.getText().contains("Anmelden");
	}

	public boolean isAboutUsTextInGerman() {
		WebElement element = driver.findElement(xpath(ABOUT_US_XPATH));
		return element.getText().contains("Über uns");
	}

	public boolean isLoginTextInEnglish() {
		WebElement element = driver.findElement(xpath(LOGIN_XPATH));
		return element.getText().contains("Login");
	}

	public boolean isAboutUsTextInEnglish() {
		WebElement element = driver.findElement(xpath(ABOUT_US_XPATH));
		return element.getText().contains("About us");
	}

	public void fillEmailAddress(String email) {
		driver.findElement(id(EMAILADD_ID)).sendKeys(email);
	}

	public void subscribeToNewsletter() {
		driver.findElement(id(SUBSCRIBE_ID)).submit();
	}

	public void changeLanguageToEnglish() {
		driver.findElement(xpath(EN_XPATH)).click();
	}

	public void changeLanguageToGerman() {
		driver.findElement(xpath(DE_XPATH)).click();
	}

	public String getErrorText() {
		 for(String winHandle : driver.getWindowHandles()){
	            driver.switchTo().window(winHandle);
	        }
			return driver.findElement(xpath(ERROR_XPATH)).getText();

	}
}