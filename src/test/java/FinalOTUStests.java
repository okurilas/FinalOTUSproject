import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.CoursePage;
import pages.EventsPage;
import pages.OTUSstartPage;

import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class FinalOTUStests {

    private Logger logger = LogManager.getLogger(FinalOTUStests.class);/////////////////////////////////
    private WebDriver driver;
    private WebDriverWait wait;
    private ChromeOptions options = new ChromeOptions();//////////////////////////////////
    private Actions actions;


    @Before
    public void setUp(){
        String brName = System.getProperty("br");
        logger.info("драйвер поднят");
        //init();
    }

    @After
    public void close(){
        if (driver!=null) {
            driver.close();
            driver.quit();
        }
    }


    @Test
    public void checkNumberOfCourcesInTestingTab() {

        logger.info("Открыть website OTUS в режиме полного экрана");

        options.addArguments("start-fullscreen");
        init(options);
        OTUSstartPage otusStartPage = new OTUSstartPage(driver, wait);
        WebElement headerOTUS = otusStartPage.open();
        Assert.assertTrue(headerOTUS.isEnabled());

        logger.info("Тест 01. Проверка количества курсов в разделе тестирование");
        Integer numberOfCources = otusStartPage.openTestingCourse();
        Assert.assertEquals(Integer.valueOf(11),numberOfCources);

//        1 Пользователь переходит в разделе тестирование
//        2 На странице отображаются карточки курсов. Количество карточек равно 11

    }

    @Test
    public void checkCourcesDescription()  {

        logger.info("Открыть website OTUS");

        options.addArguments("start-fullscreen");
        init(options);
        OTUSstartPage otusStartPage = new OTUSstartPage(driver, wait);
        WebElement headerOTUS = otusStartPage.open();
        Assert.assertTrue(headerOTUS.isEnabled());

        logger.info("Тест 02. Просмотр карточки курса");
        otusStartPage.openOneTestingCourse();

        CoursePage coursePage = new CoursePage(driver, wait);

        Assert.assertTrue(coursePage.checkCourseName().isDisplayed());
        Assert.assertTrue(coursePage.checkCourseDescription().isDisplayed());
        Assert.assertTrue(coursePage.checkCourseDuration().isDisplayed());
        Assert.assertTrue(coursePage.checkCourseDurationValue().isDisplayed());
        Assert.assertTrue(coursePage.checkCourseFormat().isDisplayed());
        Assert.assertTrue(coursePage.checkCourseFormatValue().isDisplayed());

//        1 Пользователь переходит на карточку курса
//        2 В карточке указана информация о курсе:
//        - Название
//        - Описание
//        - Длительность обучения
//        - Формат
//        (Минимально достаточное - проверить одну карточку. В идеале все в разделе тестирования.)


    }




//    @Test
//    public void checkAllCourcesDescription()  {
//
//        logger.info("Открыть website OTUS");
//
//        options.addArguments("start-fullscreen");
//        init(options);
//        OTUSstartPage otusStartPage = new OTUSstartPage(driver, wait);
//        WebElement headerOTUS = otusStartPage.open();
//        Assert.assertTrue(headerOTUS.isEnabled());
//
//        logger.info("Тест 02. Просмотр карточки курса");
//        otusStartPage.openEachTestingCourse();
//
//        CoursePage coursePage = new CoursePage(driver, wait);
//
//        Assert.assertTrue(coursePage.checkCourseName().isDisplayed());
//        Assert.assertTrue(coursePage.checkCourseDescription().isDisplayed());
//        Assert.assertTrue(coursePage.checkCourseDuration().isDisplayed());
//        Assert.assertTrue(coursePage.checkCourseDurationValue().isDisplayed());
//        Assert.assertTrue(coursePage.checkCourseFormat().isDisplayed());
//        Assert.assertTrue(coursePage.checkCourseFormatValue().isDisplayed());
//
////        1 Пользователь переходит на карточку курса
////        2 В карточке указана информация о курсе:
////        - Название
////        - Описание
////        - Длительность обучения
////        - Формат
////        (Минимально достаточное - проверить одну карточку. В идеале все в разделе тестирования.)
//
//
//    }

    @Test
    public void checkEventsDates() throws ParseException, AWTException, InterruptedException {

        logger.info("Открыть website OTUS");

        options.addArguments("start-fullscreen");
        init(options);
        OTUSstartPage otusStartPage = new OTUSstartPage(driver, wait);
        WebElement headerOTUS = otusStartPage.open();
        Assert.assertTrue(headerOTUS.isEnabled());

        logger.info("Тест 03. Валидация дат предстоящих мероприятий");

        otusStartPage.openEvents();
        EventsPage eventsPage = new EventsPage(driver, wait);
        List<WebElement> EventsOnPageElem = eventsPage.checkEventsOnPage();
        Assert.assertFalse(EventsOnPageElem.isEmpty());

        List<Date> DateOfEventOnPage = eventsPage.checkDatesOfEvents();

        Date date = new Date();
        String today = String.valueOf(date);
        String todayDate = today.substring(4, 10);
        SimpleDateFormat formatter = new SimpleDateFormat("MMM dd", Locale.ENGLISH);
        Date dateToday = formatter.parse(todayDate);

        for (int i = 0; i < DateOfEventOnPage.size() - 1; i++) {
            Assert.assertTrue(dateToday.before(DateOfEventOnPage.get(i)));
            Assert.assertTrue(dateToday.before(DateOfEventOnPage.get(i)) || dateToday.equals(DateOfEventOnPage.get(i)));
        }

//        1 Пользователь переходит в раздел События -> Календарь мероприятий
//        2 На странице отображаются карточки предстоящих мероприятий.
//        3 Даты проведения мероприятий больше или равны текущей дате


    }

    @Test
    public void checkEventsType() {

        logger.info("Открыть website OTUS");

        options.addArguments("start-fullscreen");
        init(options);
        OTUSstartPage otusStartPage = new OTUSstartPage(driver, wait);
        WebElement headerOTUS = otusStartPage.open();
        Assert.assertTrue(headerOTUS.isEnabled());

        logger.info("Тест 04. Просмотр мероприятий по типу");

        otusStartPage.openEvents();
        EventsPage eventsPage = new EventsPage(driver, wait);

        eventsPage.sortEvents();
        //WebElement EventsOnPageElem = eventsPage.checkEventOnPage();
        //Assert.assertTrue(EventsOnPageElem.isDisplayed());
        List <WebElement> EventsOnPageElem = eventsPage.checkEventsOnPage();
        Assert.assertFalse(EventsOnPageElem.isEmpty());

//        String EventType = eventsPage.sortEventsCheck().getText();
//        Assert.assertEquals("День открытых дверей",EventType);/////////////////


        //ArrayList<String> ArrayTypes = null;
        for (int i = 0; i < eventsPage.sortEventsCheck().size() - 1; i++) {
//            String TypeOfEvent = eventsPage.sortEventsCheck().get(i).getText();
//            ArrayTypes = new ArrayList<String>();
//            ArrayTypes.add(TypeOfEvent);
//            System.out.println(ArrayTypes);
            Assert.assertEquals("День открытых дверей",eventsPage.sortEventsCheck().get(i).getText());
            continue;
        }

//        1 Пользователь переходит в раздел События -> Календарь мероприятий
//        2 Пользователь сортирует мероприятия по типу ДОД
//        3 На странице отображаются карточки предстоящих мероприятий.
//        На каждой карточке в типе указанно "День открытых дверей"


    }

    private void init(ChromeOptions options){
        //driver = WebDriverFactory.getDriver(Browsers.CHROME);
        WebDriverManager.chromedriver().setup();///////////////////////////////////////
        driver = new ChromeDriver(options);////////////////////////////////////////////
        logger.info("драйвер поднят");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actions = new Actions(driver);
    }


}
