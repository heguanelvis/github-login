package gh.login;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class App {
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", 
				"C:\\Users\\Guan He\\Workspace\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		String baseUrl = "https://github.com/login";

		driver.get(baseUrl);
		
		WebElement username = driver.findElement(By.id("login_field"));
		WebElement password = driver.findElement(By.id("password"));
		WebElement signin = driver.findElement(By.cssSelector("input[type='submit']"));

		final String useraccount;
		final String messageuf = "What is your username for GitHub?";
		final JTextField uf = new JTextField();
	    useraccount = JOptionPane.showConfirmDialog( null, uf, messageuf, 
	    JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE ) == JOptionPane.OK_OPTION 
	      ? new String( uf.getText() ) : ""; 
		
		final String userpassword;
		final String messagepf = "What is your password for GitHub?";
	    final JPasswordField pf = new JPasswordField(); 
	    userpassword = JOptionPane.showConfirmDialog( null, pf, messagepf, 
	    JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE ) == JOptionPane.OK_OPTION 
	      ? new String( pf.getPassword() ) : ""; 
		
		username.sendKeys(useraccount);
		password.sendKeys(userpassword);
		signin.click();
	}
	
}
