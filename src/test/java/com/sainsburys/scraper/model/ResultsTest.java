package com.sainsburys.scraper.model;

import com.sainsburys.utils.JsonUtils;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ResultsTest {

    private Results results;

    @Before
    public void setUp() throws Exception {
        results = new Results();
    }

    @Test
    public void testAddResultAndGetSize() throws Exception {
        assertEquals(0, results.getSize());

        results.addResult(null, 0, 0.0, null);
        assertEquals(1, results.getSize());

        results.addResult(null, 0, 0.0, null);
        assertEquals(2, results.getSize());
    }

    @Test
    public void testGetTotal() throws Exception {
        // ensure we start from empty, no dependency on other tests.
        assertEquals(0, results.getSize());

        results.addResult("prod1", 0, 1.0, null);
        assertEquals(1.0, results.getTotal(), 0.001);

        results.addResult("prod2", 0, 0.0, null);
        assertEquals(1.0, results.getTotal(), 0.001);

        results.addResult("prod3", 0, 0.1, null);
        assertEquals(1.1, results.getTotal(), 0.001);
    }

    @Test
    public void testResultsJsonRepresentation() throws Exception {
        // set up
        JsonUtils jsonUtils = new JsonUtils();

        // ensure we start from empty, no dependency on other tests.
        assertEquals(0, results.getSize());

        results.addResult("prod1", 0, 1.0, "");
        assertEquals("{\"results\":[{\"title\":\"prod1\",\"description\":\"\",\"unit_price\":1.0,\"size\":\"0kb\"}],\"total\":1.0}", jsonUtils.toJsonString(results, false));
    }
}