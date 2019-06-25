package Objects;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NoteMainPage {

    private static final String url = "https:www.anotepad.com/";
    private static final By noteTitle = By.id("edit_title");
    private static final By noteContent = By.id("edit_textarea");
    private static final By saveTitleButton = By.xpath("//*[@id='btnSaveNote']");
    private static final By deleteButton = By.cssSelector(".delete");

    private WebDriver driver;
    private WebDriverWait wait;
    //private Alert alert;

    public NoteMainPage (WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver,10);
    }

    public NoteMainPage open() {
        driver.get(url);
        return this;
    }

    public NoteMainPage setTitle(String title) {

        driver.findElement(noteTitle).sendKeys(title);
        return this;
    }
    public NoteMainPage setContent(String content) {
        driver.findElement(noteContent).clear();
        driver.findElement(noteContent).sendKeys(content);
        return this;
    }

    public NoteMainPage addContent(String content) {
        driver.findElement(noteContent).sendKeys(content);
        return this;
    }
    public NoteMainPage saveNote(){
        driver.findElement(saveTitleButton).click();
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("p.alert.alert-warning"),"You have saved your note as a"));
        return this;
    }
    public String getNoteContent() {
        return driver.findElement(noteContent).getAttribute("value");
    }

    public NoteMainPage deleteNote() {
        driver.findElement(deleteButton).click();
        //alert = wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert();
        alert.accept();
        return this;
    }
        public NoteMainPage findSavedNote(String title){
        driver.findElement(By.linkText(title)).getText();
            return this;
        }

}
