package model;

import java.util.Scanner;

public class CountdownClock extends Clock {
    public CountdownClock(int id, int hour, int minute, int second) {
        super(id, hour, minute, second);
    }

    @Override
    public void run() {
        boolean flag = true;
        while (flag) {
            System.out.println(this);
            try {
                if (this.getHour() == 0 && this.getMinute() == 0 && this.getSecond() == 0) {
                    System.out.println("The count down clock with the ID: " + this.getId() + " is stop!");
                    return;
                } else {
                    Thread.sleep(1000);
                    this.decreaseSecond();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String toString() {
        return String.format("Count down clock: {" + super.toString()+ "}");
    }
}
