package com.seavus.timeperiodoverlap;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.time.LocalTime;

@RunWith(JUnit4.class)
public class TimePeriodOverlapsWithTest {

    private TimePeriod timePeriod;

    @Before
    public void setUp() throws Exception {
        timePeriod = new TimePeriod(LocalTime.now(), LocalTime.now().plusHours(7));
    }

    @Test
    public void testOverlaps() throws Exception {
        boolean flag = timePeriod.overlapsWith(new TimePeriod(LocalTime.now().plusHours(4), LocalTime.now().plusHours(6)));
        Assert.assertEquals(true, flag);
    }

    @Test
    public void testNotOverlaps() throws Exception {
        boolean flag = timePeriod.overlapsWith(new TimePeriod(LocalTime.now().plusHours(4), LocalTime.now().plusHours(9)));
        Assert.assertEquals(false, flag);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWhenFirstArgumentsIsNull() throws Exception {
        timePeriod.overlapsWith(new TimePeriod(null, LocalTime.now()));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWhenSecondArgumentsIsNull() throws Exception {
        timePeriod.overlapsWith(new TimePeriod(LocalTime.now(), null));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWhenTimePeriodIsNull() throws Exception {
        timePeriod.overlapsWith(null);
    }
}
