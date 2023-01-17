package edu.algorithms.stack;

import java.sql.SQLOutput;
import java.util.Stack;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.IntStream;

public class TestStack {
    public static void main(String[] args) throws InterruptedException {
//        final ArrayBasedStack arrayBasedStack = new ArrayBasedStack(5);

//        final BlockingStack<String> blockingStack = new BlockingStack<>();
//        blockingStack.push("1");
//        blockingStack.push("2");
//        blockingStack.push("3");
//        blockingStack.push("4");
//        blockingStack.push("5");
//        System.out.println(blockingStack.pop());
//        System.out.println(blockingStack.pop());
//        System.out.println(blockingStack.pop());
//        System.out.println(blockingStack.pop());
//        System.out.println(blockingStack.pop());
//        System.out.println(blockingStack.pop());
////
//        System.out.println(blockingStack);

        final ExecutorService pool = Executors.newFixedThreadPool(12);
        final LockFreeStack<String> lockFreeStack = new LockFreeStack<>();


        final Thread thread1 = new Thread(() -> {
            lockFreeStack.push("Thread1:1");
            lockFreeStack.push("Thread1:2");
            lockFreeStack.push("Thread1:3");
        });

        final Thread thread2 = new Thread(() -> {
            lockFreeStack.push("Thread2:1");
            lockFreeStack.push("Thread2:2");
            lockFreeStack.push("Thread2:3");
        });

        final Thread thread3 = new Thread(() -> {
            lockFreeStack.push("Thread3:1");
            lockFreeStack.push("Thread3:2");
            lockFreeStack.push("Thread3:3");
        });
        thread1.start();
        thread2.start();
        thread3.start();

        while (true) {
            if (!thread1.isAlive() && !thread2.isAlive() && !thread3.isAlive()) {
                System.out.println(lockFreeStack);
                break;
            }
        }


    }
}
