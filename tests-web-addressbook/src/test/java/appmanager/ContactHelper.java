package appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import tests.NewContact;

public class ContactHelper extends HelperBase {

  public ContactHelper(FirefoxDriver wd) {

    super(wd);
  }

  public void returnToHomePageContact() {
    click(By.linkText("home"));
  }

  public void submitNewContact(String s) {
    click(By.xpath(s));
  }

  public void fillContactForm() {
    creationNewContact(new NewContact("Vladimir", "Ivanovich", "Pirogov", "Vova", "Coca Cola", "Moscow, Oblakova,15", "456-654", "89235623265", "456-852", "VladimirP@mail.ru", "15", "1990", "August"));
  }

  public void initNewContact() {
    addNewContact();
  }

  public void creationNewContact(NewContact newContact) {
    type(By.name("firstname"), newContact.getFirstname());
    type(By.name("middlename"), newContact.getMiddlename());
    type(By.name("lastname"), newContact.getLastname());
    type(By.name("nickname"), newContact.getNickname());
    type(By.name("company"), newContact.getCompany());
    type(By.name("address"), newContact.getAddress());
    click(By.name("theform"));
    type(By.name("home"), newContact.getHomephone());
    click(By.name("theform"));
    type(By.name("mobile"), newContact.getMobile());
    type(By.name("work"), newContact.getWorkphone());
    type(By.name("email"), newContact.getEmail());
    click(By.name("bday"));
    new Select(wd.findElement(By.name("bday"))).selectByVisibleText(newContact.getBday());
    click(By.name("bday"));
    click(By.name("bmonth"));
    new Select(wd.findElement(By.name("bmonth"))).selectByVisibleText(newContact.getBmonth());
    click(By.name("bmonth"));
    type(By.name("byear"), newContact.getByear());
    click(By.name("theform"));
  }

  public void addNewContact() {
    click(By.linkText("add new"));
  }

  public void deleteSelectedContacts() {
    click(By.xpath("//input[@value='Delete']"));
    wd.switchTo().alert().accept();

  }

  public void selectContact() {
    click(By.name("selected[]"));
  }

}
