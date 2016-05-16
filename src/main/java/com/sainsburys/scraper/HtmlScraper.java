package com.sainsburys.scraper;

import com.sainsburys.scraper.model.Results;
import com.sainsburys.scraper.helpers.ProductHtmlHelper;
import com.sainsburys.utils.JsonUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;


/**
 * HTML Scraper
 *      1. Console application
 *      2. It scrapes HTML pages.
 *      3. It outputs result in json.
 *
 * Created by Richard Ho on 5/15/2016.
 */
public class HtmlScraper {
    private static final Logger logger = LoggerFactory.getLogger(HtmlScraper.class);

    public static void main(String[] args) {
        ProductHtmlHelper helper = new ProductHtmlHelper();
        Results results = new Results();
        try {
            Document doc = Jsoup.connect("http://hiring-tests.s3-website-eu-west-1.amazonaws.com/2015_Developer_Scrape/5_products.html").get();

            // iterate through each product and construct results
            for(Element e: helper.getProductList(doc)) {
                String link = helper.getProductDetailLink(e);
                Document productDetailDoc = Jsoup.connect(link).get();
                results.addResult(
                        helper.getProductTitle(e),
                        helper.getLinkResourceSize(link),
                        helper.getPricePerUnit(e),
                        helper.getDescription(productDetailDoc)
                );
            }

            logger.info(new JsonUtils().toJsonString(results, true));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
