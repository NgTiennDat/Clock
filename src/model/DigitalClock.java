package model;

import java.util.Scanner;

public class DigitalClock extends Clock {
    private int GMT;

    public DigitalClock(int id, int hour, int minute, int second, int GMT) {
        super(id, hour, minute, second);
        this.GMT = GMT;
    }

    public void setGMT(int GMT) {
        if(validGMT(GMT)) {
            this.GMT = GMT;
        } else {
            System.out.println("GMT is invalid!");
        }
    }

    public boolean validGMT(int GMT) {
        if(GMT <= 12 && GMT >= -12) {
            return  true;
        } else {
            return false;
        }
    }

    public int getGMT() {
        return GMT;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println(this);
            String stop;



            try {
                if(validGMT(this.GMT) && (this.getHour() + this.GMT < 24) && (this.getHour() + this.GMT >= 0)) {
                    Thread.sleep(1000);
                    this.increaseSecond();
                } else {
                    System.out.println("The GMT is invalid!");
                    return;
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String toString() {
        String time = "";
        if(this.GMT < 0 && this.GMT >= -12) {
            time += (getHour() - this.GMT);
        } else if(GMT <= 12 && GMT >= 0) {
            time += getHour() + GMT;
        } else {
            time = "Invalid";
        }
        time += ":";
        if (getMinute() < 10) {
            time += "0";
        } else {
            time += "";
        }
        time += getMinute() + ":";
        if (getSecond() < 10) {
            time += "0";
        } else {
            time += "";
        }
        time += getSecond();

        return time;
    }
}
