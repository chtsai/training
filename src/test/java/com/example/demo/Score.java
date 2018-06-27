package com.example.demo;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Score {


    private Tennis tennis = new Tennis();

    @Test
    public void testStart() {
        assertEquals(tennis.getScore(), "love all");
    }

    @Test
    public void testFifteenLove() {
        tennis.add1Point(0);
        assertEquals(tennis.getScore(), "fifteen love");
    }

    @Test
    public void testLoveFifteen() {
        tennis.setPoints(0, 1);
        assertEquals(tennis.getScore(), "love fifteen");
    }

    @Test
    public void testFifteenAll() {
        tennis.setPoints(1, 1);
        assertEquals(tennis.getScore(), "fifteen all");
    }

    @Test
    public void testThirtyFifteen() {
        tennis.setPoints(2, 1);
        assertEquals(tennis.getScore(), "thirty fifteen");
    }

    @Test
    public void testThirtyAll() {
        tennis.setPoints(2, 2);
        assertEquals(tennis.getScore(), "thirty all");
    }

    @Test
    public void testThirtyLove() {
        tennis.setPoints(2, 0);
        assertEquals(tennis.getScore(), "thirty love");
    }

    @Test
    public void testFortyThirty() {
        tennis.setPoints(3, 2);
        assertEquals(tennis.getScore(), "forty thirty");
    }

    @Test
    public void test4v2() {
        tennis.setPoints(4, 2);
        assertEquals(tennis.getScore(), "joey win");
    }

    @Test
    public void test3v3() {
        tennis.setPoints(3, 3);
        assertEquals(tennis.getScore(), "deuce");
    }

    public void teest() {
        tennis.setPoints(3, 4);
        assertEquals(tennis.getScore(), "joseph adv");

        tennis.setPoints(4, 4);
        assertEquals(tennis.getScore(), "deuce");

        tennis.setPoints(3, 5);
        assertEquals(tennis.getScore(), "joseph win");

        tennis.setPoints(4, 0);
        assertEquals(tennis.getScore(), "joey win");
    }
}
