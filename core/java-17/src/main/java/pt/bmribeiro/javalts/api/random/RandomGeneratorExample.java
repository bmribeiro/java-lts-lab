
package pt.bmribeiro.javalts.api.random;

import java.util.List;
import java.util.random.RandomGenerator;
import java.util.random.RandomGeneratorFactory;

/**
 * RandomGenerator API
 *
 * Introduced: Java 17
 * Finalized: Java 17
 * Target Version: Java 17
 * Category: Random Number Generation API
 */
public class RandomGeneratorExample {

    public int generateInteger(int origin, int bound) {
        RandomGenerator generator = RandomGenerator.getDefault();

        return generator.nextInt(origin, bound);
    }

    public double generateDouble() {
        RandomGenerator generator = RandomGenerator.getDefault();

        return generator.nextDouble();
    }

    public int[] generateIntegers(int size, int origin, int bound) {
        RandomGenerator generator = RandomGenerator.getDefault();

        return generator.ints(size, origin, bound).toArray();
    }

    public List<String> getAvailableAlgorithms() {
        return RandomGeneratorFactory.all()
            .map(RandomGeneratorFactory::name)
            .sorted()
            .toList();
    }

    public int generateWithAlgorithm(String algorithm, int origin, int bound) {
        RandomGenerator generator =
            RandomGeneratorFactory.of(algorithm).create();

        return generator.nextInt(origin, bound);
    }
}
