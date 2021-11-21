package com.javarush.task.task18.task1822;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Поиск данных внутри файла
*/

// C:/Projects/JavaRushTasks/JavaRushTasks/2.JavaCore/src/com/javarush/task/task18/task1822/Table.txt
// 198478

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
            int productIndex = findProcuctIndex(args[0], products);
            System.out.println(products.get(productIndex));
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

        public Product(String product) {
            try {
                productName = product;

                int firstWhitespaceIndex = product.indexOf(" ");
                id = Integer.parseInt(product.substring(0, firstWhitespaceIndex));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(e);
            }
        }

        @Override
        public String toString() {
            return productName;
        }
    }
}
