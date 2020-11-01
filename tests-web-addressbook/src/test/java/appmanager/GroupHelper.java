package appmanager;

import model.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GroupHelper {
  private FirefoxDriver wd;

  public GroupHelper(FirefoxDriver wd) {
    this.wd = wd;
  }

  public void returntoGroupPage(String s) {
    wd.findElement(By.linkText(s)).click();
  }

  public void submitGroupCreation(String submit) {
    wd.findElement(By.name(submit)).click();
  }

  public void fillGroupForm(GroupData groupData) {
    wd.findElement(By.name("group_name")).click();
    wd.findElement(By.name("group_name")).clear();
    wd.findElement(By.name("group_name")).sendKeys(groupData.getName());
    wd.findElement(By.name("group_header")).clear();
    wd.findElement(By.name("group_header")).sendKeys(groupData.getHeader());
    wd.findElement(By.name("group_footer")).clear();
    wd.findElement(By.name("group_footer")).sendKeys(groupData.getFooter());
  }

  public void initGroupCreation(String s) {
    wd.findElement(By.name(s)).click();
  }

  public void deleteSelectedGroups(String delete) {
    wd.findElement(By.name(delete)).click();
  }

  public void selectGroup(String s) {
    wd.findElement(By.name(s)).click();
  }
}
