package lw01.unguided;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(Main.class.getResourceAsStream("washes.txt"));

        int count = scanner.nextInt();
        Washservice[] washes = new Washservice[count];
        int[] unitsList = new int[count];

        for (int i = 0; i < count; i++) {
            String type = scanner.next();
            String id = scanner.next();
            int days = scanner.nextInt();
            int units = scanner.nextInt();

            unitsList[i] = units;

            if (type.equalsIgnoreCase("MOTORCYCLE")) {
                washes[i] = new Motorcyclewash(id, days);
            } else if (type.equalsIgnoreCase("CAR")) {
                washes[i] = new Carwash(id, days);
            }
        }

        scanner.close();

        for (int i = 0; i < washes.length; i++) {
            System.out.println(washes[i].summary(unitsList[i]));
        }
    }
}