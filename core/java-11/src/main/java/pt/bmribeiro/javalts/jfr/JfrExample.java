package pt.bmribeiro.javalts.jfr;

import java.util.ArrayList;
import java.util.List;

public class JfrExample {

    public static void main(String[] args) throws InterruptedException {
        List<byte[]> allocations = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            allocations.add(new byte[1024 * 1024]);

            System.out.println("Allocated: " + (i + 1) + " MB");

            Thread.sleep(100);
        }

        System.out.println("JFR example completed.");
    }
}
