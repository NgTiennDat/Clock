package model;

public class TimelapseClock extends Clock {

    public TimelapseClock(int id, int hour, int minute, int second) {
        super(id, hour, minute, second);
    }

    @Override
    public void run() {
        while (true) {
            System.out.println(this);
            try {
                if(this.getHour() == 99 && this.getMinute() == 59 && this.getSecond() == 59) {
                    System.out.println("The timelapse clock with the ID: " + this.getId() + " is stop!");
                    return;
                } else {
                    Thread.sleep(1000);
                    this.increaseSecond();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String toString() {
        return String.format("Timelapse Clock: {" + super.toString()) + "}";
    }
}
