package tests;

import model.ContactData;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ContactDeletionTests extends TestBase {
  protected FirefoxDriver wd;

  @Test
  public void testContactDeletion()  {
    app.getNavigationHelper().gotoHomePage();
    if (! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("Vladimir", "Ivanovich", "Pirogov", "Vova", "Coca Cola", "Moscow, Oblakova,15", "456-654", "89235623265", "456-852", "VladimirP@mail.ru", "15", "1990", "August","test1"));
    }
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().selectContact(before.size() - 1);
    app.getContactHelper().deleteSelectedContacts();
    app.getContactHelper().returnToHomePageContact();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() - 1);
  }

}
