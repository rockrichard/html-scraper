package com.sainsburys.scraper.model;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;

import java.text.DecimalFormat;

/**
 * Represents Product value object, also output in Json.
 *
 * Created by Richard Ho on 5/15/2016.
 */
public class Product {
    private String title;
    private long size;
    private double unitPrice;
    private String description;

    public Product(String title, long size, double unitPrice, String description) {
        this.title = title;
        this.size = size;
        this.unitPrice = unitPrice;
        this.description = description;
    }

    /**
     * Getter
     * @return
     */
    public String getTitle() {
        return title;
    }

    /**
     * Setter
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Getter
     * @return
     */
    @JsonIgnore
    public long getSize() {
        return size;
    }

    /**
     * Text representation of size. Get size in KB as a string.
     * @return
     */
    @JsonProperty("size")
    public String getSizeInKb() {
        double sizeInKb = (double)size / 1024;
        return new DecimalFormat("#.##").format(sizeInKb) + "kb";
    }

    /**
     * Setter
     * @param size
     */
    public void setSize(long size) {
        this.size = size;
    }

    /**
     * Getter
     * @return
     */
    @JsonProperty("unit_price")
    public double getUnitPrice() {
        return unitPrice;
    }

    /**
     * Setter
     * @param unitPrice
     */
    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    /**
     * Getter
     * @return
     */
    public String getDescription() {
        return description;
    }

    /**
     * Setter
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Text representation of this object.
     * @return
     */
    @Override
    public String toString() {
        return "Product{" +
                "title='" + title + '\'' +
                ", size=" + size +
                ", unitPrice=" + unitPrice +
                ", description='" + description + '\'' +
                '}';
    }
}
