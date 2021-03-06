package page_objects;

import helpers.DriverHelper;
import helpers.ElementHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class MyTicketPage extends BasePage {

    private final String dynamicManageTicketsRow = "//table[@class='MyTable']/tbody//td[text()='%s']/following-sibling::td[text()='%s']/following-sibling::td[text()='%s']/following-sibling::td[text()='%s']/following-sibling::td[text()='%s']/following-sibling::td/input[@value='Cancel']";
    private final String dynamicNoteWith0Or1Ticket = "//div[@class='message']/li[text()='You currently book %s ticket, you can book %s more.']";
    private final String dynamicNoteWithMoreThan1Ticket = "//div[@class='message']/li[text()='You currently book %s tickets, you can book %s more.']";

    // Element
    private WebElement getCancelButton(String departStation, String arriveStation, String departDate, String bookDate, String ticketAmount) {
        String dynamicCancelButton = String.format(dynamicManageTicketsRow, departStation, arriveStation, departDate, bookDate, ticketAmount);
        By cancelButton = By.xpath(dynamicCancelButton);
        return DriverHelper.getDriver().findElement(cancelButton);
    }

    // Methods
    public void cancelTicket(String departStation, String arriveStation, String departDate, String bookDate, String ticketAmount) {
        ElementHelper.scrollTo(this.getCancelButton(departStation, arriveStation, departDate, bookDate, ticketAmount));
        this.getCancelButton(departStation, arriveStation, departDate, bookDate, ticketAmount).click();
    }

    public String getCancelTicketNoteWith0Or1Ticket(String ticketAmount, String maximumTicketAmount) {
        Integer formattedTicketAmount = Integer.valueOf(ticketAmount);
        Integer formattedMaximumTicketAmount = Integer.valueOf(maximumTicketAmount);
        Integer remainingTicketAmount = formattedMaximumTicketAmount - formattedTicketAmount;
        String formattedRemainingTicketAmount = String.valueOf(remainingTicketAmount);
        String dynamicCancelTicketNote = String.format(dynamicNoteWith0Or1Ticket, ticketAmount, formattedRemainingTicketAmount);
        By note = By.xpath(dynamicCancelTicketNote);
        return DriverHelper.getDriver().findElement(note).getText();
    }

    public String getCancelTicketNoteWithMoreThan1Ticket(String ticketAmount, String maximumTicketAmount) {
        Integer formattedTicketAmount = Integer.valueOf(ticketAmount);
        Integer formattedMaximumTicketAmount = Integer.valueOf(maximumTicketAmount);
        Integer remainingTicketAmount = formattedMaximumTicketAmount - formattedTicketAmount;
        String formattedRemainingTicketAmount = String.valueOf(remainingTicketAmount);
        String dynamicCancelTicketNote = String.format(dynamicNoteWithMoreThan1Ticket, ticketAmount, formattedRemainingTicketAmount);
        By note = By.xpath(dynamicCancelTicketNote);
        return DriverHelper.getDriver().findElement(note).getText();
    }

}
