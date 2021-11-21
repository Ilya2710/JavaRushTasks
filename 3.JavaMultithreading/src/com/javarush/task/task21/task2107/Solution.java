package com.javarush.task.task21.task2107;

import java.util.LinkedHashMap;
import java.util.Map;

/* 
Глубокое клонирование карты
*/

// В классе Solution должен быть корректно реализован метод clone.
// Карта users клонированного объекта должна быть равна(сравнение через equals) карте users клонируемого объекта

public class Solution implements Cloneable {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.users.put("Hubert", new User(172, "Hubert"));
        solution.users.put("Zapp", new User(41, "Zapp"));
        Solution clone = null;
        try {
            clone = (Solution) solution.clone();
            System.out.println(solution);
            System.out.println(clone);

            System.out.println(solution.users);
            System.out.println(clone.users);

        } catch (CloneNotSupportedException e) {
            e.printStackTrace(System.err);
        }
        System.out.println(solution.users.equals(clone.users));
        System.out.println(solution.users.get("Hubert").equals(clone.users.get("Hubert")));
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Solution solution = new Solution();
        solution.users = new LinkedHashMap();

        for (Map.Entry<String, User> entry : users.entrySet())
            solution.users.put(entry.getKey(), entry.getValue() == null ? null : (User) entry.getValue().clone());

        return solution;
    }

    protected Map<String, User> users = new LinkedHashMap();

    public static class User implements Cloneable {
        int age;
        String name;

        public User(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        public Object clone() throws CloneNotSupportedException {
            User user =  new User(age, name);
            return user;
        }

        @Override
        public boolean equals(Object obj) {
            if(this == obj)
                return true;
            if (obj == null || !(obj instanceof User))
                return false;

            User user = (User) obj;
            if(this.age != user.age) return false;
            if(this.name == null ? user.name != null : !this.name.equals(user.name)) return false;

            return true;
        }

        @Override
        public int hashCode() {
            int result = this.age;
            result = 31 * result + (this.name == null ? 0 : this.name.hashCode());

            return result;
        }
    }
}
