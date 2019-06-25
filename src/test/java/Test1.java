import Objects.NoteMainPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test1 {

    WebDriver driver;
    WebDriverWait wait;
    NoteMainPage noteMainPage;

    @Before
    public void openBrowser() {
        WebDriverManager.chromedriver().version("75").setup();
        driver = new ChromeDriver();
        noteMainPage = new NoteMainPage(driver);
        //driver.get(url);
    }
    @Ignore
    @Test
    public void test() {
        String note = "My First Note";
        String title = "My First Note";
        noteMainPage.open()
                .setTitle(title)
                .setContent(note)
                .saveNote();
        Assert.assertEquals(note,noteMainPage.getNoteContent());
        noteMainPage.deleteNote();
    }
    @Ignore
    @Test
    public void testHW1() {
        String note = "My First Note";
        String title = "My First Note";
        noteMainPage.open()
                .setTitle(title)
                .setContent(note)
                .saveNote()
                .deleteNote();
        Assert.assertEquals("No note here.",driver.findElement(By.className("saved_notes")).getText());


    }
    @Ignore
    @Test
    public void noteTitleEquel4symbols() {
        String notetitle = "1234";
        noteMainPage.open()
                .setTitle(notetitle)
                .setContent(notetitle)
                .saveNote();
                //.findSavedNote(notetitle);
        Assert.assertEquals(notetitle,driver.findElement(By.linkText("1234")).getText());
        noteMainPage.deleteNote();

    }
    //@Ignore
    @Test
    public void noteTitleEquel100symbols() {
        String notetitle = "1234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890";
        noteMainPage.open()
                .setTitle(notetitle)
                .setContent(notetitle)
                .saveNote();
                //.findSavedNote(notetitle);
        Assert.assertEquals(notetitle,driver.findElement(By.linkText(notetitle)).getText());
        noteMainPage.deleteNote();

    }



    @After
    public void driverQuit() {
        driver.quit();
}
}

