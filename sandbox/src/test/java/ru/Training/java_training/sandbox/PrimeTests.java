package ru.Training.java_training.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PrimeTests {

  @Test
  public void TestPrimes() {
    Assert.assertTrue(Primes.isPrimeFast(Integer.MAX_VALUE));

  }

  @Test
  public void TestNonPrimes() {
    Assert.assertFalse(Primes.isPrime(Integer.MAX_VALUE - 2));

  }

  @Test (enabled = false)
  public void TestPrimeLong() {
    long n = Integer.MAX_VALUE;
    Assert.assertTrue(Primes.isPrime(n));
  }
}