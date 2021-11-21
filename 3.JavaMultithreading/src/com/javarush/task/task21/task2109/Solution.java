package com.javarush.task.task21.task2109;

/* 
Запретить клонирование
*/

public class Solution {
    public static class A implements Cloneable {
        private int i;
        private int j;

        public A(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public int getI() {
            return i;
        }

        public int getJ() {
            return j;
        }
    }

    public static class B extends A {
        private String name;

        public B(int i, int j, String name) {
            super(i, j);
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        public Object clone() throws CloneNotSupportedException {
            throw new CloneNotSupportedException();
        }
    }

    public static class C extends B {
        public C(int i, int j, String name) {
            super(i, j, name);
        }

        @Override
        public Object clone() throws CloneNotSupportedException {
            C c = new C(getI(), getJ(), getName());
            return c;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (!(obj instanceof C))
                return false;
            C c = (C) obj;
            if(this.getI() != c.getI()) return false;
            if(this.getJ() != c.getJ()) return false;
            if(this.getName() != null ? !this.getName().equals(c.getName()): c.getName() != null) return false;

            return true;
        }

        @Override
        public int hashCode() {
            int result = 31 * this.getI() + getJ();
            result = 31 *  result + (this.getName() != null ? this.getName().hashCode() : 0);

            return result;
        }
    }

    public static void main(String[] args) {
        C c1 = new C(1, 2, "abc");
        C c2 = null;

        try {
            c2 = (C) c1.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        System.out.println(c1.equals(c2));
        System.out.println(c1.hashCode() + " " + c2.hashCode());
        System.out.println(c1);
        System.out.println(c2);
    }
}
