namespace ProductsCSharp {
    class Products {

        private const int MaxProducts = 5;
        private const string Line = "--------------------------------------";

        /// <summary>
        /// Insert a new product into an array of products, provided that there is available space.
        /// </summary>
        /// <param name="products">An array of Product objects in which to insert the new product.</param>
        private static void InsertProduct(Product[] products) {
            Console.Write("Enter Product ID: ");
            int productId = int.Parse(Console.ReadLine() ?? string.Empty);

            Console.Write("Enter Product Name: ");
            string name = Console.ReadLine() ?? string.Empty;

            Console.Write("Enter Category (a single character): ");
            char category = Console.ReadLine()![0];

            Console.Write("Enter Price: ");
            double price = double.Parse(Console.ReadLine() ?? string.Empty);

            Console.Write("Enter Weight: ");
            float weight = float.Parse(Console.ReadLine() ?? string.Empty);

            Console.Write("Is it In Stock (true/false): ");
            bool inStock = bool.Parse(Console.ReadLine() ?? string.Empty);

            products[Product.GetProductCounter()] = new Product(productId, name, category, price, weight, inStock);
        }

        /// <summary>
        /// Retrieve and display product information from an array of products.
        /// </summary>
        /// <param name="products">An array of Product objects from which to retrieve information.</param>
        private static void GetProduct(Product[] products) {
            Product? productToView = null;

            Console.Write("Enter the Product ID to view details: ");
            int productId = int.Parse(Console.ReadLine() ?? string.Empty);

            for (int i = 0; i < Product.GetProductCounter(); i++) {
                if (products[i].ProductId == productId) {
                    productToView = products[i];
                    break;
                }
            }

            if (productToView != null) {
                Product.PrintProductInfo(productToView);
            } else {
                Console.WriteLine("Product not found.");
            }
        }

        /// <summary>
        /// Main method for managing products and interacting with the user.
        /// </summary>
        /// <param name="args">Command-line arguments (not used).</param>
        static void Main(string[] args) {
            Product[] products = new Product[MaxProducts];
            int choice;

            do {
                Console.WriteLine(Line);
                Console.WriteLine("Select an option:");
                Console.WriteLine("1. Add a new product");
                Console.WriteLine("2. View product details");
                Console.WriteLine("3. Exit");
                Console.WriteLine(Line);

                Console.WriteLine("Enter an option: ");
                choice = int.Parse(Console.ReadLine() ?? string.Empty);

                switch (choice) {
                    case 1:
                        if (Product.GetProductCounter() < products.Length) {
                            InsertProduct(products);
                        } else {
                            Console.WriteLine("The product list is full.");
                        }
                        break;
                    case 2:
                        if (Product.GetProductCounter() != 0) {
                            GetProduct(products);
                        } else {
                            Console.WriteLine("The product list is empty.");
                        }
                        break;
                    case 3:
                        Console.WriteLine("Exiting the product management system.");
                        break;
                    default:
                        Console.WriteLine("Invalid choice. Please select a valid option.");
                        break;
                }
            } while (choice != 3);
        }

    }
}
