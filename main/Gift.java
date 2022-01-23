package main;

import enums.Category;

public class Gift {
    private String productName;
    private Double price;
    private Category category;
    private int quantity;

    /**
     *
     */
    public Gift() {
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

    /**
     * @return
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity
     */
    public void setQuantity(final int quantity) {
        this.quantity = quantity;
    }
}
