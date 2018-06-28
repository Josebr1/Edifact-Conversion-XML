package com.github.josebr1.utils;

import static junit.framework.Assert.assertEquals;

public class PathOutputTest {

    @org.junit.Test
    public void formatEdi() {
        assertEquals("value", PathOutput.format("value.edi"));
    }

    @org.junit.Test
    public void formatTxt() {
        assertEquals("value", PathOutput.format("value.txt"));
    }
}