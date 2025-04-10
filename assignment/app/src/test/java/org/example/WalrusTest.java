package org.example;

import org.junit.Test;

import static org.junit.Assert.*;

import java.util.stream.Stream;

import org.example.values.CannedWalrusFood;
import org.example.values.Walrus;
import org.example.values.WalrusFood;

public class WalrusTest {
  // Write a test to see how much a Walrus can eat
  @Test
  public void testHowMuchAWalrusCanEat() {
    final var walrus = new Walrus();
    final var feeder = new FeedsWalrus();

    final var foodSupply = Stream.generate(() -> new WalrusFood()).limit(999);

    foodSupply.forEach(food -> {
      feeder.feed(walrus, new CannedWalrusFood(food));

      assertTrue(walrus.hasEaten(food));
    });

  }

  // Write a test to check if a Walrus gets the right food
  @Test
  public void testWalrusGetsRightFood() {
    final var walrus = new Walrus();
    final var feeder = new FeedsWalrus();

    final var food1 = new WalrusFood();
    final var food2 = new WalrusFood();

    feeder.feed(walrus, new CannedWalrusFood(food1));

    assertTrue(walrus.hasEaten(food1) && !walrus.hasEaten(food2));
  }

  // Write a test to check opening a can will return food
  @Test
  public void testOpeningCanReturnsFood() {
    final var can = new CannedWalrusFood(new WalrusFood());
    final var food = can.extractContents();

    assertTrue(food instanceof WalrusFood);
  }

  // Write a test to check on how a Walrus can eat
  @Test
  public void testHowAWalrusCanEat() {
    final var walrus = new Walrus();
    final var feeder = new FeedsWalrus();

    final var food1 = new WalrusFood();
    final var food2 = new WalrusFood();

    feeder.feed(walrus, new CannedWalrusFood(food1));
    walrus.addToStomach(food2);

    assertTrue(walrus.hasEaten(food1) && walrus.hasEaten(food2));
  }

  // Write a test making a Walrus accept non-Walrus food
  @Test
  public void testWalrusWrongFood() {
    final var walrus = new Walrus();
    walrus.addToStomach(null);

    assertTrue(walrus.hasEaten(null));
  }

  // Write a test making a Walrus accept non-Walrus food
  @Test
  public void testWalrusWrongFood2() {
    class MonkeyFood extends WalrusFood {
    }

    final var walrus = new Walrus();
    final var food = new MonkeyFood();

    walrus.addToStomach(food);

    assertTrue(walrus.hasEaten(food));
  }
}
