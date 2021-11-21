package com.javarush.task.task18.task1827;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* 
Прайсы
*/

// C:/Projects/JavaRushTasks/JavaRushTasks/2.JavaCore/src/com/javarush/task/task18/task1827/Table.txt
// -c "Кроссовки New Balance" 123.45 685

public class Solution {
    public static void main(String[] args) throws Exception {
//        if (args.length < 4 || args[0] == null || args[1] == null || args[2] == null || args[3] == null)
//            throw new IllegalArgumentException();
        if (args.length != 0 && args[0].equals("-c")) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String fileName = reader.readLine();
            reader.close();

            reader = new BufferedReader(new FileReader(fileName));
            List<Integer> list  = new ArrayList<>();

            while (reader.ready()) {
                String str = reader.readLine();
                int id = Integer.parseInt(str.substring(0, 8).trim());
                list.add(id);
            }
            reader.close();

            Collections.sort(list);
            int nextId = list.get(list.size()-1) + 1;

            double price = Double.parseDouble(args[2]);
            int quantity = Integer.parseInt(args[3]);

            PrintStream printStream = new PrintStream(new FileOutputStream(fileName, true));
            printStream.printf("\n%-8d%-30s%-8.2f%-4d", nextId, args[1], price, quantity);
            printStream.close();
        }
    }
}
