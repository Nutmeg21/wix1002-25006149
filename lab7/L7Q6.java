import java.util.*;
import java.io.*;

class Product {
    String id;
    String name;
    double price;

    public Product(String productId, String productName, double productPrice)
    {
        id = productId;
        name = productName;
        price = productPrice;
    }

    public String getID()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public double getPrice()
    {
        return price;
    }
}
public class L7Q6 {
    public static void main(String[] args) {
        try {
            BufferedReader productInput = new BufferedReader(new FileReader("datasets/product.txt"));
            ArrayList<Product> products = new ArrayList<>();
            String productStr;
            while((productStr = productInput.readLine()) != null)
            {
                String[] productArr = productStr.split(",");
                String id = productArr[0];
                String name = productArr[1];
                double price = Double.parseDouble(productArr[2]);
                products.add(new Product(id, name, price));
            }
            productInput.close();

            System.out.println("ProductID\tProductName\t\tQuantity\tPricePerUnit\tTotal");
            BufferedReader orderInput = new BufferedReader(new FileReader("datasets/order.txt"));
            String orderStr;
            while((orderStr = orderInput.readLine()) != null)
            {
                String[] orderArr = orderStr.split(",");
                String productID = orderArr[1];
                int quantity = Integer.parseInt(orderArr[2]);
                String productName = "";
                double pricePerUnit = 0, totalPrice = 0;

                for(Product product : products)
                {
                    if (product.getID().equals(productID))
                    {
                        productName = product.getName();
                        pricePerUnit = product.getPrice();
                        totalPrice = pricePerUnit * quantity;
                    }
                }

                String rowFormat = "%-15s %-23s %-15d %-15s %-15s";
                System.out.printf(rowFormat, productID, productName, quantity, String.format("%.2f", pricePerUnit), String.format("%.2f",totalPrice));
                System.out.println();
            }
            orderInput.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
