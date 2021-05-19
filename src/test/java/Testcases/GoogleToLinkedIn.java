package Testcases;

import DriverPkg.DriverWrapper;
import Pages.Web.GoogleLanding;
import Pages.Web.GoogleSearchResult;
import Pages.Web.LinkedInOpenLending;

import org.testng.annotations.Test;

public class GoogleToLinkedIn extends DriverWrapper {

	@Test
	public void verifyOpenLendingTagLine() {
		GoogleLanding googleLanding = new GoogleLanding();
		GoogleSearchResult googleSearchResult = new GoogleSearchResult();
		LinkedInOpenLending linkedInOpenLending = new LinkedInOpenLending();

		googleLanding.enterSearchText("Open Lending");
		googleSearchResult.clickLinkedInOpenLendingLink();
		System.out.println("The slogan under Logo is \"Say YES to more automotive loans.\"  "+ linkedInOpenLending.isTaglineDisplayed());

	}


}
