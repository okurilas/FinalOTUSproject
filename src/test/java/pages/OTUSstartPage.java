package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OTUSstartPage extends BasePage {

    @FindBy(css = ".header2__logo")
    private WebElement otusHeader;
    @FindBy (xpath = "//p[contains(text(),'Курсы')]")
    private WebElement courcesBtn;
    @FindBy (css = "a[title='Тестирование'].header2-menu__dropdown-link")
    private WebElement testingCourse;
    @FindBys(@FindBy(css = ".js-stats.lessons__new-item.lessons__new-item_hovered"))
    private List<WebElement> numberOfCourcesOnPage;
    @FindBy (css = "div.lessons__new-item-container")
    private WebElement coursesOnPage;


    @FindBys(@FindBy (css = "div.lessons__new-item-container"))
    private List<WebElement> coursesOnThePage;


    @FindBy (xpath = "//p[contains(text(),'События')]")
    private WebElement eventsBtn;
    @FindBy (css = "a[title='Календарь мероприятий'].header2-menu__dropdown-link")
    private WebElement eventsCalendar;


    public OTUSstartPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement open () {
        driver.get(cfg.urlOTUS());

        logger.info("Открыли сайт Отус и ждём минуту");
        logger.info("минута прошла");
        WebElement headerOTUS = wait.until(ExpectedConditions.elementToBeClickable(otusHeader));
        return headerOTUS;
    }

    public Integer openTestingCourse(){
        wait.until(ExpectedConditions.elementToBeClickable(courcesBtn))
                .click();
        wait.until(ExpectedConditions.elementToBeClickable(testingCourse))
                .click();
        List<WebElement> NumberOfCourcesOnPage=numberOfCourcesOnPage;
        return NumberOfCourcesOnPage.size();
    }

    public void openOneTestingCourse(){
        openTestingCourse();
        wait.until(ExpectedConditions.elementToBeClickable(coursesOnPage))
                .click();

    }

    public void openEachTestingCourse(){
        openTestingCourse();
        List<WebElement> NumberOfCourcesOnPage=numberOfCourcesOnPage;
        System.out.println(NumberOfCourcesOnPage.size());
        for (int i = 0; i < NumberOfCourcesOnPage.size() - 1; i++) {
            coursesOnThePage.get(i).click();
        }
    }

    public void openEvents(){
        wait.until(ExpectedConditions.elementToBeClickable(eventsBtn))
            .click();
        wait.until(ExpectedConditions.elementToBeClickable(eventsCalendar))
                .click();

    }

}
