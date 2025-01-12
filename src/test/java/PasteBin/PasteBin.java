package PasteBin;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page.pageObjectPasteBin.PasteBinHomePage;

public class PasteBin {

    private WebDriver driver;

    @Test
    public void testCreateNewPaste(){
        driver = new ChromeDriver();
        driver.get("https://pastebin.com/");
        PasteBinHomePage objPasteBin = new PasteBinHomePage(driver);
        objPasteBin.createNewPaste();
    }
    @After
    public void tearDown(){
        driver.quit();
    }

}