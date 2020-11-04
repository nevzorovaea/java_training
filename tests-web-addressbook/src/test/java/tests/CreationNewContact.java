package tests;

import org.testng.annotations.Test;

public class CreationNewContact extends TestBase {

  @Test
  public void testCreationNewContact() {
    app.getNavigationHelper().gotoHomePage();
    app.getContactHelper().initNewContact();
    app.getContactHelper().fillContactForm();
    app.getContactHelper().submitNewContact("(//input[@name='submit'])[2]");
    app.getContactHelper().returnToHomePageContact();
  }

}
