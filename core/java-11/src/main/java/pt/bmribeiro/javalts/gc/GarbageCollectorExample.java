package pt.bmribeiro.javalts.gc;

import java.lang.management.ManagementFactory;
import java.util.ArrayList;
import java.util.List;

public class GarbageCollectorExample {

    private static final int ALLOCATION_SIZE = 1024 * 1024;
    private static final int ITERATIONS = 200;
    private static final int BATCH_SIZE = 10;

    public static void main(String[] args) {

        System.out.println("Java version: "
            + System.getProperty("java.version"));

        System.out.println("Garbage Collectors:");

        ManagementFactory.getGarbageCollectorMXBeans()
            .forEach(gc -> System.out.println(
                "- " + gc.getName()
            ));

        System.out.println("\nStarting allocation workload...");

        List<byte[]> allocations = new ArrayList<>();

        for (int i = 1; i <= ITERATIONS; i++) {

            byte[] allocation = new byte[ALLOCATION_SIZE];

            allocation[0] = (byte) i;

            allocations.add(allocation);

            if (allocations.size() == BATCH_SIZE) {

                System.out.println(
                    "Allocated batch: " + i / BATCH_SIZE
                );

                allocations.clear();
            }
        }

        System.out.println("\nAllocation workload completed.");
    }
}
