package patterns.creational.singleton;

public class SingletonNaiveMain {

    /*  Run it a few times, and you'll see a similar output, as below:
        Thread-0: Thread-0 -> Hash code: 993214606
        Thread-2: Thread-3 -> Hash code: 925483397
        Thread-3: Thread-3 -> Hash code: 925483397
        Thread-6: Thread-3 -> Hash code: 925483397
     */
    public static void main(String[] args) {
        Runnable task = () -> {
            SingletonNaive singleton = SingletonNaive.getInstance(Thread.currentThread().getName());
            System.out.println(STR."\{Thread.currentThread().getName()}: \{singleton.getData()} -> Hash code: \{singleton.hashCode()}");
        };

        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(task, STR."Thread-\{i}");
            threads[i].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}