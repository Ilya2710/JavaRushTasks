package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

// -c Миронов м 15/04/1990
// -u 1 Козлов м 12/04/1082
// -d 1
// -i

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        try {
            switch (args[0]) {
                case "-c":
                    allPeople.add(createPerson(args[1], args[2], args[3]));
                    System.out.println(allPeople.size() - 1);
                    break;
                case "-u":
                    updatePerson(args[1], args[2], args[3], args[4]);
                    break;
                case "-d":
                    deletePerson(args[1]);
                    break;
                case "-i":
                    printPerson(args[1]);
                    break;
                default:
                    throw new IllegalArgumentException();
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new IllegalArgumentException(e);
        }
        catch (IllegalArgumentException e) {
            System.out.println("Некорректный набор параметров");
        }

        //        for (int i = 0; i < allPeople.size(); i++) {
//            System.out.println("Id: " + i + "; Name: " + allPeople.get(i).getName() + "; Sex: " + allPeople.get(i).getSex() +
//            "; BirthDate: " + allPeople.get(i).getBirthDate());
//        }
    }

    public static Person createPerson(String name, String sexStr, String birthDateStr) throws IllegalArgumentException {
        Date birthDate;
        Person person;

        birthDate = getDate(birthDateStr);

        switch (sexStr) {
            case "м":
                person = Person.createMale(name, birthDate);
                break;
            case "ж":
                person = Person.createFemale(name, birthDate);
                break;
            default:
                throw new IllegalArgumentException();
        }

        return person;
    }

    public static Person updatePerson(String idStr, String name, String sexStr, String birthDateStr) throws IllegalArgumentException {
        int id;
        Sex sex;
        Date birthDate;
        Person person;

        try {
            id = Integer.parseInt(idStr);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(e);
        }

        if (id < 0 || id >= allPeople.size())
            throw new IllegalArgumentException();

        switch (sexStr) {
            case "м":
                sex = Sex.MALE;
                break;
            case "ж":
                sex = Sex.FEMALE;
                break;
            default: throw new IllegalArgumentException();

        }

        birthDate = getDate(birthDateStr);

        allPeople.get(id).setName(name);
        allPeople.get(id).setSex(sex);
        allPeople.get(id).setBirthDate(birthDate);

        return allPeople.get(id);
    }

    public static Person deletePerson(String idStr) throws IllegalArgumentException {
        int id;
        Person person;

        try {
            id = Integer.parseInt(idStr);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(e);
        }

        if (id < 0 || id >= allPeople.size())
            throw new IllegalArgumentException();

        allPeople.get(id).setName(null);
        allPeople.get(id).setSex(null);
        allPeople.get(id).setBirthDate(null);

        return allPeople.get(id);
    }

    public static void printPerson(String idStr) throws IllegalArgumentException {
        int id;
        String sexStr = "", birthDateStr;
        Person person;

        try {
            id = Integer.parseInt(idStr);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(e);
        }

        if (id < 0 || id >= allPeople.size())
            throw new IllegalArgumentException();

        switch (allPeople.get(id).getSex()) {
            case MALE:
                sexStr = "м";
                break;
            case FEMALE:
                sexStr = "ж";
                break;
        }

        SimpleDateFormat sDFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        birthDateStr = sDFormat.format(allPeople.get(id).getBirthDate());

        System.out.println(allPeople.get(id).getName() + " " + sexStr + " " + birthDateStr);
    }

    public static Date getDate(String dateStr) throws IllegalArgumentException {
        SimpleDateFormat sDFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        try {
            Date birthDate = sDFormat.parse(dateStr);
            return birthDate;
        } catch (ParseException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
