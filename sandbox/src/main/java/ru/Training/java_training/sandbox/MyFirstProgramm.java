package ru.Training.java_training.sandbox;

public class MyFirstProgramm {
public static void main(String[] args) {
 hello("world");
 hello ("user");
 hello ("Alexei");
 hello("Vladimir");

 double l = 5;
 System.out.println("Площадь квадрата со стороной " + l + " = " + area (l));

 double a = 4;
 double b = 6;
 System.out.println("Площадь прямоугольника со сторонами " + a + " и " + b + " = " + area(a,b));

 }

 public static void hello (String somebody) {

   System.out.println("Hello," + somebody + "!");
 }

 public static double area (double Len) {
 return Len * Len;
 }
public static double area (double a, double b) {
 return a * b;
}
}