package page_objects;

import helpers.DriverHelper;
import helpers.ElementHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TicketPricePage extends BasePage {

    private String dynamicCheckPriceRow = "//table[@class='NoBorder']/tbody//li[text()='%s']/following::td/a[text()='Check Price']";
    private String dynamicTicketPriceTitle = "//table[@class='MyTable MedTable']/tbody/tr/th[contains(text(),'Ticket price from %s')]";

    // Element
    private WebElement getBtnCheckPrice(String departStationToArriveStation) {
        String dynamicCheckPriceButton = String.format(dynamicCheckPriceRow, departStationToArriveStation);
        By checkPriceButton = By.xpath(dynamicCheckPriceButton);
        return DriverHelper.getDriver().findElement(checkPriceButton);
    }

    private WebElement getLblTicketPriceTableTitle(String departStationToArriveStation) {
        String ticketPriceTitle = String.format(dynamicTicketPriceTitle, departStationToArriveStation);
        By title = By.xpath(ticketPriceTitle);
        return DriverHelper.getDriver().findElement(title);
    }

    // Method
    public void clickCheckPriceButton(String departStationToArriveStation) {
        ElementHelper.scrollTo(this.getBtnCheckPrice(departStationToArriveStation));
        this.getBtnCheckPrice(departStationToArriveStation).click();
    }

    public String getTicketPriceTableTitle(String departStationToArriveStation) {
        return this.getLblTicketPriceTableTitle(departStationToArriveStation).getText();
    }

}

