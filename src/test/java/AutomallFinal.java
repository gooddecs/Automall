import Automall.LoginPageFinal;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;

public class AutomallFinal {
    public static void main(String[] args) throws IOException {
        System.setProperty("webdriver.chrome.driver", "c:\\tools\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://automall.md/");

        LoginPageFinal login = new LoginPageFinal(driver);
        driver.quit();

    }
}
