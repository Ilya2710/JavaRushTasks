package com.javarush.task.task18.task1828;

import java.io.*;
import java.util.*;

/* 
Прайсы 2
*/

// C:/Projects/JavaRushTasks/JavaRushTasks/2.JavaCore/src/com/javarush/task/task18/task1828/Table.txt
// -c Кроссовки New Balance 123.45 685
// -u 198478  Шорты пляжные желтые с рисунко 183.00  18
// -d 198478

public class Solution {
    public static void main(String[] args) {
        try {
            if (args.length == 0)
                throw new IllegalArgumentException();

            String fileName;
            List<Product> products = new ArrayList<>();

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            fileName = reader.readLine();
            reader.close();

            readProducts(fileName, products);

            switch (args[0]) {
                case "-c":
                    int maxId = getMaxId(products);
                    Product newProduct = createNewProduct(maxId + 1, args);
                    products.add(newProduct);
                    printNewProduct(fileName, newProduct);
                    break;
                case "-u":
                    updateProduct(args, products);
                    printAllProducts(fileName, products);
                    break;
                case "-d":
                    deleteProduct(args, products);
                    printAllProducts(fileName, products);
                    break;
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Некорректный набор параметров");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e ) {
            e.printStackTrace();
        }
    }

    public static void readProducts(String fileName, List<Product> products) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(fileName));
            while (reader.ready())
                products.add(new Product(reader.readLine()));
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int getMaxId (List<Product> products) {
        int maxId = 0;

        for (Product product : products)
            if (maxId < product.id)
                maxId = product.id;

        return maxId;
    }

    public static Product createNewProduct(int nextId, String[] args) {
        int id;
        String productName = "";
        float price = 0f;
        int quantity = 0;

        id = nextId;
        for (int i = 1; i < args.length - 2; i++) {
            productName += args[i];
            if(i != args.length - 1)
                productName += " ";
        }
        if (productName.length() > 30)
            productName = productName.substring(0, 30).trim();

        if (args[args.length - 2].length() > 8)
            args[args.length - 2] = args[args.length - 2].substring(0, 8);
        if (args[args.length - 1].length() > 4)
            args[args.length - 1] = args[args.length - 1].substring(0, 4);

        try {
            price = Float.parseFloat(args[args.length - 2]);
            quantity = Integer.parseInt(args[args.length - 1]);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        return new Product(id, productName, price, quantity);
    }

    public static Product updateProduct(String[] args, List<Product> products){
        int updatedProductIndex = findProcuctIndex (args[1], products);
        if (updatedProductIndex < 0)
            throw new IllegalArgumentException();

        int updatedProductId = -1;
        try {
            updatedProductId = Integer.parseInt(args[1]);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        String[] argsWithoutIndex = new String[args.length-1];
        argsWithoutIndex[0] = args[0];
        for (int i = 2; i < args.length; i++)
            argsWithoutIndex[i-1] = args[i];

        Product oldUpdateProduct = products.get(updatedProductIndex);
        Product newUpdatedProduct = createNewProduct(updatedProductId, argsWithoutIndex);
        products.set(updatedProductIndex, newUpdatedProduct);

        return oldUpdateProduct;
    }

    public static Product deleteProduct(String[] args, List<Product> products){
        int deletedProductIndex = findProcuctIndex(args[1], products);
        Product deletedProduct = products.get(deletedProductIndex);

        products.remove(deletedProductIndex);

        return  deletedProduct;
    }

    public static void printNewProduct(String fileName, Product product) {
        try {
            FileWriter fileWriter = new FileWriter(fileName, true);
            fileWriter.write(product.toString());
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void printAllProducts(String fileName, List<Product> products) {
        try {
            FileWriter fileWriter = new FileWriter(fileName, false);
            for (Product product : products)
                fileWriter.write(product.toString());
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int findProcuctIndex(String idStr, List<Product> products) {
        int id = -1;

        try {
            id = Integer.parseInt(idStr);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < products.size(); i++)
            if (products.get(i).id == id)
                return i;

        return -1;
    }

    public static class Product {
        int id;
        String productName;
        float price;
        int quantity;

        public Product(String product) {
            try {
                id = Integer.parseInt(product.substring(0, 8).trim());
                productName = product.substring(8, 38).trim();
                price = Float.parseFloat(product.substring(38, 46).trim());
                quantity = Integer.parseInt(product.substring(46, 50).trim());
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(e);
            }
        }

        public Product(int id, String productName, float price, int quantity) {
            this.id = id;
            this.productName = productName;
            this.price = price;
            this.quantity = quantity;
        }

        @Override
        public String toString() {
            return String.format(Locale.US,"%-8d%-30s%-8.2f%-4d\n", id, productName, price, quantity);
        }
    }
}
