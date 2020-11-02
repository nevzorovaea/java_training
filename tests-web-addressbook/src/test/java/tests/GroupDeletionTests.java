package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class GroupDeletionTests extends TestBase {

  @Test
  public void testGroupDeletion() throws Exception {

      app.getNavigationHelper().gotoGroupPage();
      app.getGroupHelper().selectGroup();
      app.getGroupHelper().deleteSelectedGroups();
      app.returnToGroupPage(By.linkText("group page"));

      }

}