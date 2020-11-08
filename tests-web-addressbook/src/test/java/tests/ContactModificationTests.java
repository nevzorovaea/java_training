package tests;

import model.ContactData;
import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification() {
    app.getNavigationHelper().gotoHomePage();
    app.getContactHelper().selectContact();
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactForm(new ContactData("Vladimir", "Ivanovich", "Pirogov", "Vova", "Coca Cola", "Moscow, Oblakova,15", "456-654", "89235623265", "456-852", "VladimirP@mail.ru", "15", "1990", "August",null), false);
    app.getContactHelper().submitContactModification();
    app.getContactHelper().returnToHomePageContact();
  }
}
