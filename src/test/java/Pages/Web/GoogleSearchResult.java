package Pages.Web;

import Pages.Basepage;
import org.openqa.selenium.By;

public class GoogleSearchResult extends Basepage {


    By linkedInLink = By.xpath("//h2[text()='Web results']//following::h3[text()='Open Lending | LinkedIn']");

    public void clickLinkedInOpenLendingLink() {
        scrollAndClickToWebElement(linkedInLink);
    }


}
