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

        //���� d ��Ϊ��ǰ����
        GregorianCalendar d = new GregorianCalendar();

        int today = d.get(Calendar.DAY_OF_MONTH);
        int month = d.get(Calendar.MONTH);

        //���ø��µ���ʼ����
        d.set(Calendar.DAY_OF_MONTH, 1);

        int weekday = d.get(Calendar.DAY_OF_WEEK);

        //����ÿ�ܵĵ�һ��Ϊ��һ
        d.setFirstDayOfWeek(Calendar.MONDAY);

        //��ȡÿ�ܵĵ�һ��
        int firstDayOfWeek = d.getFirstDayOfWeek();

        //�����ڶ��е�����
        int indent = 0;
        while (weekday != firstDayOfWeek) {
            indent++;
            d.add(Calendar.DAY_OF_MONTH, -1);
            weekday = d.get(Calendar.DAY_OF_WEEK);
        }

        //�����һ��
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
            //�������
            int day = d.get(Calendar.DAY_OF_MONTH);
            System.out.printf("%6d", day);

            //��ǵ�ǰ����
            if (day == today) System.out.print("*");
            else System.out.print(" ");

            //�� d ��ֵΪ��һ��
            d.add(Calendar.DAY_OF_MONTH, 1);
            weekday = d.get(Calendar.DAY_OF_WEEK);

            //���µ�һ�ܿ�ʼʱ����
            if (weekday == firstDayOfWeek) System.out.println();
        } while (d.get(Calendar.MONTH) == month);
        //��� d ���¸��µĵ�һ���ʱ���˳�ѭ��

        //�����Ҫ����ӡ���һ������
        if (weekday != firstDayOfWeek) System.out.println();
    }
}
