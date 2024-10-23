package products;

/**
 *
 * @author Upskill
 *
 * This class represents a Product with various attributes and methods for
 * managing products.
 *
 */
public class Product {

    private static final double TAX_RATE = 0.1;

    private static int productCounter = 0;

    private final int productId;
    private String name;
    private char category;
    private double price;
    private float weight;
    private boolean inStock;

    /**
     * Get the total number of products in the system.
     *
     * @return The total number of products.
     */
    public static int getProductCounter() {
        return productCounter;
    }

    /**
     * Default constructor for Product.
     */
    public Product() {
        this(0, "Unknown", 'U', 0.0, 0.0f, false);
    }

    /**
     * Constructor for Product with specified attributes.
     *
     * @param productId The product's ID.
     * @param name The product's name.
     * @param category The product's category (a single character).
     * @param price The product's price.
     * @param weight The product's weight.
     * @param inStock Whether the product is in stock.
     */
    public Product(int productId, String name, char category, double price, float weight, boolean inStock) {
        this.productId = productId;
        this.name = name;
        this.category = category;
        this.price = price;
        this.weight = weight;
        this.inStock = inStock;

        Product.productCounter++;
    }

    /**
     * Get the product's ID.
     *
     * @return The product's ID.
     */
    public int getProductId() {
        return productId;
    }

    /**
     * Get the product's name.
     *
     * @return The product's name.
     */
    public String getName() {
        return name;
    }

    /**
     * Set the product's name.
     *
     * @param name The product's ID to set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the product's category.
     *
     * @return The product's category.
     */
    public char getCategory() {
        return category;
    }

    /**
     * Set the product's category.
     *
     * @param category The product's ID to set.
     */
    public void setCategory(char category) {
        this.category = category;
    }

    /**
     * Get the product's price.
     *
     * @return The product's price.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Set the price of the product if the provided price is non-negative.
     *
     * @param price The price to set for the product. Must be non-negative.
     */
    public void setPrice(double price) {
        if (price >= 0) {
            this.price = price;
        }
    }

    /**
     * Get the product's weight.
     *
     * @return The product's weight.
     */
    public float getWeight() {
        return weight;
    }

    /**
     * Set the product's name.
     *
     * @param weight The product's ID to set.
     */
    public void setWeight(float weight) {
        this.weight = weight;
    }

    /**
     * Check if the product is currently in stock.
     *
     * @return {@code true} if the product is in stock, {@code false} otherwise.
     */
    public boolean isInStock() {
        return inStock;
    }

    /**
     * Set the availability status of the product.
     *
     * @param inStock {@code true} if the product is in stock, {@code false} if
     * it's out of stock.
     */
    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }

    /**
     * Calculate the discounted price of the product based on a discount
     * percentage.
     *
     * @param discountPercentage The discount percentage.
     * @return The discounted price.
     */
    private double calculateDiscountedPrice(int discountPercentage) {
        return (price - (((double) discountPercentage / 100) * price));
    }

    /**
     * Calculate the price of the product without tax.
     *
     * @return The price without tax.
     */
    private double calculatePriceWithoutTax() {
        return price / (1 + TAX_RATE);
    }

    /**
     * Print product information using printf for formatted output.
     *
     * @param product The product to display information for.
     */
    public static void printProductInfo(Product product) {
        System.out.printf("Product ID: %d%n", product.productId);
        System.out.printf("Name: %s%n", product.name);
        System.out.printf("Category: %c%n", product.category);
        System.out.printf("Price (Excluding Tax): $%.2f%n", product.calculatePriceWithoutTax());
        System.out.printf("Weight: %.2f%n", product.weight);
        System.out.printf("In Stock: %s%n", (product.inStock ? "Yes" : "No"));

        System.out.println("(Products counter: " + Product.getProductCounter() + ")");
    }

}
