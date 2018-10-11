package leverton.auto.task;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import coya.auto.task.page.CoyaPage;

public class CoyaPageTest {

	private WebDriver driver;

	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:/TestautoApp/chromedriver.exe");
		driver = new ChromeDriver();
	}

	@Test
	public void check_the_redirection_to_coyacare_page() {
		CoyaPage page = new CoyaPage(driver);
		page.goToHomePage();
		page.goToCoyaCarePage();

		assertThat(page.isRedirectionToCoyaCareSucceed()).isTrue();
	}

	@Test
	public void check_the_redirection_to_impressum_page() {
		CoyaPage page = new CoyaPage(driver);
		page.goToHomePage();
		page.goToImpressumPage();

		assertThat(page.isRedirectionToImpressumSucceed()).isTrue();
	}

	@Test
	public void check_english_language() {
		CoyaPage page= new CoyaPage(driver);
		page.goToHomePage();
		page.changeLanguageToEnglish();

		assertThat(page.isRedirectionToEnglishPageSucceed()).isTrue();
		assertThat(page.isLoginTextInEnglish()).isTrue();
		assertThat(page.isAboutUsTextInEnglish()).isTrue();

	}

	@Test
	public void check_german_language() {
		CoyaPage page = new CoyaPage(driver);
		page.goToHomePage();
		page.changeLanguageToEnglish();
		page.changeLanguageToGerman();

		assertThat(page.isLoginTextInGerman()).isTrue();
		assertThat(page.isAboutUsTextInGerman()).isTrue();

	}

	@Test
	public void Subscribe_with_invalid_email_should_fail() {
		CoyaPage page = new CoyaPage(driver);
		page.goToHomePage();
		page.fillEmailAddress("person@example.org");
		page.subscribeToNewsletter();

		assertThat(page.getErrorText()
				.contains("This email address looks fake or invalid. Please enter a real email address.")).isTrue();

	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
}