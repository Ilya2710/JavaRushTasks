package com.javarush.task.task21.task2104;

import java.util.HashSet;
import java.util.Set;

/* 
Equals and HashCode
*/

public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    @Override
    public boolean equals(Object n) {
        if(this == n)
            return true;
//        if(n == null || getClass() != n.getClass())
        if(n == null || !(n instanceof Solution))
            return false;
        Solution s = (Solution) n;

        if (this.first == null)
            if (s.first != null)
                return false;
            else
                return this.last == null ? s.last == null : this.last.equals(s.last);

        if (this.last == null)
            if (s.last != null)
                return false;
            else
                return this.first == null ? s.first == null : this.first.equals(s.first);

        return this.first.equals(s.first) && this.last.equals(s.last);
    }

    public int hashCode() {
        int result = 31 * (this.first == null ? 0 : first.hashCode());
        return result + (this.last == null ? 0 : last.hashCode());
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Donald", "Duck"));
        System.out.println(s.contains(new Solution("Donald", "Duck")));
        Solution s1 = new Solution("Abc", "Xyz");
        Solution s2 = new Solution("Abc", "Xyz");
        Solution s3 = new Solution("Abc", "vWx");
        Solution s4 = new Solution(null, "Abc");
        Solution s5 = new Solution("Abc", null);
        Solution s6 = new Solution(null, null);
        Solution s7 = new Solution(null, null);
        System.out.println(s1.equals(s1));
        System.out.println(s1.equals(s2) + " " + s2.equals(s1));
        System.out.println(s1.equals(s3) + " " + s3.equals(s1));
        System.out.println(s1.equals(null));

        System.out.println();
        System.out.println(s1.equals(s4) + " " + s4.equals(s1));
        System.out.println(s3.equals(s5) + " " + s5.equals(s3));
        System.out.println(s4.equals(s5) + " " + s5.equals(s4));
        System.out.println(s4.equals(s6) + " " + s6.equals(s4));
        System.out.println(s5.equals(s6) + " " + s6.equals(s5));
        System.out.println(s6.equals(s7) + " " + s7.equals(s6));

        System.out.println();
        System.out.println(s1.hashCode() + " " + s1.hashCode());
        System.out.println(s1.hashCode() + " " + s2.hashCode());
        System.out.println(s1.hashCode() + " " + s3.hashCode());
        System.out.println(s2.hashCode() + " " + s3.hashCode());
    }
}
