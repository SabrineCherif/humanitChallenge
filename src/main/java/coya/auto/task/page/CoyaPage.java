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
	private static final String ACCEPT_POPUP_XPATH ="/html/body/article/div/div/div[1]";
    private static final String IMPRESSUM_XPATH = "/html/body/article/footer/div/ul[6]/li[2]/a";
    private static final String COYACARE_XPATH = "/html/body/article/header/div/nav/ul/li[3]/a";
    private static final String EN_XPATH="/html/body/article/header/div/div[2]/ul/li[1]/a";
	private static final String DE_XPATH="/html/body/article/header/div/div[2]/ul/li[3]/a";
	private static final String LOGIN_XPATH="/html/body/article/header/div/ul/li[1]/a";
	private static final String ABOUT_US_XPATH="/html/body/article/header/div/nav/ul/li[2]/a";
	private static final String ERROR_XPATH="/html/body/div[2]/form/div[1]/div";
	
    private final WebDriver driver;

    public CoyaPage(WebDriver webDriver) {
        this.driver = webDriver;
    }

    public void goToHomePage() {
        driver.get(getHomePageUrl());
    }

    public void goToImpressumPage() {
    	if (isPopupDisplayed()){
    		driver.findElement(xpath(ACCEPT_POPUP_XPATH)).click();
    	}

        driver.findElement(xpath(IMPRESSUM_XPATH)).click();
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
    
    public boolean isLoginTextInEnglish() {
        WebElement element =  driver.findElement(xpath(LOGIN_XPATH));
        String loginText = element.getText();
        if (loginText.contains("Login")){
        	return true;
        } else
        	return false;
    }
    
    public boolean isAboutUsTextInEnglish() {
        WebElement element =  driver.findElement(xpath(ABOUT_US_XPATH));
        String aboutusText = element.getText();
        if (aboutusText.contains("About us")){
        	return true;
        } else
        	return false;
    }
    
    public void fillEmailAddress(String email){
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

		//String winHandleBefore = driver.getWindowHandle();
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
		return driver.findElement(xpath(ERROR_XPATH)).getText();
		
	}
}
