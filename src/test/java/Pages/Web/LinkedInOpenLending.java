package Pages.Web;

import Pages.Basepage;
import org.openqa.selenium.By;

public class LinkedInOpenLending extends Basepage {


    By linkedInLogo = By.xpath("//h1[@class='global-nav__branding']");
    By tagLine = By.xpath("//*[contains(text(),'Say YES to more automotive loans.') and contains(@class,'top-card-layout')]");

    public boolean isTaglineDisplayed() {
        return isElementDisplayed(tagLine);
    }

}
