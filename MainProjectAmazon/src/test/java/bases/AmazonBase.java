

package bases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

import java.io.*;
import java.util.Properties;
import java.time.Duration;

public class AmazonBase{
	protected static WebDriver driver;
    public static Properties prop;

    public void loadprop() throws IOException {
    	FileInputStream propbj=new FileInputStream("C:\\Users\\ANJITHA\\Documents\\SeleniumMavenWorkspace\\MainProjectAmazon\\src\\test\\resources\\config.properties");
		prop=new Properties();
		prop.load(propbj);
        
    }

     @BeforeTest
    public void initialization() throws IOException {
        
    	loadprop();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(prop.getProperty("url"));
        try {
            System.out.println("Please solve the CAPTCHA (if present) within 30 seconds...");
            Thread.sleep(30); // wait for 30 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void tearDown() {
        if (driver != null) {
        	driver.quit();
        }
    }
}