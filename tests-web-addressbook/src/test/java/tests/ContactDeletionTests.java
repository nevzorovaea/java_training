package tests;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase {
  protected FirefoxDriver wd;

  @Test
  public void testContactDeletion()  {
    app.getNavigationHelper().gotoHomePage();
    app.getContactHelper().selectContact();
    app.getContactHelper().deleteSelectedContacts();
    app.getContactHelper().returnToHomePageContact();

  }

}
