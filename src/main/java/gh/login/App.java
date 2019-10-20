package gh.login;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class App {
	
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = setUpDriver();
		
		Login logger = new Login();
		List<String> repoHrefs = logger.githubLogin(driver);
		
		InfoGetter infoGetter = new InfoGetter();
		infoGetter.acquireInfo(repoHrefs);
	}
	
	public static WebDriver setUpDriver () {
		System.setProperty("webdriver.chrome.driver", 
				"C:\\Users\\Guan He\\Workspace\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--window-position=-32000,-32000");
		WebDriver driver = new ChromeDriver(options);
		return driver;
	}
	
}
