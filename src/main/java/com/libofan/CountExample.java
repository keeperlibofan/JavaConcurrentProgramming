package com.libofan;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;


@Slf4j
public class CountExample {

    private static int threadTotal = 1;
    private static int clientTotal = 5000;

    static Map map = new HashMap<Integer, Integer>();

    private static long count = 0;

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);
        for (int index = 0; index < clientTotal; index++) {
            final int threadNum = index;
            exec.execute(new Runnable() {
                public void run() {
                    try {
                        semaphore.acquire();
                        func(threadNum);
                        semaphore.release();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        exec.shutdown();
        System.out.printf("count: %d \n", count);
        System.out.printf("size: %d \n", map.size());
    }
    private static void func(int threadNum) {
        map.put(threadNum, threadNum);
    }

    private static void add() {
        count++;
    }
}
