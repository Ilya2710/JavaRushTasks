package com.javarush.task.task20.task2014;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Serializable Solution
*/

// C:/Projects/JavaRushTasks/JavaRushTasks/2.JavaCore/src/com/javarush/task/task20/task2014/your_file_name.txt

public class Solution implements Serializable {
    public static void main(String[] args) {
        String fileName = "C:/Projects/JavaRushTasks/JavaRushTasks/2.JavaCore/src/com/javarush/task/task20/task2014/your_file_name.txt";

        try {
            FileOutputStream fos = new FileOutputStream(fileName);
            FileInputStream fis = new FileInputStream(fileName);

            Solution savedObject = new Solution(6);
            ObjectOutputStream outputStream = new ObjectOutputStream(fos);
            outputStream.writeObject(savedObject);

            Solution loadedObject = null;
            ObjectInputStream inputStream = new ObjectInputStream(fis);
            try {
                loadedObject = (Solution) inputStream.readObject();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            if (loadedObject != null && savedObject.string.equals(loadedObject.string))
                System.out.println("true");

            outputStream.close();
            inputStream.close();
            fos.close();
            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(new Solution(4));
    }

    private transient final String pattern = "dd MMMM yyyy, EEEE";
    private transient Date currentDate;
    private transient int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and the current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }
}
