package com.libofan;

public class JmmExample {
    static class Test {
        public int a;
        Test(int a) {
            this.a = a;
        }
    }
    public static void main(String[] args) {
        final Test test = new Test(10);
        Thread thread1 = new Thread(new Runnable() {
            public void run() {
                test.a++;
                System.out.println(test.a);
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            public void run() {
                test.a++;
                System.out.println(test.a);
            }
        });
        thread1.start();
        thread2.start();
    }
}
