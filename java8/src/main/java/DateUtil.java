import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


/**
 * 日期函数
 * 
 * @author muma
 *
 */
public class DateUtil
{
	private static final Logger LOGGER = LoggerFactory.getLogger(DateUtil.class);

	public static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	public static SimpleDateFormat df = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");
	public static SimpleDateFormat df1 = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm");

	// 获取当前时间，不含秒
	public static String getDateMin()
	{
		Date day = new Date();
		return df1.format(day) + ":00";
	}

	/*
	 * 
	 * 获取当前时间之前或之后几分钟 minute
	 * 
	 */
	public static String getTimeByMinute(int minute)
	{
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MINUTE, minute);
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:00")
				.format(calendar.getTime());
	}

	/*
	 * 
	 * 获取当前时间之前或之后几分钟 minute
	 * 
	 */
	public static String getTimeByMinute(int minute, SimpleDateFormat sdf)
	{
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MINUTE, minute);
		return sdf.format(calendar.getTime());
	}

	// 获取时间戳
	public static String getTimestamp(String inDate)
	{
		String timeStamp = null;
		try
		{
			timeStamp = String.valueOf(df.parse(inDate).getTime() / 1000);
		}
		catch (ParseException e)
		{
			e.printStackTrace();
		}
		return timeStamp;
	}

	public static String getMonFrist()
	{
		// 获取前月的第一天
		Calendar cal_1 = Calendar.getInstance();// 获取当前日期
		cal_1.add(Calendar.MONTH, 0);
		cal_1.set(Calendar.DAY_OF_MONTH, 1);// 设置为1号,当前日期既为本月第一天
		String firstDay = format.format(cal_1.getTime());
		return firstDay;
	}

	public static String getDate()
	{
		Date day = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		return df.format(day);
	}

	public static String getDate(Date date)
	{
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		return df.format(date);
	}

	public static String getDateTime()
	{
		Date dateTime = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return df.format(dateTime);
	}

	/**
	 * 字符串转换成时间
	 * 
	 * @param dStr
	 *            时间字符串
	 * @param sdf
	 *            时间格式
	 * @return
	 */
	public static Date toDate(String dStr, SimpleDateFormat sdf)
	{
		Date date = null;
		try
		{
			date = sdf.parse(dStr);
		}
		catch (ParseException pe)
		{
			LOGGER.error(pe.getMessage());
		}
		return date;
	}

	public static String toDateStr(Date date, SimpleDateFormat sdf)
	{
		return sdf.format(date);
	}

	public static String toDateStr(long date, SimpleDateFormat sdf)
	{
		return sdf.format(new Date(date));
	}

	/**
	 * 转换时间格式
	 * 
	 * @param dStr
	 *            时间
	 * @param sdf
	 *            源格式
	 * @param tdf
	 *            目标格式
	 * @return
	 */
	public static String toDateStr(String dStr, SimpleDateFormat sdf,
			SimpleDateFormat tdf)
	{
		Date date = null;
		try
		{
			date = sdf.parse(dStr);
		}
		catch (ParseException pe)
		{
			LOGGER.error(pe.getMessage());
		}
		return tdf.format(date);
	}

	/**
	 * * 获取指定日期是星期几 参数为null时表示获取当前日期是星期几
	 * 
	 * @param date
	 * @return
	 */
	public static String getWeekOfDate(Date date)
	{
		String[] weekOfDays =
		{ "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };
		Calendar calendar = Calendar.getInstance();
		if (date != null)
		{
			calendar.setTime(date);
		}
		int w = calendar.get(Calendar.DAY_OF_WEEK) - 1;
		if (w < 0)
		{
			w = 0;
		}
		return weekOfDays[w];
	}

	/**
	 * 判断是否是节假日(周六和周日)
	 */
	public static boolean checkHoliday(Calendar calendar)
	{
		// 判断日期是否是周六周日
		if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY
				|| calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY)
		{
			return true;
		}
		return false;
	}

	/**
	 * 获取上周指定星期
	 */
	public static Calendar getLastWeek(Calendar cal, int week)
	{
		cal.add(Calendar.DAY_OF_MONTH, -1);// 解决周日会出现 并到下一周的情况
		if (week != Calendar.SUNDAY)
			cal.add(Calendar.WEEK_OF_YEAR, -1);// 减一周
		cal.set(Calendar.DAY_OF_WEEK, week);

		return cal;
	}

	/**
	 * 判断今天是否是当月的第一天
	 * 
	 * @param date
	 * @return
	 */
	public static Boolean isFirstDayOfMonth()
	{
		Calendar c = Calendar.getInstance();
		int today = c.get(Calendar.DAY_OF_MONTH);
		if (today == 1)
		{
			return true;
		}
		return false;
	}

	/**
	 * 获取当前系统前一天日期
	 * 
	 * @param date
	 * @return
	 */

	public static Date getBeforeDay(Date date)
	{
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		date = calendar.getTime();
		return date;
	}

}
