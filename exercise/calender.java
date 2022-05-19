package exercise;

import java.util.Calendar;

public class calender {

  public static void main(String[] args) {
    int thisYear = Calendar.getInstance().get(Calendar.YEAR);
    for (int month = 1; month <= 12; month++) {
      System.out.println(thisYear + "年" + month + "月");
      String[] weeks = { "Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat" };
      for (String s : weeks) {
        System.out.printf("%4s", s);
      }
      System.out.println();
      new SampleCalendar(thisYear, month);
    }
  }
}

class SampleCalendar {
  private int year;
  private int month;
  private int firstDay;
  private int lastDay;

  SampleCalendar(int year, int month) {
    this.year = year;
    this.month = month;
    calc();
  }

  private void calc() {
    Calendar calendar = Calendar.getInstance();
    calendar.clear();
    calendar.set(year, month - 1, 1);
    firstDay = calendar.get(Calendar.DAY_OF_WEEK);
    int day = 1 - (firstDay - 1) % 7;
    calendar.add(Calendar.MONTH, 1);
    calendar.add(Calendar.DATE, -1);
    lastDay = calendar.get(Calendar.DATE);

    while (day <= lastDay) {
      for (int ii = 0; ii < 7 && day <= lastDay; ii++) {
        System.out.printf(day < 1 ? "    " : "%4d", day);
        day++;
      }
      System.out.println();
    }
    System.out.println();
  }
}
