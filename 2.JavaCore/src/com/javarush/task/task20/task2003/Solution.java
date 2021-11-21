package com.javarush.task.task20.task2003;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import java.io.*;
import java.text.Format;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Знакомство с properties
*/

// C:/Projects/JavaRushTasks/JavaRushTasks/2.JavaCore/src/com/javarush/task/task20/task2003/config_in.properties
// C:/Projects/JavaRushTasks/JavaRushTasks/2.JavaCore/src/com/javarush/task/task20/task2003/config_out.properties

public class Solution {

    public static Map<String, String> runtimeStorage = new HashMap<>();

    public static void save(OutputStream outputStream) throws Exception {

        Properties prop = new Properties();
        for (Map.Entry<String, String> entry : runtimeStorage.entrySet())
            prop.setProperty(entry.getKey(), entry.getValue());

        prop.store(outputStream, null);
/*
        PrintWriter writer = new PrintWriter(outputStream);

        for (Map.Entry<String, String> entry : runtimeStorage.entrySet()) {
            String[] entryStr = entry.getKey().split(" ");
            for (int i = 0; i < entryStr.length; i++) {
                writer.print(entryStr[i]);
                if (i != entryStr.length - 1) {
                    if (!entryStr[i].endsWith("\\"))
                        writer.print("\\");
                    writer.print(" ");
                }
            }
            writer.println("=" + entry.getValue());
        }

        writer.close();
*/
    }

    public static void load(InputStream inputStream) throws IOException {
        Properties prop = new Properties();
        prop.load(inputStream);
        for (Map.Entry<Object, Object> entry : prop.entrySet())
            runtimeStorage.put(entry.getKey().toString(), entry.getValue().toString());

/*
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        Pattern pattern = Pattern.compile("[^\\\\][:=]");
        while (reader.ready()) {
            String line = reader.readLine();
            if (line.startsWith("!") || line.startsWith("#") || line.isEmpty())
                continue;
            Matcher matcher = pattern.matcher(line);
            int k = -1;
            if (matcher.find())
                k = matcher.start() + 1;

            String[] str = new String[2];
            str[0] = line.substring(0,k).trim();
            str[1] = line.substring(k+1).trim();
            runtimeStorage.put(str[0].trim(), str[1].trim());
        }

        reader.close();
*/
    }

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             FileInputStream fis = new FileInputStream(reader.readLine())) {
            load(fis);
//            FileOutputStream fos = new FileOutputStream(reader.readLine());
//            save(fos);
        } catch (IOException e) {
            e.printStackTrace();
        } /* *catch (Exception e) {
            e.printStackTrace();
        } /**/

        System.out.println(runtimeStorage);
    }
}
