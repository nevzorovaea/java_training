package appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import model.ContactData;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver wd) {

    super(wd);
  }

  public void returnToHomePageContact() {
    click(By.linkText("home"));
  }

  public void submitNewContact(String s) {
    click(By.xpath(s));
  }

  public void fillContactForm(ContactData contactData) {
    type(By.name("firstname"), contactData.getFirstname());
    //type(By.name("middlename"), contactData.getMiddlename());
    type(By.name("lastname"), contactData.getLastname());
    //type(By.name("nickname"), contactData.getNickname());
    //type(By.name("company"), contactData.getCompany());
   // type(By.name("address"), contactData.getAddress());
   // type(By.name("home"), contactData.getHomephone());
   // type(By.name("mobile"), contactData.getMobile());
   // type(By.name("work"), contactData.getWorkphone());
   // type(By.name("email"), contactData.getEmail());
   // click(By.name("bday"));
    //new Select(wd.findElement(By.name("bday"))).selectByVisibleText(contactData.getBday());
   //click(By.name("bday"));
    //lick(By.name("bmonth"));
    //new Select(wd.findElement(By.name("bmonth"))).selectByVisibleText(contactData.getBmonth());
   //click(By.name("bmonth"));
    //type(By.name("byear"), contactData.getByear());

    //if (creation) {
    //new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
    //} else {
    //  Assert.assertFalse(isElementPresent(By.name("new_group")));
    // }
  }

  public void initNewContact() {
    addNewContact();
  }

  public void addNewContact() {
    click(By.linkText("add new"));
  }

  public void deleteSelectedContacts() {
    click(By.xpath("//input[@value='Delete']"));
    wd.switchTo().alert().accept();

  }

  public void selectContact(int i) {
    click(By.name("selected[]"));
  }

  public void initContactModification() {
    click(By.xpath("//img[@alt='Edit']"));
  }

  public void submitContactModification() {
    click(By.xpath("//div[@id='content']/form/input[22]"));
  }

  public void createContact(ContactData contact) {
    initNewContact();
    fillContactForm(contact);
    submitNewContact("(//input[@name='submit'])[2]");
    returnToHomePageContact();
  }

  public boolean isThereAContact() {
    return isElementPresent(By.name("selected[]"));
  }

  public int getContactCount() {
    return wd.findElements(By.name("selected[]")).size();
  }

  public List<ContactData> getContactList() {
    List<ContactData> contacts = new ArrayList<>();
    WebElement table  = wd.findElement(By.className("sortcompletecallback-applyZebra"));
    WebElement tbody = table.findElement(By.tagName("tbody"));
    List<WebElement> elements = tbody.findElements(By.name("entry"));

    //System.out.print("rows: " + elements.size());       // проверка количества найденных строк

    for (WebElement element : elements) {
      List<WebElement> cells = element.findElements(By.tagName("td"));
      String name = element.getText();
      String id = element.findElement(By.tagName("input")).getAttribute("value");
      ContactData contact = new ContactData("Vladimir", null, "Pirogov", null, null, null, null, null, null, null, null, null, null, null);
      contacts.add(contact);
    }
    //System.out.print("    contacts: " + contacts.size());    // проверка количества найденных контактов

    return contacts;
  }
}
