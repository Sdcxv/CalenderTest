import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * @author Sdcxv
 * @version 1.0 2015/8/10
 */
class CalendarTest {
    public static void main(String[] args) {
        Locale.setDefault(Locale.CHINA);

        //构造 d 作为当前日期
        GregorianCalendar d = new GregorianCalendar();

        int today = d.get(Calendar.DAY_OF_MONTH);
        int month = d.get(Calendar.MONTH);

        //设置该月的起始日期
        d.set(Calendar.DAY_OF_MONTH, 1);

        int weekday = d.get(Calendar.DAY_OF_WEEK);

        //设置每周的第一天为周一
        d.setFirstDayOfWeek(Calendar.MONDAY);

        //获取每周的第一天
        int firstDayOfWeek = d.getFirstDayOfWeek();

        //决定第二行的缩进
        int indent = 0;
        while (weekday != firstDayOfWeek) {
            indent++;
            d.add(Calendar.DAY_OF_MONTH, -1);
            weekday = d.get(Calendar.DAY_OF_WEEK);
        }

        //输出第一行
        String[] weekdayNames = new DateFormatSymbols().getShortWeekdays();
        do {
            System.out.printf("%4s", weekdayNames[weekday]);
            d.add(Calendar.DAY_OF_WEEK, 1);
            weekday = d.get(Calendar.DAY_OF_WEEK);
        } while (weekday != firstDayOfWeek);
        System.out.println();
        for (int i = 0; i < indent; i++) {
            System.out.print("       ");
        }
        d.set(Calendar.DAY_OF_MONTH, 1);
        do {
            //输出日期
            int day = d.get(Calendar.DAY_OF_MONTH);
            System.out.printf("%6d", day);

            //标记当前日期
            if (day == today) System.out.print("*");
            else System.out.print(" ");

            //把 d 赋值为下一天
            d.add(Calendar.DAY_OF_MONTH, 1);
            weekday = d.get(Calendar.DAY_OF_WEEK);

            //在新的一周开始时换行
            if (weekday == firstDayOfWeek) System.out.println();
        } while (d.get(Calendar.MONTH) == month);
        //如果 d 是下个月的第一天的时候退出循环

        //如果需要，打印最后一个换行
        if (weekday != firstDayOfWeek) System.out.println();
    }
}
