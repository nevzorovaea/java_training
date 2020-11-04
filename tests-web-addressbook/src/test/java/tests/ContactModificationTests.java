package tests;

import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification() {
    app.getNavigationHelper().gotoHomePage();
    app.getContactHelper().selectContact();
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactForm();
    app.getContactHelper().submitContactModification();
    app.getContactHelper().returnToHomePageContact();
  }
}
