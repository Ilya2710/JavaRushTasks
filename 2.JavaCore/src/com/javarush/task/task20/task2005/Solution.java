package com.javarush.task.task20.task2005;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Очень странные дела
*/

// C:/Projects/JavaRushTasks/JavaRushTasks/2.JavaCore/src/com/javarush/task/task20/task2005/your_file_name.txt

public class Solution {
    public static void main(String[] args) {
        //исправь outputStream/inputStream в соответствии с путем к твоему реальному файлу
        try {
//            File your_file_name = File.createTempFile("your_file_name", null);
            String fileName = "C:/Projects/JavaRushTasks/JavaRushTasks/2.JavaCore/src/com/javarush/task/task20/task2005/your_file_name.txt";
            File your_file_name = new File(fileName);
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            Human ivanov = new Human("Ivanov", new Asset("home"), new Asset("car"));
            ivanov.save(outputStream);
            outputStream.flush();

            Human somePerson = new Human();
            somePerson.load(inputStream);
            //check here that ivanov equals to somePerson - проверьте тут, что ivanov и somePerson равны
            System.out.println(ivanov.equals(somePerson));

            inputStream.close();
        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class Human {
        public String name;
        public List<Asset> assets = new ArrayList<>();

        @Override
        public boolean equals(Object o) {
//            if (this == o) return false;
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Human human = (Human) o;

//            if (name == null ? !name.equals(human.name) : human.name != null) return false;
            if (name != null ? !name.equals(human.name) : human.name != null) return false;
            return assets != null ? assets.equals(human.assets) : human.assets == null;
//            if (Double.compare(asset.price, price) != 0) return false;
//            return name != null ? name.equals(asset.name) : asset.name == null;
        }

        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + (assets != null ? assets.hashCode() : 0);
            return result;
            //            return (int) (Math.random() * 100);
        }

        public Human() {
        }

        public Human(String name, Asset... assets) {
            this.name = name;
            if (assets != null) {
                this.assets.addAll(Arrays.asList(assets));
            }
        }

        public void save(OutputStream outputStream) throws Exception {
            PrintWriter printWriter = new PrintWriter(outputStream);
            if (this.name != null)
                printWriter.println(this.name);
            else
                printWriter.println("null");
            String isAssets = this.assets != null ? "yes" : "no";
            printWriter.println(isAssets);
            if (this.assets != null) {
                printWriter.println(this.assets.size());
                for (int i = 0; i < this.assets.size(); i++)
                    printWriter.println(this.assets.get(i).getName() + " " + this.assets.get(i).getPrice());
            }

            printWriter.close();
        }

        public void load(InputStream inputStream) throws Exception {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String name = reader.readLine();
            if (name.equals("null"))
                this.name = null;
            else
                this.name = name;
            String isAssets = reader.readLine();
            if (isAssets.equals("no")) {
                this.assets = null;
                return;
            } else if (isAssets.equals("yes")) {
                int sizeAssets = Integer.parseInt(reader.readLine());
                for (int i = 0; i < sizeAssets; i++) {
                    String line = reader.readLine();
                    String[] str = line.split(" ");
                    double price = Double.parseDouble(str[1]);
                    Asset asset = new Asset(str[0]);
                    asset.setPrice(price);
                    this.assets.add(asset);
                }
            }

            reader.close();
        }
    }
}
