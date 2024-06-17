import model.Clock;
import model.CountdownClock;
import model.DigitalClock;
import model.TimelapseClock;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DigitalClock clock1 = new DigitalClock(1, 1 ,40 ,23, 11);

        CountdownClock clock2 = new CountdownClock(2, 0, 1, 4);

        TimelapseClock clock3 = new TimelapseClock(5,0,0,0);

        String option;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Choose the clock to run");
            System.out.println("1. Digital clock");
            System.out.println("2. Count down clock");
            System.out.println("3. Timelapse clock");
            System.out.println("0. Stop the clock");

            option = scanner.nextLine();

            switch (option) {
                case "1":
                    clock1.run();
                    break;
                case "2":
                    clock2.run();
                    break;
                case "3":
                    clock3.run();
                    break;
                default:
                    System.out.println("Case is invalid!");
                    break;
            }

        } while (true);

    }
}