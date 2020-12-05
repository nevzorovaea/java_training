package tests;

import model.GroupData;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.Test;
import org.testng.annotations.BeforeClass;

import java.util.List;

public class HbConnectionTest {

  private SessionFactory sessionFactory;

  @BeforeClass

  protected void setUp() throws Exception {
    // A SessionFactory is set up once for an application!
    final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure() // configures settings from hibernate.cfg.xml
            .build();
    try {
      sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
    } catch (Exception e) {
      e.printStackTrace();
      // The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
      // so destroy it manually.
      System.out.println("!!!!!");
      e.printStackTrace();
      StandardServiceRegistryBuilder.destroy(registry);
    }
  }


  @Test
  public void testHbConnection() {
    Session openSession = sessionFactory.openSession();
    openSession.beginTransaction();
    List result = openSession.createQuery("from GroupData").list();
    for (GroupData group : (List<GroupData>) result) {
      System.out.println(group);
    }
    openSession.getTransaction().commit();
    openSession.close();

  }
}
