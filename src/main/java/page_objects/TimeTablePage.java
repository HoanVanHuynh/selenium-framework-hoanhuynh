package page_objects;

import helpers.DriverHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;


public class TimeTablePage extends BasePage {

    private String dynamicTimeTableCheckPriceRow = "//table[@class='MyTable WideTable']/tbody//td[text()='%s']/following-sibling::td[text()='%s']/following-sibling::td/a[text()='check price']";
    private String dynamicTimeTableBookTicketRow = "//table[@class='MyTable WideTable']/tbody//td[text()='%s']/following-sibling::td[text()='%s']/following-sibling::td/a[text()='book ticket']";

    // Elements
    public WebElement getCheckPriceButton(String departStation, String arriveStation) {
        String dynamicCheckPriceButton = String.format(dynamicTimeTableCheckPriceRow, departStation, arriveStation);
        By checkPriceButton = By.xpath(dynamicCheckPriceButton);
        return DriverHelper.getDriver().findElement(checkPriceButton);
    }


    public WebElement getBookTicketButton(String departStation, String arriveStation) {
        String dynamicBookTicketButton = String.format(dynamicTimeTableBookTicketRow, departStation, arriveStation);
        By bookTicketButton = By.xpath(dynamicBookTicketButton);
        return DriverHelper.getDriver().findElement(bookTicketButton);
    }


    // Methods
    public void clickCheckPriceButton(String departStation, String arriveStation) {
        this.getCheckPriceButton(departStation, arriveStation).click();
    }

    public void clickBookTicketButton(String departStation, String arriveStation) {
        this.getBookTicketButton(departStation, arriveStation).click();
    }

}
