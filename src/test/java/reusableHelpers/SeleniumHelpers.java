package reusableHelpers;

import itRunner.InitConstants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

import java.io.File;
import java.io.IOException;

public class SeleniumHelpers extends InitConstants {

    public static void initiateBrowser() throws IOException {
        browserName = prop.getProperty("browser");
        headLess = Boolean.parseBoolean(prop.getProperty("headLess"));
        timeout = Integer.parseInt(prop.getProperty("timeout"));
        browser=BrowserConfiguration(browserName);
    }

    private static WebDriver BrowserConfiguration(String browserName) {
        WebDriver browserToOpen = null;
        if (browserName.toLowerCase().equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions options = new FirefoxOptions();
            options.setHeadless(headLess);
            browserToOpen = new FirefoxDriver(options);
        } else if (browserName.toLowerCase().equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
//            options.setBinary("C:/Program Files/Google/Chrome/Application/chrome.exe");
            options.setHeadless(headLess);
            options.addArguments("--window-size=1280,1700");
            browserToOpen = new ChromeDriver(options);
        } else if (browserName.toLowerCase().equalsIgnoreCase("ie")) {
            WebDriverManager.iedriver().setup();
            InternetExplorerOptions options = new InternetExplorerOptions();
            options.ignoreZoomSettings();
            options.destructivelyEnsureCleanSession();
            options.enablePersistentHovering();
            options.introduceFlakinessByIgnoringSecurityDomains();
            options.requireWindowFocus();
            browserToOpen = new InternetExplorerDriver(options);
        }
        return browserToOpen;
    }
}
