package org.example;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.example.values.CannedWalrusFood;
import org.example.values.Walrus;
import org.example.values.WalrusFood;

public class WalrusTest {

    private Walrus bigFluffy;
    private FeedsWalrus walrusFeeder;

    @Before
    public void prepareWalrus() {
        bigFluffy = new Walrus();
        walrusFeeder = new FeedsWalrus();
    }

    @Test
    public void shouldConsumeHundredsOfMeals() {
        int foodCount = 327;
        for (int item = 0; item < foodCount; item++) {
            WalrusFood meal = new WalrusFood();
            bigFluffy.addToStomach(meal);
            assertTrue("Item number " + (item + 1) + " wasn't accepted by the walrus!", bigFluffy.hasEaten(meal));
        }
        System.out.println("Success! Walrus enjoyed " + foodCount + " meals in total.");
    }

    @Test
    public void walrusConsumesExpectedCannedFood() {
        WalrusFood deliciousTreat = new WalrusFood();
        CannedWalrusFood sealedMeal = new CannedWalrusFood(deliciousTreat);
        walrusFeeder.feed(bigFluffy, sealedMeal);
        assertTrue("Expected the walrus to digest the contents of the can.", bigFluffy.hasEaten(deliciousTreat));
    }

    @Test
    public void openingCannedMealRevealsProperFood() {
        WalrusFood hiddenMeal = new WalrusFood();
        CannedWalrusFood tin = new CannedWalrusFood(hiddenMeal);
        OpensCan tinOpener = new OpensCan();
        WalrusFood openedMeal = tinOpener.open(tin);
        assertEquals("Food obtained by opening the can wasn't as expected!", hiddenMeal, openedMeal);
    }

    @Test
    public void walrusFeedsCorrectlyFromTin() {
        WalrusFood herring = new WalrusFood();
        CannedWalrusFood fishCan = new CannedWalrusFood(herring);
        walrusFeeder.feed(bigFluffy, fishCan);
        assertTrue("The walrus didn't consume the item from the tin as expected.", bigFluffy.hasEaten(herring));
    }

    @Test
    public void walrusSupportsCustomFoodTypes() {
        class FancyFood extends WalrusFood {}
        FancyFood chefSpecial = new FancyFood();
        bigFluffy.addToStomach(chefSpecial);
        assertTrue("Custom food derived from WalrusFood was not accepted!", bigFluffy.hasEaten(chefSpecial));
    }
}
