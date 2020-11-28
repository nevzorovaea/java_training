package tests;

import model.ContactData;
import model.Contacts;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactDeletionTests extends TestBase {
  protected FirefoxDriver wd;

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().gotohomePage();
    if (app.contact().all().size() == 0) {
      app.contact().create(new ContactData().withFirstname("Anton").withLastname("Ivanov"));
    }
  }

  @Test
  public void testContactDeletion() {
    Contacts before = app.contact().all();
    ContactData deletedContact = before.iterator().next();
    app.contact().delete(deletedContact);
    Contacts after = app.contact().all();
    assertEquals(app.contact().count(), before.size()-1);
    assertThat(after, equalTo(before.without(deletedContact)));
  }


}
