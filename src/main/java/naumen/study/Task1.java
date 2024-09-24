package naumen.study;

import java.util.Arrays;
import java.util.Random;

public class Task1 {
    public void maxAbsElement(int n) {
        Random random = new Random();
        int[] arrayOfNumber = new int[n];
        int absMax = 0;
        for (int i = 0; i < arrayOfNumber.length; i++) {
            arrayOfNumber[i] = random.nextInt(-1000, 1000);
            if (Math.abs(arrayOfNumber[i]) > absMax) {
                absMax = Math.abs(arrayOfNumber[i]);
            }
        }
        System.out.println(Arrays.toString(arrayOfNumber));
        System.out.println("Максимальный элемент по модулю: " + absMax);
    }
}
