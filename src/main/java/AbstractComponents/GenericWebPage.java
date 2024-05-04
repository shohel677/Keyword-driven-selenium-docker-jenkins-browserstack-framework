package AbstractComponents;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;

import static DataLoader.TestEssentials.*;


public class GenericWebPage {
    public static WebDriver instanceDriver;

    public static WebDriver getInstanceDriver(String testOnBrowser, String testOnPlatform) throws MalformedURLException {
        if (instanceDriver == null) {
            DesiredCapabilities cap = new DesiredCapabilities();
            String url = "http://localhost:4444/wd/hub";

            if (testOnBrowser.contains("chrome")) {
                if(testOnPlatform.contains("linux")){
                    cap.setBrowserName("chrome");
                    cap.setPlatform(Platform.LINUX);
                    instanceDriver = new RemoteWebDriver(new URL(url), cap);
                }
                else{
                    ChromeOptions options = new ChromeOptions();
                    WebDriverManager.chromedriver().setup();
                    if (testOnBrowser.contains("headless")) {
                        options.addArguments("headless");
                    }
                    instanceDriver = new ChromeDriver(options);
                }
            } else if (testOnBrowser.contains("firefox")) {

                 if(testOnPlatform.contains("linux")){
                    cap.setBrowserName("firefox");
                    cap.setPlatform(Platform.LINUX);
                    instanceDriver = new RemoteWebDriver(new URL(url), cap);
                }
                else{
                    WebDriverManager.firefoxdriver().setup();
                    instanceDriver = new FirefoxDriver();
                }
            } else if (testOnBrowser.contains("edge")) {
                if(testOnPlatform.contains("linux")){
                    cap.setBrowserName("MicrosoftEdge");
                    cap.setPlatform(Platform.LINUX);
                    instanceDriver = new RemoteWebDriver(new URL(url), cap);
                }
                else{
                    WebDriverManager.edgedriver().setup();
                    instanceDriver = new EdgeDriver();
                }
            } else if (testOnBrowser.contains("safari")) {
                WebDriverManager.safaridriver().setup();
                instanceDriver = new SafariDriver();
            }
        }
        return instanceDriver;
    }
    public static Logger logger = LogManager.getLogger();


}

