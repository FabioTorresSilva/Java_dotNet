namespace ProductsCSharp;

/// <summary>
/// Represents a product with various attributes and methods for managing products.
/// </summary>
public class Product {

    private const double TaxRate = 0.1; // Constant for the tax rate

    private static int _productCounter = 0;

    private double _price = 0;

    /// <summary>
    /// Gets the total number of products in the system.
    /// </summary>
    /// <returns>The total number of products.</returns>
    public static int GetProductCounter() {
        return Product._productCounter;
    }

    /// <summary>
    /// Default constructor for a Product.
    /// </summary>
    public Product() : this(0, "Unknown", 'U', 0.0, 0.0f, false) {
    }


    /// <summary>
    /// Constructor for a Product with specified attributes.
    /// </summary>
    /// <param name="productId">The product's ID.</param>
    /// <param name="name">The product's name.</param>
    /// <param name="category">The product's category (a single character).</param>
    /// <param name="price">The product's price.</param>
    /// <param name="weight">The product's weight.</param>
    /// <param name="inStock">Whether the product is in stock.</param>
    public Product(int productId, string name, char category, double price, float weight, bool inStock) {
        this.ProductId = productId;
        this.Name = name;
        this.Category = category;
        this.Price = price;
        this.Weight = weight;
        this.InStock = inStock;

        Product._productCounter++;
    }

    /// <summary>
    /// Gets or sets the product's ID.
    /// </summary>
    public int ProductId { get; } = 0;

    /// <summary>
    /// Gets or sets the product's name.
    /// </summary>
    public string Name { get; set; }

    /// <summary>
    /// Gets or sets the product's category (a single character).
    /// </summary>
    public char Category { get; set; }

    /// <summary>
    /// Gets or sets the product's price.
    /// </summary>
    public double Price {
        get => this._price;
        set {
            if (value >= 0) {
                this._price = value;
            }
        }
    }

    /// <summary>
    /// Gets or sets the product's weight.
    /// </summary>
    public float Weight { get; set; }

    /// <summary>
    /// Gets or sets whether the product is in stock.
    /// </summary>
    public bool InStock { get; set; }

    /// <summary>
    /// Calculate the discounted price of the product based on a discount percentage.
    /// </summary>
    /// <param name="discountPercentage">The discount percentage.</param>
    /// <returns>The discounted price.</returns>
    private double CalculateDiscountedPrice(int discountPercentage) {
        return _price - ((double)discountPercentage / 100) * _price;
    }

    /// <summary>
    /// Calculate the price of the product without tax.
    /// </summary>
    /// <returns>The price without tax.</returns>
    private double CalculatePriceWithoutTax() {
        return _price / (1 + TaxRate);
    }

    /// <summary>
    /// Print product information using formatted output.
    /// </summary>
    /// <param name="product">The product to display information for.</param>
    public static void PrintProductInfo(Product product) {
        Console.WriteLine($"Product ID: {product.ProductId}");
        Console.WriteLine($"Name: {product.Name}");
        Console.WriteLine($"Category: {product.Category}");
        Console.WriteLine($"Price (Excluding Tax): ${product.CalculatePriceWithoutTax():F2}");
        Console.WriteLine($"Weight: {product.Weight:F2}");
        Console.WriteLine($"In Stock: {(product.InStock ? "Yes" : "No")}");

        Console.WriteLine("(Products counter: " + Product.GetProductCounter() + ")");
    }
}