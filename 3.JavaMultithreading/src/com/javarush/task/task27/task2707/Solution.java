package com.javarush.task.task27.task2707;

/* 
Определяем порядок захвата монитора
*/

public class Solution {
    public void someMethodWithSynchronizedBlocks(Object obj1, Object obj2) {
        synchronized (obj1) {
            synchronized (obj2) {
                System.out.println(obj1 + " " + obj2);
            }
        }
    }

    public static boolean isLockOrderNormal(final Solution solution, final Object o1, final Object o2) throws Exception {
        //do something here

        Thread thread1 = new Thread() {
            @Override
            public void run() {
                synchronized (o1) {
                    System.out.println("Лочим o1");
                    while (true) {
                    }
                }
            }
        };
        thread1.setDaemon(true);
        thread1.start();

        Thread.currentThread().sleep(100);

        Thread threadInvokeMethod = new Thread() {
            @Override
            public void run() {
                solution.someMethodWithSynchronizedBlocks(o1, o2);
            }
        };
        threadInvokeMethod.setDaemon(true);
        threadInvokeMethod.start();

        Thread.currentThread().sleep(100);

        Thread thread2 = new Thread() {
            @Override
            public void run() {
                synchronized (o2) {
                    System.out.println("Успешно лочим o2");
                }
            }
        };
        thread2.setDaemon(true);
        thread2.start();

        Thread.currentThread().sleep(100);

        return !thread2.isAlive();
    }

    public static void main(String[] args) throws Exception {
        final Solution solution = new Solution();
        final Object o1 = new Object();
        final Object o2 = new Object();

        System.out.println(isLockOrderNormal(solution, o1, o2));
    }
}
