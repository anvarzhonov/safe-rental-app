package ru.anvarzhonov.sbrf.map.task;

import java.util.Scanner;

public class DataCenter {
    private int n; // число дата-центров
    private int m; // число серверов в каждом дата-центре
    private int[][] state; // массив состояний серверов в дата-центрах (0 - сервер еще включен)
    private int[] resets; // массив числа перезапусков дата-центров
    private int[] active; // массив числа рабочих серверов в дата-центрах

    public DataCenter(int n, int m) {
        this.n = n;
        this.m = m;
        state = new int[n][m];
        resets = new int[n];
        active = new int[n];
    }

    public void reset(int i) {
        resets[i-1]++;
        active[i-1] = m; // вовзращаем в исходное состояние число рабочих серверов
    }

    public void disable(int i, int j) {
        if (state[i-1][j-1] == 0) { // проверяем, что сервер еще не выключен
            state[i-1][j-1] = 1;
            active[i-1]--;
        }
    }

    public int getMax() {
        int maxProduct = 0;
        int maxIndex = 0;
        for (int i = 0; i < n; i++) {
            int product = resets[i] * active[i];

            if (product != 0 && product >= maxProduct) {
                maxProduct = product;
                maxIndex = i + 1;
            }
        }
        if (maxIndex == 0) {
            return 1;
        }
        return maxIndex;
    }

    public int getMin() {
        int minProduct = Integer.MAX_VALUE;
        int minIndex = 0;
        for (int i = 0; i < n; i++) {
            int product = resets[i] * active[i];
            if (product < minProduct) {
                minProduct = product;
                minIndex = i + 1;
            }
        }
        return minIndex;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int q = scanner.nextInt();

        var dataCenter = new DataCenter(n, m);

        for (int i = 0; i < q; i++) {
            var command = scanner.next();
            switch (command) {
                case "RESET" -> {
                    int index = scanner.nextInt();
                    dataCenter.reset(index);
                }
                case "DISABLE" -> {
                    int index1 = scanner.nextInt();
                    int index2 = scanner.nextInt();
                    dataCenter.disable(index1, index2);
                }
                case "GETMAX" -> {
                    System.out.println(dataCenter.getMax());
                }
                case "GETMIN" -> {
                    System.out.println(dataCenter.getMin());
                }
                default -> throw new IllegalArgumentException();
            }
        }
    }
}
