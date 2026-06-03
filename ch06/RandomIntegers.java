package ch06;

import java.security.SecureRandom;

/**
 * Random-number generation case study (SecureRandom).
 *
 * Konu: API sınıfı kullanma, döngü, frekans sayma.
 */
public class RandomIntegers {
    public static void main(String[] args) {
        SecureRandom random = new SecureRandom();

        int[] frequency = new int[7]; // 1..6 için kullanacağız

        for (int roll = 1; roll <= 20; roll++) {
            int face = 1 + random.nextInt(6);
            frequency[face]++;
        }

        System.out.println("Face\tFrequency");
        for (int face = 1; face < frequency.length; face++) {
            System.out.printf("%d\t%d%n", face, frequency[face]);
        }
    }
}

