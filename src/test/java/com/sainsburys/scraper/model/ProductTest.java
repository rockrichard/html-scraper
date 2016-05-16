package com.sainsburys.scraper.model;

import com.sainsburys.utils.JsonUtils;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ProductTest {

    @Test
    public void testGetSizeInKb() throws Exception {

        assertEquals(
                "0kb",
                new Product(null, 0, 0.0, null).getSizeInKb()
        );

        assertEquals(
                "1kb",
                new Product(null, 1024, 0.0, null).getSizeInKb()
        );

        assertEquals(
                "1.5kb",
                new Product(null, 1536, 0.0, null).getSizeInKb()
        );

    }

    @Test
    public void testProductJsonRepresentation() throws Exception {
        // set up
        JsonUtils jsonUtils = new JsonUtils();
        Product product = new Product("prod1", 1024, 1.1, "desc");

        // assert
        assertEquals("{\"title\":\"prod1\",\"description\":\"desc\",\"unit_price\":1.1,\"size\":\"1kb\"}", jsonUtils.toJsonString(product, false));

    }
}