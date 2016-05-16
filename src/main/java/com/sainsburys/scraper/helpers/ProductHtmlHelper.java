package com.sainsburys.scraper.helpers;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;

/**
 * Product Html Helper:
 *      It contains css selectors to locate the data we need in *product related* html page.
 *
 * Created by Richard Ho on 5/15/2016.
 */
public class ProductHtmlHelper {

    /**
     * Get Product list from a given HTML element.
     * @param element
     * @return
     */
    public Elements getProductList(Element element) {
        return element.select("div.product ");
    }

    /**
     * Get Product title from a given HTML element.
     * @param element
     * @return
     */
    public String getProductTitle(Element element) {
        return element.select("div.productInfo a").first().text();
    }

    /**
     * Get Product detail link from a given HTML element.
     * @param element
     * @return
     */
    public String getProductDetailLink(Element element) {
        return element.select("div.productInfo a").first().attr("href");
    }

    /**
     * Get link resource size. (the size of resource itself, not including assets)
     * @param link
     * @return
     * @throws IOException
     */
    public long getLinkResourceSize(String link) throws IOException {
        return new URL(link).openConnection().getContentLength();
    }

    /**
     * Get Price per Unit from a given HTML element. This will remove all the non-digit characters (pound symbol etc.)
     * @param element
     * @return
     */
    public double getPricePerUnit(Element element) {
        // Regex [\D&&[^\.]]: remove all the non-digit characters but not ".".
        String pricePerUnit = element.select("p.pricePerUnit").first().ownText().replaceAll("[\\D&&[^\\.]]", "");
        return Double.valueOf(pricePerUnit);
    }

    /**
     * Get Description from a given HTML element.
     * @param element
     * @return
     */
    public String getDescription(Element element) {
        return element.select("div.productText p").first().text();
    }

}
