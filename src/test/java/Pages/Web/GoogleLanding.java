package Pages.Web;

import Pages.Basepage;
import org.openqa.selenium.By;

public class GoogleLanding extends Basepage {


    By searchInput = By.xpath("//input[@aria-label='Search']");
    By googleSearchButton = By.xpath("(//input[@value='Google Search'])[2]");



    public void enterSearchText(String text) {
        text = text + "\n";
        type(searchInput, text);
    }

    public void clickGoogleSearch() {
        clickThis(googleSearchButton);
    }

    public void searchOnGoogle(String text) {
        enterSearchText(text);
    }

}
