package ru.training.java_training.addressbook;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class GroupDeletionTests extends TestBase {

  @Test
  public void testGroupDeletion() throws Exception {

      gotoGroupPage();
      selectGroup("selected[]");
      deleteSelectedGroups("delete");
      returnToGroupPage(By.linkText("group page"));

      }

}