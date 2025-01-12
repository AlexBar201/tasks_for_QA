package page.pageObjectPasteBin;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PasteBinHomePage {

    private WebDriver driver;

//Локаторы нужные для создания New Paste
    private static final By TEXT_AREA = By.id("postform-text");
    private static final By SELECT_EXPIRATION = By.id("select2-postform-expiration-container");
    private static final By POST_FORM_NAME_INPUT = By.id("postform-name");
    private static final By TEN_MINUTES = By.xpath("//ul[@id='select2-postform-expiration-results' and @aria-hidden='false']//li[contains(@id, 'select2-postform-expiration-result') and contains(text(), '10M')]");
    private static final By CREATE_NEW_PASTE_BUTTON = By.xpath(".//div[@class='form-group form-btn-container']/button[@class='btn -big']");

//Переменные нужные для выполнения задания
    private static final String CODE = "Hello from WebDriver";
    private static final String PASTE_NAME_TITLE = "helloweb";

//Конструктор класса
    public PasteBinHomePage(WebDriver driver){
        this.driver = driver;
    }

//Метод заполнения поля New Paste
    public void inputNewPaste(String code){

//////Ожидаем поле New Paste
        new WebDriverWait(driver, 2)
                .until(ExpectedConditions.visibilityOfElementLocated(TEXT_AREA));

//////Очищаем поле на всякий случай
        driver.findElement(TEXT_AREA).clear();

//////Заполняем поле
        driver.findElement(TEXT_AREA).sendKeys(code);

    }

//Метод для выбора Paste Expiration равного десяти минутам
    public void setPasteExpirationTenMinutes(){

//////Клик по полю PasteExpiration
        driver.findElement(SELECT_EXPIRATION).click();

//////Ожидаем появления
        new WebDriverWait(driver, 2)
                .until(ExpectedConditions.visibilityOfElementLocated(TEN_MINUTES));

//////Выбираем десять минут
        driver.findElement(TEN_MINUTES).click();

    }

//Метод для скролла
    public void scrollToWebElement(By element){

//////Листаем страницу до нужного элемента
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);

    }

//Метод для ввода Paste Name/Title
    public void setPasteNameTitle(String title){

//////Листаем до поля Paste Name/Title
        scrollToWebElement(POST_FORM_NAME_INPUT);

//////На всякий случай очищаем поле Paste Name/Title
        driver.findElement(POST_FORM_NAME_INPUT).clear();

//////Заполняем поле
        driver.findElement(POST_FORM_NAME_INPUT).sendKeys(title);

    }

//Метод клика по кнопке Create New Paste
    public void clickCreateNewPasteButton(){

//////Листаем страницу до кнопки
        scrollToWebElement(CREATE_NEW_PASTE_BUTTON);

//////Кликаем по кнопке
        driver.findElement(CREATE_NEW_PASTE_BUTTON).click();

    }

//Шаг для создания New Paste
    public void createNewPaste(){

        inputNewPaste(CODE);
        setPasteExpirationTenMinutes();
        setPasteNameTitle(PASTE_NAME_TITLE);
        clickCreateNewPasteButton();

    }

}