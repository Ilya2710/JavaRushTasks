package com.javarush.task.task20.task2002;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Читаем и пишем в файл: JavaRush
*/

// C:/Projects/JavaRushTasks/JavaRushTasks/2.JavaCore/src/com/javarush/task/task20/task2002/your_file_name.txt

public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream according to your file's actual location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
//            File yourFile = File.createTempFile("your_file_name", null);
            String fileName =  "C:/Projects/JavaRushTasks/JavaRushTasks/2.JavaCore/src/com/javarush/task/task20/task2002/your_file_name.txt";
            File yourFile = new File(fileName);
            OutputStream outputStream = new FileOutputStream(yourFile);
            InputStream inputStream = new FileInputStream(yourFile);

            JavaRush javaRush = new JavaRush();

            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            User user1 = new User();
            user1.setFirstName("Michael");
            user1.setLastName("Schumacher");
            user1.setBirthDate(new Date(69, 0, 3));
            user1.setMale(true);
            user1.setCountry(User.Country.OTHER);
            javaRush.users.add(user1);

            User user2 = new User();
            user2.setFirstName("Mick");
            user2.setLastName("Schumacher");
            user2.setBirthDate(new Date(99, 2, 22));
            user2.setMale(true);
            user2.setCountry(User.Country.RUSSIA);
            javaRush.users.add(user2);

            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //here check that the javaRush object is equal to the loadedObject object - проверьте тут, что javaRush и loadedObject равны
            System.out.println(javaRush.equals(loadedObject));

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with the save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            PrintWriter writer = new PrintWriter(outputStream);
            String isUsers = this.users != null ? "yes" : "no";
            writer.println(isUsers);
//            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            if (this.users != null) {
                writer.println(this.users.size());

                for (int i = 0; i < this.users.size(); i++) {
                    writer.println(this.users.get(i).getFirstName());
                    writer.println(this.users.get(i).getLastName());
//                    writer.println(format.format(this.users.get(i).getBirthDate()));
                    writer.println(this.users.get(i).getBirthDate().getTime());
                    writer.println(this.users.get(i).isMale());
                    writer.println(this.users.get(i).getCountry());
                }
            }

            writer.close();
        }

        public void load(InputStream inputStream) throws Exception {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String isUsers = reader.readLine();
//            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            if (isUsers.equals("no")) {
                this.users = null;
                return;
            } else if (isUsers.equals("yes")) {
                int sizeUsers = Integer.parseInt(reader.readLine());
                for (int i = 0; i < sizeUsers; i++) {
                    User user = new User();
                    user.setFirstName(reader.readLine());
                    user.setLastName(reader.readLine());
//                    user.setBirthDate(format.parse(reader.readLine()));
                    user.setBirthDate(new Date(Long.parseLong(reader.readLine())));
                    user.setMale(Boolean.parseBoolean(reader.readLine()));
                    String countryStr = reader.readLine();
                    User.Country country;
                    switch (countryStr) {
                        case "UKRAINE":
                            country = User.Country.UKRAINE;
                            break;
                        case "RUSSIA":
                            country = User.Country.RUSSIA;
                            break;
                        default:
                            country = User.Country.OTHER;
                            break;
                    }
                    user.setCountry(country);
                    this.users.add(user);
                }
            }

            reader.close();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
