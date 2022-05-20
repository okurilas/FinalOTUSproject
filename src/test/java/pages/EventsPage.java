package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class EventsPage extends BasePage{

    @FindBy(css = "div.dod_new-events__list.js-dod_new_events")
    private WebElement eventsCalendarElement;
    @FindBys(@FindBy(xpath = "//div[contains(@class, 'dod_new-events__list')]/a"))
    private List<WebElement> eventsCalendarElements;

    @FindBys(@FindBy(xpath = "//span[contains(@class, 'dod_new-event__calendar-icon')]/following-sibling::span"))
    private List<WebElement> dateOfCources;
    @FindBy(css="span.dod_new-events-dropdown__input-selected")
    private WebElement sortBtn;
    @FindBy (css=".dod_new-events-dropdown__list-item[title='ДОД']")
    private WebElement dodEvent;
    @FindBy (css="div.dod_new-type__text")
    private WebElement dodEventResult;
    @FindBys(@FindBy(css="div.dod_new-type__text"))
    private List<WebElement> dodEventResults;

    @FindBy (css="div.footer2__links.footer2__links_center")
    private WebElement footer;

    @FindBy(xpath ="//div[contains(text(),'Открытый урок «UI Profiling. Обзор возможностей тестирования производительности приложений и инструментов оптимизации')]")
    private WebElement lastEvent;

    public EventsPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }


    public WebElement checkEventOnPage(){
        WebElement EventCalendarEl = wait.until(ExpectedConditions.elementToBeClickable(eventsCalendarElement));
        return EventCalendarEl;
    }

    public List <WebElement> checkEventsOnPage(){
        List <WebElement> EventsCalendarEl = wait.until(ExpectedConditions.visibilityOfAllElements(eventsCalendarElements));
        return EventsCalendarEl;
    }


    public ArrayList <Date> checkDatesOfEvents() throws ParseException, AWTException, InterruptedException {
//        actions = new Actions(driver);
//        actions
//                .sendKeys(Keys.SPACE)
//                .sendKeys(Keys.SPACE)
//                .perform();
//        Thread.sleep(2000);
//        actions
//                .sendKeys(Keys.SPACE)
//                .sendKeys(Keys.SPACE)
//                .perform();
//        Thread.sleep(2000);
//        actions
//                .sendKeys(Keys.SPACE)
//                .sendKeys(Keys.SPACE)
//                .perform();
//        Thread.sleep(2000);
//        actions
//                .sendKeys(Keys.SPACE)
//                .sendKeys(Keys.SPACE)
//                .perform();
//        Thread.sleep(2000);
//        actions
//                .sendKeys(Keys.SPACE)
//                .sendKeys(Keys.SPACE)
//                .perform();
//        Thread.sleep(2000);
//        actions
//                .sendKeys(Keys.SPACE)
//                .sendKeys(Keys.SPACE)
//                .perform();
//        Thread.sleep(2000);
//        actions
//                .sendKeys(Keys.SPACE)
//                .sendKeys(Keys.SPACE)
//                .perform();






//do {
//    JavascriptExecutor jse = (JavascriptExecutor)driver;
//    jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
//}
//while (!(wait.until(ExpectedConditions.visibilityOf(footer)).isDisplayed()));




//        boolean presentElement;
//        do {
//            JavascriptExecutor jse = (JavascriptExecutor)driver;
//            jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
//            logger.info("Промотали страницу");
//
//            //boolean presentElement;
//            try {
//                wait.until(ExpectedConditions.visibilityOf(lastEvent)).isDisplayed();
//                presentElement = true;
//                logger.info("Элемент найден");
//            } catch (TimeoutException e) {
//                presentElement = false;
//                logger.info("Элемент НЕ найден");
//            }
//        }
//        while (presentElement = false);
//        logger.info("вышли из цикла");





        while (!(driver.findElements( By.xpath("//div[contains(text(),'Открытый урок «UI Profiling. Обзор возможностей тестирования производительности приложений и инструментов оптимизации')]") ).size()!=0))
        {
            JavascriptExecutor jse = (JavascriptExecutor)driver;
            jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
            logger.info("Промотали страницу");
        }




//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", lastEvent);
//        Thread.sleep(500);


//        Robot robot = new Robot();
//        robot.keyPress(KeyEvent.VK_PAGE_DOWN);
//        robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
//        robot.keyPress(KeyEvent.VK_PAGE_DOWN);
//        robot.keyRelease(KeyEvent.VK_PAGE_DOWN);


        List<WebElement> DatesOfEvents = wait.until(ExpectedConditions.visibilityOfAllElements(dateOfCources));
        ArrayList<Date> ArrayDates = null;
        for (int i = 0; i < DatesOfEvents.size() - 1; i++) {
            String EventDateStr = DatesOfEvents.get(i).getText();
            SimpleDateFormat formatter1 = new SimpleDateFormat("dd MMM");
            Date date2 = formatter1.parse(EventDateStr);

            ArrayDates = new ArrayList<Date>();
            ArrayDates.add(date2);
            System.out.println(ArrayDates);
            continue;
        }
        return ArrayDates;
    }

    public void sortEvents(){
        wait.until(ExpectedConditions.elementToBeClickable(sortBtn))
                .click();
        wait.until(ExpectedConditions.elementToBeClickable(dodEvent))
                .click();

    }

    public List<WebElement> sortEventsCheck(){
    return wait.until(ExpectedConditions.visibilityOfAllElements(dodEventResults));
    }

}
