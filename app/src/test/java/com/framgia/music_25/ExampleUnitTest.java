package com.framgia.music_25;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    private final long EXPECTED = 4;
    private final long ACTUAL = 2 + 2;

    @Test
    public void addition_isCorrect() {
        assertEquals(EXPECTED, ACTUAL);
    }
}