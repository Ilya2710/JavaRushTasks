package com.javarush.task.task21.task2105;

import java.util.HashSet;
import java.util.Set;

/* 
Исправить ошибку. Сравнение объектов
*/

public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o)
            return true;
        if (!(o instanceof Solution))
            return false;
        Solution n = (Solution) o;

        if (n.first == null)
            if (first != null)
                return false;
            else
                return n.last == null ? last == null : n.last.equals(last);

        if (n.last == null)
            if (last != null)
                return false;
            else
                return n.first == null ? first == null : n.first.equals(first);

        return n.first.equals(first) && n.last.equals(last);
    }

    @Override
    public int hashCode() {
        int result = 31 * (this.first == null ? 0 : first.hashCode());
        return result + (this.last == null ? 0 : last.hashCode());
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Mickey", "Mouse"));
        System.out.println(s.contains(new Solution("Mickey", "Mouse")));
        System.out.println((new Solution("Mickey", "Mouse")).hashCode());
        System.out.println((new Solution("Mickey", "Mouse")).hashCode());
    }
}
