package com.example.test.mytest;

import org.junit.Test;

import static org.junit.Assert.*;


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void subtraction_isCorrect() throws Exception {
        assertEquals(2, 4 - 2);
    }

    @Test
    public void isValidEmail_isCorrect() throws Exception {
        assertTrue(MainActivity.isValidEmail("name@email.com"));
    }
}