package ru.Training.java_training.sandbox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Collections {
  public static void main(String[] args) {
    String[] langs = {"Java", "C#", "Python", "PHP"};

    List<String> lahguages = Arrays.asList("Java", "C#", "Python", "PHP");

    for (String l : lahguages){
      System.out.println("Я хочу выучить " + l);
    }
  }
}
