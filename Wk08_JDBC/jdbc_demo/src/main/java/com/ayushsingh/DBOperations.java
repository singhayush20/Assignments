package com.ayushsingh;


import java.sql.*;

/**
 * This class represents the operations to interact with the database regarding product management.
 * It provides methods to create a table, insert, read, update, and delete products from the database.
 * The methods are used in the {@link App} class.
 *
 * @author Ayush Singh
 * @version 1.0
 * @since 12-05-2024
 */
public class DBOperations {


    /**
     * Creates the 'products' table in the database
     * The table contains columns for product ID, name, price, and quantity.
     *
     * @throws SQLException If a SQL exception occurs while executing the create table query.
     */
    public static void createTable() throws SQLException {
        try (Connection conn = DBUtil.getConnection(); Statement statement = conn.createStatement()) {
            String createTableQuery = "CREATE TABLE IF NOT EXISTS products (" + "product_id INT AUTO_INCREMENT PRIMARY KEY, " + "product_name VARCHAR(100), " + "product_price DECIMAL(10, 2), " + "product_quantity INT)";
            System.out.println("Creating table... " + createTableQuery);
            statement.executeUpdate(createTableQuery);
            System.out.println("Table created... ");

        }
    }

    /**
     * Inserts a new product into the 'products' table using a prepared statement.
     *
     * @param productName     The name of the product to be inserted.
     * @param productPrice    The price of the product to be inserted.
     * @param productQuantity The quantity of the product to be inserted.
     * @throws SQLException If a SQL exception occurs while executing the insert query.
     */
    public static void insertProduct(String productName, double productPrice, int productQuantity) throws SQLException {
        String query = "INSERT INTO products (product_name, product_price, product_quantity) VALUES (?, ?, ?)";
        try (Connection conn = DBUtil.getConnection(); PreparedStatement preparedStatement = conn.prepareStatement(query)) {
            preparedStatement.setString(1, productName);
            preparedStatement.setDouble(2, productPrice);
            preparedStatement.setInt(3, productQuantity);
            System.out.println("Inserting product... " + preparedStatement);
            int res = preparedStatement.executeUpdate();
            System.out.println("Rows inserted: " + res);
        }
    }

    /**
     * Reads all products from the 'products' table and returns the result set.
     *
     * @return ResultSet containing product data retrieved from the database.
     * @throws SQLException If a SQL exception occurs while executing the select query.
     */
    public static ResultSet readProducts() throws SQLException {
        String selectQuery = "SELECT * FROM products";
        Connection conn = DBUtil.getConnection();
        Statement statement = conn.createStatement();
        System.out.println("Reading products... " + statement.toString());
        return statement.executeQuery(selectQuery);
    }


    /**
     * Updates the price of a product in the 'products' table based on the product ID.
     *
     * @param productId The ID of the product to update.
     * @param newPrice  The new price to set for the product.
     * @throws SQLException If a SQL exception occurs while executing the update query.
     */
    // -update product price
    public static void updateProductPrice(int productId, double newPrice) throws SQLException {
        String updateQuery = "UPDATE products SET product_price = ? WHERE product_id = ?";
        try (Connection conn = DBUtil.getConnection(); PreparedStatement preparedStatement = conn.prepareStatement(updateQuery)) {
            preparedStatement.setDouble(1, newPrice);
            preparedStatement.setInt(2, productId);
            System.out.println("Updating product price... " + preparedStatement);
            int res = preparedStatement.executeUpdate();
            System.out.println("Rows updated: " + res);
        }
    }

    /**
     * Deletes a product from the 'products' table based on the product ID.
     *
     * @param productId The ID of the product to delete.
     * @throws SQLException If a SQL exception occurs while executing the delete query.
     */
    public static void deleteProduct(int productId) throws SQLException {
        String deleteQuery = "DELETE FROM products WHERE product_id = ?";
        try (Connection conn = DBUtil.getConnection(); PreparedStatement preparedStatement = conn.prepareStatement(deleteQuery)) {
            preparedStatement.setInt(1, productId);
            System.out.println("Deleting product... " + preparedStatement);
            int res = preparedStatement.executeUpdate();
            System.out.println("Rows deleted: " + res);
        }
    }



}
