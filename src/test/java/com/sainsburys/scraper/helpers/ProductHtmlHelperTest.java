package com.sainsburys.scraper.helpers;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import static org.junit.Assert.*;

public class ProductHtmlHelperTest {

    private Document productListDoc;
    private Document productDetailDoc;
    private ProductHtmlHelper helper;

    @Before
    public void setUp() throws Exception {
        // Load test data from classpath
        InputStream inputStreamProdcutList = this.getClass().getResourceAsStream("ProductList.html");
        productListDoc = Jsoup.parse(inputStreamProdcutList, null, "");

        InputStream inputStreamProdcutDetail = this.getClass().getResourceAsStream("ProductDetail.html");
        productDetailDoc = Jsoup.parse(inputStreamProdcutDetail, null, "");

        helper = new ProductHtmlHelper();
    }

    @Test
    public void testGetProductList() throws Exception {
        // expect to find 7 product in the test data
        assertEquals(7, helper.getProductList(productListDoc).size());
    }

    @Test
    public void testGetProductTitle() throws Exception {
        Elements elements = helper.getProductList(productListDoc);
        assertEquals(
                "Sainsbury's Apricot Ripe & Ready x5",
                helper.getProductTitle(elements.first())
        );
    }

    @Test
    public void testGetProductDetailLink() throws Exception {
        Elements elements = helper.getProductList(productListDoc);
        assertEquals(
                "http://hiring-tests.s3-website-eu-west-1.amazonaws.com/2015_Developer_Scrape/sainsburys-apricot-ripe---ready-320g.html",
                helper.getProductDetailLink(elements.first())
        );
    }

    @Test
    public void testGetLinkResourceSize() throws Exception {
        assertEquals(
                49365,
                helper.getLinkResourceSize(this.getClass().getResource("ProductList.html").toString())
        );
    }

    @Test
    public void testGetPricePerUnit() throws Exception {
        Elements elements = helper.getProductList(productListDoc);
        assertEquals(
                3.5,
                helper.getPricePerUnit(elements.first()),
                0.01
        );
    }

    @Test
    public void testGetDescription() throws Exception {
        assertEquals(
                "Apricots",
                helper.getDescription(productDetailDoc)
        );
    }
}