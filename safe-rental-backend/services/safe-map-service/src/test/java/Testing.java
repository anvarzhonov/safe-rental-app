import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Testing {

    @Test
    void tijme1() {
        var time = (int) ZonedDateTime.now().toInstant().toEpochMilli();
        long l = LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
        long time1 = new Date().getTime();
        System.out.println(time);
        System.out.println(l);
        System.out.println(time1);
    }
    @Test
    void test1() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd:MM:uuuu HH:mm:ss");

//        LocalDate now = LocalDate.now().format();
        Date now = new Date();
        var now1 = LocalDateTime.now();

        var dateTime = LocalDateTime.ofInstant(now.toInstant(), ZoneId.systemDefault()).format(dateTimeFormatter);


        Date from = Date.from(now1.atZone(ZoneId.systemDefault()).toInstant());
//        System.out.println(dateTime);
        System.out.println(from);


    }

    @Test
    void testt(){
        String pattern = "yyyy.MM.dd HH:mm:ss";
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(pattern);
        String formattedDateTime = localDateTime.format(dateTimeFormatter);
        Date date = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
        System.out.println("Formatted LocalDateTime: " + formattedDateTime);
        String sdf = new SimpleDateFormat(pattern).format(date);

        System.out.println("Date from LocalDateTime: " + sdf);
    }
    @Test
    void test() {
        String [] a = {"a", "b"};
        String [] b = {"a", "b"};

        List<String> c = new LinkedList<>();
        List<String> d = new ArrayList<>();
        c.add("c");
        d.add("c");

        System.out.println(a.equals(b));
        System.out.println(c.equals(d));
        System.out.println(a == b);
        System.out.println(c.equals(d));
    }
}
