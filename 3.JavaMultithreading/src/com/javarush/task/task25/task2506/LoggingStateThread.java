package com.javarush.task.task25.task2506;

public class LoggingStateThread extends Thread {
    private Thread observedThread;

    public LoggingStateThread(Thread thread) {
        observedThread = thread;
        setDaemon(true);
    }

    @Override
    public void run() {
        super.run();

        State oldState = observedThread.getState();
        System.out.println(oldState);

        while(oldState != State.TERMINATED)
            if (oldState != observedThread.getState()) {
                System.out.println(observedThread.getState());
                oldState = observedThread.getState();
            }
    }
}
