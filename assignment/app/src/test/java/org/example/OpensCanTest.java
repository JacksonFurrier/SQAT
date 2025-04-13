package org.example;

import org.example.OpensCan; //  修正后
import org.example.values.CannedWalrusFood;
import org.example.values.WalrusFood;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OpensCanTest {

    @Test
    void testOpenReturnsFood() {
        WalrusFood food = new WalrusFood();
        CannedWalrusFood can = new CannedWalrusFood(food);
        OpensCan opener = new OpensCan();
        WalrusFood result = opener.open(can);
        assertNotNull(result);
        assertSame(food, result);
    }

    @Test
    void testOpenReturnsNullIfAlreadyOpened() {
        CannedWalrusFood can = new CannedWalrusFood(new WalrusFood());
        OpensCan opener = new OpensCan();
        opener.open(can); // 第一次开
        assertNull(opener.open(can)); // 第二次开返回 null
    }
}

