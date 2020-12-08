package tests;

import model.ContactData;
import model.Contacts;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().gotohomePage();
    if (app.db().contacts().size() == 0){
      app.contact().create(new ContactData().withFirstname("Vladimir").withLastname("Pirogov"));
    }
  }


  @Test
  public void testContactModification() {
    Contacts before = app.db().contacts();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData().withId(modifiedContact.getId()).withFirstname("TestContact").withMiddlename(null).withLastname("Testov")
            .withNickname(null).withCompany(null).withAddress(null).withHomephone(null).withMobile(null)
            .withWorkphone(null).withEmail(null).withBday(null).withByear(null).withBmonth(null).withGroup(null);
    app.contact().modify(contact);
    assertEquals(app.contact().count(), before.size());
    Contacts after = app.db().contacts();
    assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
  }
}
