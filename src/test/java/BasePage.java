
import com.thoughtworks.gauge.Step;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;
import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static java.time.Duration.ofMillis;


public class BasePage extends BaseTest {
    WebDriverWait waitForElement = new WebDriverWait(appiumDriver,10);

    FluentWait<WebDriver> wait;
    Logger logger = LogManager.getLogger(BasePage.class);
    String id;

    @Step("App is opened")
    public void isOpened() {
        System.out.println("Ozdilek App started");
        logger.info("Ozdilek is Started");

    }

    @Step("<id> App is checked")
    public void isChecked(String id) {
        appiumDriver.findElement(By.id(id)).isDisplayed();
        waitForElement.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id(id)));
        logger.info("App is Checked");

    }

    @Step("<wait> second waited")
    public void waitForseconds(int wait) throws InterruptedException {
        Thread.sleep(1000 * wait);
    }

    @Step("<id> is clicked")
    public void clickByid(String id) {
        appiumDriver.findElement(By.id(id)).click();
        System.out.println(id + "is clicked");
        logger.info("Started to shopping is clicked");
    }

    @Step("<id> Shopping is checked")
    public void shoppingStarted(String xpath) {
        appiumDriver.findElement(By.xpath(xpath)).isDisplayed();
        waitForElement.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpath)));
        logger.info("Shopping is checked");

    }

    @Step("<id> Categories are clicked")
    public void clickCategories(String id) {
        appiumDriver.findElement(By.id(id)).click();
        System.out.println(id + "is clicked");
    }

    @Step("<id> Categories are checked")
    public void checkedCategories(String id) {
        appiumDriver.findElement(By.id(id)).isDisplayed();
        waitForElement.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id(id)));
        logger.info("Categories are checked");
    }

    @Step("<xpath> Clicked to Kadın item")
    public void clickKadinItem(String xpathItem) {
        appiumDriver.findElement(By.xpath(xpathItem)).click();
        System.out.println(xpathItem + "is clicked");
    }

    @Step("<xpath> Clicked to Pantolon item")
    public void clickedPantolonItem(String xpathItem) {
        appiumDriver.findElement(By.xpath(xpathItem)).click();

    }

    @Step("Scroll <times> to subside on page and <wait> sec")
    public void scroll(int times, int wait) throws InterruptedException {
        for (int i = 0; i < times; i++) {
            TouchAction scroll = new TouchAction(appiumDriver)
                    .press(PointOption.point(530, 1900))
                    .waitAction(waitOptions(ofMillis(800)))
                    .moveTo(PointOption.point(530, 350))
                    .release()
                    .perform();
            Thread.sleep(1000 * wait);
        }
        logger.info("Scrolling is successed");
    }

    @Step("Select random product <xpath>")
    public void selectRondamproduct(String xpath) {
        Random rdn = new Random();
        List<MobileElement> pd = appiumDriver.findElements(By.xpath(xpath));
        System.out.println("pd" + pd);
        MobileElement element = pd.get(rdn.nextInt(pd.size()));
        System.out.println("element" + element);
        element.click();
        logger.info("random product is selected");
    }

    @Step("Checked <id> product page detail")
    public void checkedProductDetailPage(String id) {
        appiumDriver.findElement(By.id(id)).isDisplayed();
    }

    @Step("Click to Favorites <id>")
    public void favoritesButtonClicked(String id) {
        appiumDriver.findElement(By.id(id)).click();
    }

    @Step("Checked to Login Page <id>")
    public void checkedLoginPage(String id) {
        appiumDriver.findElement(By.id(id)).isDisplayed();
    }

    @Step("Write your email <id>")
    public void writeYourEmail(String id) {
        appiumDriver.findElement(By.id(id)).sendKeys("text");
    }

    @Step("Write your password <id>")
    public void writeYourPassword(String id) {
        appiumDriver.findElement(By.id(id)).sendKeys("1234");

    }

    @Step("Click to BackButton <id>")
    public void clickBackButton(String id) {
        appiumDriver.findElement(By.id(id)).click();

    }

    @Step("Select random product again <xpath>")
    public void selectRondamproductAgain(String xpath) {
        Random rdn = new Random();
        List<MobileElement> pd = appiumDriver.findElements(By.xpath("//*[@class= 'android.widget.ImageView']"));
        System.out.println("pd" + pd);
        MobileElement element = pd.get(rdn.nextInt(pd.size()));
        System.out.println("element" + element);
        element.click();
        logger.info("random product is selected");

    }
    @Step("Add to cart <id>")
    public void addToCart(String id){
        appiumDriver.findElement(By.id(id)).click();
        logger.info("Automation is finished");
    }
}