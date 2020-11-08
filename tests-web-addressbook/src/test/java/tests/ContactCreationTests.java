package tests;

import model.ContactData;
import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {

  @Test
  public void testCreationNewContact() {
    app.getNavigationHelper().gotoHomePage();
    app.getContactHelper().initNewContact();
    app.getContactHelper().fillContactForm(new ContactData("Vladimir", "Ivanovich", "Pirogov", "Vova", "Coca Cola", "Moscow, Oblakova,15", "456-654", "89235623265", "456-852", "VladimirP@mail.ru", "15", "1990", "August","test1") , true);
    app.getContactHelper().submitNewContact("(//input[@name='submit'])[2]");
    app.getContactHelper().returnToHomePageContact();
  }

}
