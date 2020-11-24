package tests;

import model.ContactData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTests extends TestBase {

  @BeforeMethod
public void ensurePreconditions() {
    app.goTo().homePage();
    if (app.contact().list().size() == 0) {
      app.contact().create(new ContactData().withFirstname("Vladimir").withLastname("Pirogov"));
    }
  }


  @Test
  public void testContactModification() {
    List<ContactData> before = app.contact().list();
    int index = before.size()-1;
    ContactData contact = new ContactData().withId(before.get(index).getId()).withFirstname("TestContact").withMiddlename(null).withLastname("Testov")
            .withNickname(null).withCompany(null).withAddress(null).withHomephone(null).withMobile(null)
            .withWorkphone(null).withEmail(null).withBday(null).withByear(null).withBmonth(null).withGroup(null);
    app.contact().modify(index, contact);
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size());

    before.remove(index);
    before.add(contact);
    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }


}
