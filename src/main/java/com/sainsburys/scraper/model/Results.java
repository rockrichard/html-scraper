package com.sainsburys.scraper.model;

import org.codehaus.jackson.annotate.JsonIgnore;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents Results value object, also output in Json.
 *
 * Created by Richard Ho on 5/15/2016.
 */
public class Results {
    private List<Product> results = new ArrayList<Product>();

    /**
     * Add a product to the array list.
     * @param title
     * @param size
     * @param unitPrice
     * @param description
     */
    public void addResult(String title, long size, double unitPrice, String description) {
        results.add(new Product(title, size, unitPrice, description));
    }

    /**
     * Get product list.
     * @return
     */
    public List<Product> getResults() {
        return results;
    }

    /**
     * Get size of result array list.
     * @return
     */
    @JsonIgnore
    public int getSize() {
        return results.size();
    }

    /**
     * Get total by adding unit price for each product in the list.
     * @return
     */
    public double getTotal() {
        BigDecimal total = new BigDecimal("0");
        for(Product product: results) {
            total = total.add(new BigDecimal(product.getUnitPrice()));
        }

        return total.doubleValue();
    }
}
