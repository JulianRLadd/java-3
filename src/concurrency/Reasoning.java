import java.awt.desktop.UserSessionEvent;

class Reasoning extends Thread{
    //set up this class so it can become a valid thread.
    public Reasoning(){

    }

    public void run(){
        distinguish();
    }

    public void distinguish() {
        //print to the console the difference between a thread and a process
        System.out.println("A thread is a segment of a process. They are more lightweight and usually run faster.");
        System.out.println("A process is any program in execution. It contains information about the process and usually doesn't share memory with any other process.");

        //print out you think will happen if you invoke the run() method of a thread as opposed to the start() method of a thread.
        System.out.println("It would run like a normal method, but we wouldn't be able to use multithreading. Plus, run() is a part of start");
    }
}

