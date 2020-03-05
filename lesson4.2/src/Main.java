public class Main {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        for (int i = 1; i <= 200; i++) {
            CounterThread ct =
                    new CounterThread(counter, i + "");
            ct.start();
        }
        Thread.sleep(500);

        System.out.println("Counter:"
                + counter.getCounter());    //199977
                                            //199511
    }
}

class Counter {
    private long counter = 0L;

    public void increaseCounter() {
        counter++;
    }

    public long getCounter() {
        return counter;
    }
}

class CounterThread extends Thread {
    private Counter counter;

    public CounterThread(Counter counter, String name) {
        super(name);
        //this.setName(name);
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 500; i++) {
            counter.increaseCounter();
            counter.increaseCounter();
        }
        System.out.println(this.getName());
    }
}