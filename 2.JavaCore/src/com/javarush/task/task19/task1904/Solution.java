package com.javarush.task.task19.task1904;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/* 
И еще один адаптер
*/

// C:/Projects/JavaRushTasks/JavaRushTasks/2.JavaCore/src/com/javarush/task/task19/task1904/Text.txt

public class Solution {

    public static void main(String[] args) {

    }

    public static class PersonScannerAdapter implements PersonScanner {
        private Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }

        @Override
        public Person read() throws IOException {
            String firstName, middleName, lastName;
            int day, month, year;

            lastName = fileScanner.next();
            firstName = fileScanner.next();
            middleName = fileScanner.next();
            day = fileScanner.nextInt();
            month = fileScanner.nextInt();
            year = fileScanner.nextInt();
            Date date = new Date(year - 1900, month - 1, day);

            return new Person(firstName, middleName, lastName, date);
        }
    }
}
