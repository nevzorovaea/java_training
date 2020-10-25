package ru.Training.java_training.sandbox;

public class Distance {

  public static void main(String[] args) {

    Point P1 = new Point(3, 4);
    Point P2 = new Point(5, 6);

    System.out.println("Расстояние между точками = " + distance(P1, P2));
    System.out.println("Расстояние между точками = "+ P1.distance(P2));
  }

  public static double distance(Point p1, Point p2) {

    return Math.sqrt((p2.x - p1.x) * (p2.x - p1.x) + (p2.y - p1.y) * (p2.y - p1.y));

  }
}