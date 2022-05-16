package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CoursePage extends BasePage{

    @FindBy(css = "div.course-header2__title")
    private WebElement courseName;
    @FindBy(css = "div.course-header2__admin-text")
    private WebElement courseDescription;
    @FindBy(xpath ="//p[contains(text(),'Длительность обучения:')]")
    private WebElement courseDuration;
    @FindBy(xpath="//p[contains(text(),'Длительность обучения:')]/../../following-sibling::div/div/p")
    private WebElement courseDurationValue;
    @FindBy(xpath ="//p[contains(text(),'Формат:')]")
    private WebElement courseFormat;
    @FindBy(xpath ="//p[contains(text(),'Формат:')]/../../following-sibling::div/div/p")
    private WebElement courseFormatValue;

    public CoursePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }


    public WebElement checkCourseName(){
        WebElement CourseName = wait.until(ExpectedConditions.elementToBeClickable(courseName));
        return CourseName;
    }

    public WebElement checkCourseDescription(){
        WebElement CourseDescription = wait.until(ExpectedConditions.visibilityOf(courseDescription));
        return CourseDescription;
    }

    public WebElement checkCourseDuration(){
        WebElement durationOfCourse = wait.until(ExpectedConditions.visibilityOf(courseDuration));
        return durationOfCourse;
    }

    public WebElement checkCourseDurationValue(){
        WebElement durationValueOfCourse = wait.until(ExpectedConditions.visibilityOf(courseDurationValue));
        return durationValueOfCourse;
    }
    public WebElement checkCourseFormat(){
        WebElement FormatOfCourse = wait.until(ExpectedConditions.visibilityOf(courseFormat));
        return FormatOfCourse;
    }

    public WebElement checkCourseFormatValue(){
        WebElement FormatValueOfCourse = wait.until(ExpectedConditions.visibilityOf(courseFormatValue));
        return FormatValueOfCourse;
    }
}
