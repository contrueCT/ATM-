package base;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class caogao {
    public static void main(String[] args) {
        Date d = new Date();
        System.out.println(d);

        long time = d.getTime();
        System.out.println(time);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss EEE a");
        System.out.println(sdf.format(d));

        String rs = sdf.format(d);
        String rs2 = sdf.format(time);
        System.out.println(rs);
        System.out.println(rs2);
        
    }
}
