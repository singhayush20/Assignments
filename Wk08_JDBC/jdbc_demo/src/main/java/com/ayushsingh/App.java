package com.ayushsingh;


import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * This class is the Main starting class for the project.
 * In the {@link #main(String[])} method, the database operations are performed.
 * In the {@link #displayResultSet(ResultSet)} method, the result set is displayed.
 *
 * @author Ayush Singh
 * @version 1.0
 * @since 12-05-2024
 */
public class App {
    public static void main(String[] args) {
        try {
            DBOperations.createTable();

            // -Insert product
            DBOperations.insertProduct("Product A", 5674, 100);
            DBOperations.insertProduct("Product B", 1800, 200);
            DBOperations.insertProduct("Product C", 4556, 453);

            // - Read products
            ResultSet resultSet = DBOperations.readProducts();
            displayResultSet(resultSet);

            // - Update product price
            DBOperations.updateProductPrice(8, 25.75);
            System.out.println("Product price updated");

            // - Delete product
            DBOperations.deleteProduct(14);
            System.out.println("Product deleted");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void displayResultSet(ResultSet resultSet) throws SQLException {
        System.out.println("Product Data:");
        while (resultSet.next()) {
            int productId = resultSet.getInt("product_id");
            String productName = resultSet.getString("product_name");
            double productPrice = resultSet.getDouble("product_price");
            int productQuantity = resultSet.getInt("product_quantity");
            System.out.println("ID: " + productId + ", Name: " + productName + ", Price: $" + productPrice + ", Quantity: " + productQuantity);
        }
        resultSet.close();
    }
}
