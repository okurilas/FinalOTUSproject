package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

    @FindBy(xpath ="//div[contains(text(),'Spark в Kubernetes')]")
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

//    public Date checkDatesOfEvents() throws ParseException, AWTException {
////        actions = new Actions(driver);
////        actions
////                .sendKeys(Keys.SPACE)
////                .sendKeys(Keys.SPACE)
////                .perform();
//
////        JavascriptExecutor jse = (JavascriptExecutor)driver;
////        jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
//
//        Robot robot = new Robot();
//        robot.keyPress(KeyEvent.VK_PAGE_DOWN);
//        robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
//
//        List <WebElement> DatesOfEvents = wait.until(ExpectedConditions.visibilityOfAllElements(dateOfCources));
//        for(int i = 0; i < DatesOfEvents.size()-1; i++) {
//            //System.out.println(DatesOfEvents.get(i).getText());
//            String EventDateStr = DatesOfEvents.get(i).getText();
//            SimpleDateFormat formatter1 = new SimpleDateFormat("dd MMM");
//            Date date2 = formatter1.parse(EventDateStr);
//
//            ArrayList <Date> ArrayDates = new ArrayList<Date>();
//            ArrayDates.add(date2);
//            System.out.println(ArrayDates);
//
//        }
//
//        String EventDateStr = DatesOfEvents.get(0).getText();
//        SimpleDateFormat formatter1 = new SimpleDateFormat("dd MMM");
//        Date date2 = formatter1.parse(EventDateStr);
//
//        return date2;
//    }







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

do {
    JavascriptExecutor jse = (JavascriptExecutor)driver;
    jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    //Thread.sleep(1000);
}
while (!(wait.until(ExpectedConditions.visibilityOf(footer)).isDisplayed()));



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
//    public WebElement sortEventsCheck(){
//        //System.out.println(dodEventResult.getText());
//        return wait.until(ExpectedConditions.elementToBeClickable(dodEventResult));
//    }
public List<WebElement> sortEventsCheck(){
    //System.out.println(dodEventResult.getText());
    return wait.until(ExpectedConditions.visibilityOfAllElements(dodEventResults));
}

//    public void testDates() throws ParseException {
//
//        SimpleDateFormat formatter1 = new SimpleDateFormat("MMM dd", Locale.ENGLISH);
//        SimpleDateFormat formatter2 = new SimpleDateFormat("dd MMM");
//
//        String dateInString2 = "07 Июня";
//        String dateInString3 = "07 Июня";
//        Date date = new Date();
//        String today = String.valueOf(date);
//        String today2 = today.substring(4, 10);
//        Date date2 = formatter2.parse(dateInString2);
//        Date date3 = formatter2.parse(dateInString3);
//        Date dateToday = formatter1.parse(today2);
//        System.out.println(date2);
//        System.out.println(date3);
//        System.out.println(dateToday);
//
//        System.out.println("Сегодня " + dateToday + " - это раньше, чем " + date2 + dateToday.before(date2));
//        System.out.println("Сегодня " + dateToday + " - это раньше, чем " + date3 + dateToday.before(date3));
//        System.out.println("7ое мая " + date2 + " - это раньше, чем " + date3 + date2.before(date3));
//        System.out.println("7ое июня " + date3 + " - это раньше, чем " + date2 + date3.before(date2));
//        System.out.println(date3 + " тоже самое что и " + date2 + date3.equals(date2));
//        System.out.println(dateToday + " тоже самое что и " + date2 + dateToday.equals(date2));
//    }

}
