package ru.Training.java_training.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

import static ru.Training.java_training.sandbox.Distance.distance;

public class PointTests {
  public double distance;

  @Test
  public void testPoint() {

    Point P1 = new Point(3, 4);
    Point P2 = new Point(5, 6);

    Assert.assertEquals(distance(P1, P2), 2.8284271247461903);

  }

  @Test
  public void testPointNegative() {

    Point P1 = new Point(3, 4);
    Point P2 = new Point(5, 6);

    Assert.assertNotEquals(distance(P1, P2), 10);

  }

  @Test
  public void testPointNegative2() {

    Point P1 = new Point(3, 4);
    Point P2 = new Point(5, 6);

    Assert.assertNotEquals(P1.distance(P2), 10);

  }

  @Test
  public void testPoint2() {

    Point P1 = new Point(3, 4);
    Point P2 = new Point(5, 6);

    Assert.assertEquals(P1.distance(P2), 2.8284271247461903);
  }
}


