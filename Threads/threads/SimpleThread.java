package threads;
public class SimpleThread extends Thread {
    public SimpleThread(String name) {
        super(name); 
    }
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i + " " + getName());
            try {
                sleep((long)(Math.random() * 1000));
            } catch (InterruptedException e) {}
        }
        System.out.println("DONE! " + getName());
    }
public static void main (String[] args) {
  new SimpleThread("Torino").start();
  new SimpleThread("Milano").start();
}}

