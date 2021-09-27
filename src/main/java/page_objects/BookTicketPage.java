package page_objects;

import common.Ticket;
import helpers.DriverHelper;
import helpers.ElementHelper;
import helpers.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BookTicketPage extends BasePage {

    //Locators of combo box
    private final By cboDate = By.cssSelector("select[name='Date']");
    private final By cboDepartFrom = By.cssSelector("select[name='DepartStation']");
    private final By cboArriveAt = By.cssSelector("select[name='ArriveStation']");
    private final By cboSeatType = By.cssSelector("select[name='SeatType']");
    private final By cboTicketAmount = By.cssSelector("select[name='TicketAmount']");
    private final By btnBookTicket = By.cssSelector("input[type='submit']");
    private final By lblBookTicketMessage = By.cssSelector("div[id='content'] > h1");

    private final By ticketResult = By.xpath("//table[@class = 'MyTable WideTable']//tr[@class='OddRow']");
    //
    private final By lblBookTicketFormTitle = By.cssSelector("form[method='post'] fieldset legend");

    private WebElement getLblBookTicketFormTitle() {
        Wait.untilElementIsVisible(lblBookTicketFormTitle, 10);
        return DriverHelper.getDriver().findElement(lblBookTicketFormTitle);
    }

    public String getBookTicketFormTitle() {
        return this.getLblBookTicketFormTitle().getText();
    }

    // Book ticket form
    //
    // Elements of drop down
    private Select getDropDownDepartDate() {
        Select select = new Select(DriverHelper.getDriver().findElement(cboDate));
        return select;
    }

    private Select getDropDownDepartFrom() {
        Select select = new Select(DriverHelper.getDriver().findElement(cboDepartFrom));
        return select;
    }

    private Select getDropDownArriveAt() {
        Select select = new Select(DriverHelper.getDriver().findElement(cboArriveAt));
        return select;
    }

    private Select getDropDownSeatType() {
        Select select = new Select(DriverHelper.getDriver().findElement(cboSeatType));
        return select;
    }

    private Select getDropDownTicketAmount() {
        Select select = new Select(DriverHelper.getDriver().findElement(cboTicketAmount));
        return select;
    }

    private WebElement getBtnBookTicket() {
        return DriverHelper.getDriver().findElement(btnBookTicket);
    }

    private WebElement getLblBookTicketMessage() {
        return DriverHelper.getDriver().findElement(lblBookTicketMessage);
    }

    private WebElement getFirstSelectedOptionOfDepartDate() {
        return this.getDropDownDepartDate().getFirstSelectedOption();
    }

    // Methods
    public String getFirstDepartDate() {
        return this.getFirstSelectedOptionOfDepartDate().getText();
    }

    public int getTotalDepartDate() {
        List<WebElement> listOptions = this.getDropDownDepartDate().getOptions();
        return listOptions.size();
    }

    public int getTotalDepartFrom() {
        List<WebElement> listOptions = this.getDropDownDepartFrom().getOptions();
        return listOptions.size();
    }

    public int getTotalArriveAt() {
        List<WebElement> listOptions = this.getDropDownArriveAt().getOptions();
        return listOptions.size();
    }

    public int getTotalSeatType() {
        List<WebElement> listOptions = this.getDropDownSeatType().getOptions();
        return listOptions.size();
    }

    // Make sure all options of ticket amount dropdown are distinct in order to return sum of all options
    public int getTotalTicketAmount(int numberOfOptions) {
        List<WebElement> listOptions = this.getDropDownTicketAmount().getOptions();
        Set<Integer> set = new HashSet<Integer>();
        int sum = 0;
        for (int i = 0; i < listOptions.size(); i++) {
            Integer ticketAmountInDropDown = Integer.valueOf(listOptions.get(i).getText());
            set.add(ticketAmountInDropDown);
            sum = sum + ticketAmountInDropDown;
        }
        if ((set.size() == listOptions.size()) && (listOptions.size() == numberOfOptions)) {
            return sum;
        }
        return listOptions.size();
    }

    public Boolean isTicketAmountDisplayed(int ticketAmount) {
        List<WebElement> listOptions = this.getDropDownTicketAmount().getOptions();
        for (int i = 0; i < listOptions.size(); i++) {
            Integer ticketAmountInDropDown = Integer.valueOf(listOptions.get(i).getText());
            if (ticketAmountInDropDown == ticketAmount) {
                return true;
            }
        }
        return false;
    }

    public void getAllTicketResult() {
        List<WebElement> allResult = DriverHelper.getDriver().findElements(ticketResult);
        for (int i = 0; i < allResult.size(); i++) {
            System.out.println(allResult.size());
            System.out.println(i);
            System.out.println(allResult.get(i).getText());
        }
    }

    public String getAllTicketResult2() {
        List<WebElement> allResult = DriverHelper.getDriver().findElements(ticketResult);
        String result = "";
        for (int i = 0; i < allResult.size(); i++) {
            if (i == 4 || i == 5) {
                continue;
            }
            result = result + allResult.get(i).getText();
            System.out.println(allResult.get(i).getText());
        }
        return result;
    }

    public String getAllTicketResult3() {

        StringBuilder stringBuilder = new StringBuilder();
        List<WebElement> allResult = DriverHelper.getDriver().findElements(ticketResult);

        for (int i = 1; i < allResult.size(); i++) {
            stringBuilder.append(allResult.get(i).getText() + " ");
        }
        return stringBuilder.toString();
    }

    public String getAllTicketResult4() {

        StringBuilder stringBuilder = new StringBuilder();
        List<WebElement> allResult = DriverHelper.getDriver().findElements(ticketResult);

        for (int i = 1; i < allResult.size(); i++) {
            stringBuilder.append(allResult.get(i).getText());
        }
        return stringBuilder.toString();
    }

    public void selectDepartDate(String departDate) {
        this.getDropDownDepartDate().selectByVisibleText(departDate);
    }

    public void selectDepartStation(String departFrom) {
        this.getDropDownDepartFrom().selectByVisibleText(departFrom);
    }

    public void selectArriveStation(String arriveAt) {
        this.getDropDownArriveAt().selectByVisibleText(arriveAt);
    }

    public void selectSeatType(String seatType) {
        this.getDropDownSeatType().selectByVisibleText(seatType);
    }

    public void selectTicketAmount(String ticketAmount) {
        this.getDropDownTicketAmount().selectByVisibleText(ticketAmount);
    }

    public void bookTicket(Ticket ticket) {
        ElementHelper.scrollTo(this.getBtnBookTicket());
        this.selectDepartDate(ticket.getDepartDate());
        this.selectDepartStation(ticket.getDepartFrom());
        this.selectArriveStation(ticket.getArriveAt());
        this.selectSeatType(ticket.getSeatType());
        this.selectTicketAmount(ticket.getTicketAmount());
        this.getBtnBookTicket().click();
    }

    public String getBookTicketMessage() {
        return this.getLblBookTicketMessage().getText();
    }

    private String dynamicRow = "//table[@class='MyTable WideTable']/tbody//td[text()='%s']";

    public WebElement getLblDepartStation(String departStation) {
        String dynamicCheckPriceButton = String.format(dynamicRow, departStation);
        By checkPriceButton = By.xpath(dynamicCheckPriceButton);
        return DriverHelper.getDriver().findElement(checkPriceButton);
    }

    public String getDepartStation(String departStation) {
        return this.getLblDepartStation(departStation).getText();
    }

}

