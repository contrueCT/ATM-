package base;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class caogao {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new MyThread());
        Thread t2 = new Thread(new MyThread());
        t1.start();
        t2.start();

        System.out.println(t1.getName());
        System.out.println(t2.getName());
        Thread m = Thread.currentThread();
        System.out.println(m.getName());
        for(int i = 0;i<6;i++){
            System.out.println("main: "+i);
        }
    }
}
