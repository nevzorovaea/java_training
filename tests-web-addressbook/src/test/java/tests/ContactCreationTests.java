package tests;

import model.ContactData;
import model.Contacts;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactCreationTests extends TestBase {

  @DataProvider
  public Iterator<Object[]> validContacts() {
    List<Object[]> list = new ArrayList<Object[]>();
    list.add(new Object[] {new ContactData().withFirstname("Anton1").withLastname("ivanov1").withAddress("Sovetskaya, dom 5").withEmail("test@mail").withMobile("556665")});
    list.add(new Object[] {new ContactData().withFirstname("pavel2").withLastname("testov2").withAddress("teatralnaya, dom 21").withEmail("test2@mail").withMobile("9896512")});
    list.add(new Object[] {new ContactData().withFirstname("lena3").withLastname("lenova3").withAddress("pervaya, dom 7").withEmail("tes3t@mail").withMobile("651623")});
    return list.iterator();
  }

  @Test(dataProvider = "validContacts")
  public void testCreationNewContact(ContactData contact) {
    app.goTo().gotohomePage();
    Contacts before = app.contact().all();
    //File photo = new File("src/test/resources/zefir.png");     // фото
    app.contact().create(contact);
    Contacts after = app.contact().all();
    assertEquals(app.contact().count(), before.size() + 1);
    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
  }

}

