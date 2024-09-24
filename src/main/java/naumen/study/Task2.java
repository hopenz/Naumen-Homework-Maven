package naumen.study;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Task2 {
    public void mergeSort(int n) {
        Random random = new Random();
        ArrayList<Double> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(random.nextDouble(-1000, 1000));
        }
        System.out.println("Исходный список: " + list);

        mergeSortRec(list);
        System.out.println("Отсортированный список: " + list);
    }

    public static void mergeSortRec(ArrayList<Double> list) {
        if (list.size() <= 1) {
            return;
        }

        int mid = list.size() / 2;
        ArrayList<Double> left = new ArrayList<>(list.subList(0, mid));
        ArrayList<Double> right = new ArrayList<>(list.subList(mid, list.size()));

        mergeSortRec(left);
        mergeSortRec(right);

        merge(list, left, right);
    }

    private static void merge(ArrayList<Double> list, ArrayList<Double> left, ArrayList<Double> right) {
        int i = 0, j = 0, k = 0;

        while (i < left.size() && j < right.size()) {
            if (left.get(i) <= right.get(j)) {
                list.set(k, left.get(i));
                i++;
            } else {
                list.set(k, right.get(j));
                j++;
            }
            k++;
        }

        while (i < left.size()) {
            list.set(k, left.get(i));
            i++;
            k++;
        }

        while (j < right.size()) {
            list.set(k, right.get(j));
            j++;
            k++;
        }
    }

}
