package naumen.study;

import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("Петрушина Надежда. 1 вариант :)");

        System.out.print("Введите n: ");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        System.out.println("\nTask 1: ");
        Task1 task1 = new Task1();
        task1.maxAbsElement(n);

        System.out.println("\nTask 2: ");
        Task2 task2 = new Task2();
        task2.mergeSort(n);

        System.out.println("\nTask 3: ");
        Task3 task3 = new Task3();
        task3.ageMore30();

        System.out.println("\nTask 4: ");
        Task4 task4 = new Task4();
        task4.getIdHttp();

        System.out.println("\nTask 5: ");
        System.out.print("Введите к-во секунд: ");
        int sec = scanner.nextInt();
        System.out.println("Таймер остановится через 5 секунд");
        Task5 task5 = new Task5(sec);
        task5.start();
        Thread.sleep(5000);
        task5.stop();

    }
}