package model;

public abstract class Clock {

    private int id;
    private int hour;
    private int minute;
    private int second;

    public Clock() {
        this.hour = 0;
        this.minute = 0;
        this.second = 0;
    }

    public Clock(int id, int hour, int minute, int second) {
        this.id = id;
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        if(hour >= 0 && hour < 24) {
            this.hour = hour;
        } else {
            this.hour = 0;
        }

    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        if(minute >= 0 && minute < 60) {
            this.minute = minute;
        } else {
            this.minute = 0;
        }
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        if(second >=0 && second < 60) {
            this.second = second;
        } else {
            this.second = 0;
        }
    }

    public void increaseSecond() {
        this.setSecond(this.second + 1);
        if (this.second == 0) {
            increaseMinutes();
        }
    }

    public void increaseMinutes() {
        this.setMinute(this.minute + 1);
        if (this.minute == 0) {
            increaseHour();
        }
    }

    public void increaseHour() {
        this.setHour(this.hour + 1);
    }

    public void decreaseSecond() {
        if(this.second > 0 && this.second < 60) {
            this.setSecond(this.second - 1);
        } else if(this.second == 0) {
            decreaseMinute();
            this.setSecond(this.second = 59);
        }
    }

    public void decreaseMinute() {
        if(this.minute > 0 && minute < 60) {
            this.setMinute(this.minute - 1);
        } else if(this.second == 0 && this.minute == 0) {
            decreaseHour();
            this.setMinute(this.minute = 59);
        }
    }

    public void decreaseHour() {
        this.setHour(this.hour - 1);
    }

    @Override
    public String toString() {
        String time = "";
        time += hour;
        time += ":";
        if (minute < 10) {
            time += "0";
        } else {
            time += "";
        }
        time += minute + ":";
        if (second < 10) {
            time += "0";
        } else {
            time += "";
        }
        time += second;
        return time;
    }


    public abstract void run();
}
