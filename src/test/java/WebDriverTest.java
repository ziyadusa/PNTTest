/**
 * Created with IntelliJ IDEA.
 * User: Mohammed Z. Azam
 * Date: 8/19/13
 * Time: 3:55 PM
 * To change this template use File | Settings | File Templates.
 */

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.List;
/**
 * Simple {@link RemoteWebDriver} test that demonstrates how to run your Selenium tests with <a href="http://ondemand.saucelabs.com/ondemand">Sauce OnDemand</a>.
 * *
 * @author Ross Rowe
 */
public class WebDriverTest {

    public WebDriver driver;

    @Before
    public void setUp() throws Exception {

        //DesiredCapabilities capabillities = DesiredCapabilities.iphone();
        DesiredCapabilities capabillities = DesiredCapabilities.firefox();
        capabillities.setCapability("version", "17");
        capabillities.setCapability("platform", Platform.XP);
        this.driver = new RemoteWebDriver(
                new URL("http://mzazam07:ff0ecc19-2836-4fd7-aa99-42752d74aa10@ondemand.saucelabs.com:80/wd/hub"),
                capabillities);
    }

    @Test
    public void basic() throws Exception {
        driver.get("http://www.cnn.com/");
        clickByCss("#nav-us>span");
        clickOnMenu("#cnn_mtt1rgtarea li");
    }



    public void clickByCss(String locator) {
        driver.findElement(By.cssSelector(locator)).click();
    }

    public void clickOnMenu(String locator) {
        List<WebElement> menuList = driver.findElements(By.cssSelector(locator));
        for (int i=1; i<menuList.size(); i++) {
            System.out.println(menuList.get(i).getText());
        }
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

}
