package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
Хуан Хуанович
*/

// C:/Projects/JavaRushTasks/JavaRushTasks/2.JavaCore/src/com/javarush/task/task19/task1921/People.txt

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) {
        try {
            FileReader fileReader = new FileReader(args[0]);
            BufferedReader reader = new BufferedReader(fileReader);

            SimpleDateFormat format = new SimpleDateFormat("dd MM yyyy");

            while (reader.ready()) {
                String line = reader.readLine();
                int k = line.length();
                for (int i = 0; i < 3; i++) {
                    k = line.substring(0, k).lastIndexOf(" ");
                }

                String name = line.substring(0, k);
                Date birthDate = null;
                try {
                    birthDate = format.parse(line.substring(k + 1));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                PEOPLE.add(new Person(name, birthDate));
            }

            reader.close();
            fileReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

//        for (Person person : PEOPLE)
//            System.out.println(person.getName() + ": " + person.getBirthDate());
    }
}
