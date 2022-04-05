package com.nahorny.threads.callable.ex2;

import com.nahorny.automationqa.utils.Dates;
import com.nahorny.collections.myimplementation.Logger;
import com.nahorny.pattern.behavioral.mediator.Carpenter;
import javafx.util.Callback;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.TreeSet;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.Phaser;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyCall implements Callable {

    @Override
    public String call() throws Exception {
        TimeUnit.MILLISECONDS.sleep(500);
        return Thread.currentThread().getName() + Dates.now().timeStamp("_yyyy.MM.dd_HH.mm.ss:SSS");
    }

    public static void main(String args[])
            throws BrokenBarrierException, ExecutionException, InterruptedException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        ExecutorService es = Executors.newFixedThreadPool(10);
        List<Future<String>> list = new ArrayList<>();
        Callable<String> callable = new MyCall();

        //        es.execute(MyCall::new);

        for (int i = 0; i < 100; i++) {
            Future<String> future = es.submit(callable);
            list.add(future);
        }

        for (Future<String> fut : list) {
            try {
                Logger.log(fut.get());
            } catch (InterruptedException | ExecutionException ignored) {
            }
        }
        //        CompletableFuture
        //                .supplyAsync(() -> {
        //                    return 50;
        //                })
        //                .thenApply(x -> x * 2)
        //                .thenAccept(System.out::println);

        es.shutdown();
        method();
    }

    static void method()
            throws InterruptedException, ExecutionException, BrokenBarrierException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        ThreadLocal<Integer> ti = ThreadLocal.withInitial(() -> 1);
        System.out.println(ti.get());
        Thread t = new Thread();
        t.setName("dsdsda");
        t.setDaemon(true);

        AtomicInteger ai = new AtomicInteger(0);
        ai.get();

        List l = Collections.synchronizedList(new ArrayList<>());
        Map l2 = Collections.synchronizedMap(new HashMap<>());

        Lock lock = new ReentrantLock();
        lock.lock();
        //synchronized code
        lock.unlock();
        lock.tryLock();

        Condition c = lock.newCondition();
        c.await();
        c.signal();

        FutureTask ft = new FutureTask(MyCall::new);
        new Thread(ft).start();
        ft.get();

        ExecutorService es = Executors.newFixedThreadPool(10);
        es.execute(MyCall::new);

        ScheduledExecutorService ses = Executors.newSingleThreadScheduledExecutor();
        ses.schedule(new Thread(MyCall::new), 5, TimeUnit.SECONDS);
        ses.shutdown();

        Semaphore sem = new Semaphore(2);
        sem.acquire();
        sem.release();

        CountDownLatch countDownLatch = new CountDownLatch(3);
        countDownLatch.await();
        countDownLatch.countDown();

        Exchanger<String> ex = new Exchanger<>();
        ex.exchange("to transmit");
        String toReceive = ex.exchange(null);

        CyclicBarrier cb = new CyclicBarrier(3, MyCall::new);
        cb.await();

        Phaser p = new Phaser(3);
        p.register();
        p.arriveAndAwaitAdvance();

        BlockingQueue<String> bq = new PriorityBlockingQueue<>();
        bq.take();
        bq.add("string");

        ThreadFactory f = new ThreadFactory() {

            @Override public Thread newThread(Runnable r) {
                Thread t = new Thread(r);
                t.setName("");
                t.setPriority(Thread.MAX_PRIORITY);
                return t;
            }
        };
        f.newThread(MyCall::new).start();
        f.newThread(MyCall::new).start();

        int threadCount = Runtime.getRuntime().availableProcessors();
        int operationsCount = 1_000_000;
        ForkJoinPool fp = new ForkJoinPool(threadCount);
        fp.invoke(new MyTask(operationsCount));

        ThreadLocalRandom.current().nextInt(); //instead Math.random() for threads
        TimeUnit.HOURS.toMillis(3);
        TimeUnit.SECONDS.sleep(2);

        Class cc = Class.forName("Carpenter");
        Carpenter ccc = (Carpenter) cc.newInstance();

        javafx.util.Callback<String, String> cb2 = new Callback<String, String>() {

            @Override public String call(String param) {
                return null;
            }
        };
        cb2.call("param");

        System.gc();
        Runtime.getRuntime().gc();
        Object o = new Object();
        //o.finalize(); protected

        SoftReference<String> softRef = new SoftReference<>(new String("stringValue"));
        softRef.get();
        PhantomReference<String> phRef = new PhantomReference<String>(new String("fdd"), new ReferenceQueue<String>());
        PhantomReference<String> phRef2 = new PhantomReference<String>(new String("fdd"), null);

        WeakReference<String> weekRef = new WeakReference<>("string");
        weekRef.get();

        //        new Task("").scheduledExecutionTime();
        TimerTask tt = new TimerTask() {

            @Override public void run() {
                System.out.println("do actions");
            }
        };
        tt.scheduledExecutionTime();

        Timer timer = new Timer("MyTimer");
        timer.scheduleAtFixedRate(tt, 2, 2);

        ConcurrentHashMap<String, String> chm = new ConcurrentHashMap<>();
        chm.values();
        chm.get("dfs");
        chm.keys();

        Hashtable ht = new Hashtable();
        ht.keys();

        Iterator it = new Iterator() {

            @Override public boolean hasNext() {
                return false;
            }

            @Override public Object next() {
                return null;
            }
        };
    }

    static class MyTask extends RecursiveTask<Integer> {

        int operationsCount;

        public MyTask(int operationsCount) {
            this.operationsCount = operationsCount;
        }

        @Override protected Integer compute() {
            return 0;
        }
    }

    //    static class Task extends TimerTask {
    //        private String name;
    //        public Task(String name) {
    //            this.name = name;
    //        }
    //        public void run() {
    //            System.out.println("[" + new Date() + "] " + name + ": task executed!");
    //        }
    //    }

    void method3() {
        LinkedList<String> l = new LinkedList<>();
        l.pop();
//        Set h = new HashSet();
        Set h = new TreeSet();
        Callable<String> c = () -> {return "null";};
        Callback<String, String> cb = s -> s + "res";

    }

}
