package main;

import enums.Category;

public class OutputGift {
    private String productName;
    private Double price;
    private Category category;

    /**
     *
     */
    public OutputGift() {
    }

    /**
     * @param productName
     * @param price
     * @param category
     */
    public OutputGift(final String productName, final Double price, final Category category) {
        this.productName = productName;
        this.price = price;
        this.category = category;
    }

    /**
     * @return
     */
    public String getProductName() {
        return productName;
    }

    /**
     * @param productName
     */
    public void setProductName(final String productName) {
        this.productName = productName;
    }

    /**
     * @return
     */
    public Double getPrice() {
        return price;
    }

    /**
     * @param price
     */
    public void setPrice(final Double price) {
        this.price = price;
    }

    /**
     * @return
     */
    public Category getCategory() {
        return category;
    }

    /**
     * @param category
     */
    public void setCategory(final Category category) {
        this.category = category;
    }
}
