import java.time.Clock;
import java.time.DateTimeException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.MonthDay;
import java.time.OffsetDateTime;
import java.time.Period;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;

/**
 * Java 8 时间工具
 */
public class Java8Time
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		// 1.在Java 8中获取当天的日期
		LocalDate today = LocalDate.now();
		System.out.println("Today's Local date : " + today);

		// 2.在Java 8中获取当前的年月日
		int year = today.getYear();
		int month = today.getMonthValue();
		int day = today.getDayOfMonth();
		System.out.printf("Year : %d Month : %d day : %d \t %n", year, month,
				day);

		// 3.Java 8中如何获取某个特定的日期
		LocalDate dateOfBirth = LocalDate.of(2010, 01, 14);
		System.out.println("Your Date of birth is : " + dateOfBirth);

		// 示例4 在Java 8中如何检查两个日期是否相等
		LocalDate date1 = LocalDate.of(2016, 11, 07);
		if (date1.equals(today))
		{
			System.out.printf("Today %s and date1 %s are same date %n", today,
					date1);
		}

		// 示例5 在Java 8中如何检查重复事件，LocalDate dateOfBirth = LocalDate.of(2010, 01,
		// 14);
		MonthDay birthday = MonthDay.of(dateOfBirth.getMonth(),
				dateOfBirth.getDayOfMonth());
		MonthDay currentMonthDay = MonthDay.from(today);
		if (currentMonthDay.equals(birthday))
		{
			System.out.println("Many Many happy returns of the day !!");
		}
		else
		{
			System.out.println("Sorry, today is not your birthday");
		}

		// 示例6 如何在Java 8中获取当前时间
		LocalTime time = LocalTime.now();
		System.out.println("local time now : " + time);

		// 示例7 如何增加时间里面的小时数
		LocalTime newTime = time.plusHours(2); // adding two hours
		System.out.println("Time after 2 hours : " + newTime);

		// 示例8 如何获取1周后的日期
		LocalDate nextWeek = today.plus(1, ChronoUnit.WEEKS);
		System.out.println("Today is : " + today);
		System.out.println("Date after 1 week : " + nextWeek);

		// 示例9 一年前后的日期
		LocalDate previousYear = today.minus(1, ChronoUnit.YEARS);
		System.out.println("Date before 1 year : " + previousYear);
		LocalDate nextYear = today.plus(1, ChronoUnit.YEARS);
		System.out.println("Date after 1 year : " + nextYear);

		// 示例10 在Java 8中使用时钟
		// Java8中自带了一个Clock类，你可以用它来获取某个时区下当前的瞬时时间，日期或者时间。可以用Clock来替代System.currentTimeInMillis()与
		// TimeZone.getDefault()方法。
		// Returns the current time based on your system clock and set to UTC.
		Clock clock = Clock.systemUTC();
		System.out.println("Clock : " + clock);

		// Returns time based on system clock zone Clock defaultClock =
		Clock.systemDefaultZone();
		System.out.println("Clock : " + clock);

		// 示例11 在Java中如何判断某个日期是在另一个日期的前面还是后面
		LocalDate tomorrow = LocalDate.of(2016, 11, 8);
		if (tomorrow.isAfter(today))
		{
			System.out.println("Tomorrow comes after today");
		}
		LocalDate yesterday = today.minus(1, ChronoUnit.DAYS);
		if (yesterday.isBefore(today))
		{
			System.out.println("Yesterday is day before today");
		}

		// 示例12 在Java 8中处理不同的时区
		LocalDateTime localtDateAndTime = LocalDateTime.now();
		ZonedDateTime dateAndTimeInNewYork = ZonedDateTime.of(localtDateAndTime,
				ZoneId.of("America/New_York"));
		System.out.println("Current date and time in a particular timezone : "
				+ dateAndTimeInNewYork);

		// 示例13 如何表示固定的日期，比如信用卡过期时间
		YearMonth currentYearMonth = YearMonth.now();
		System.out.printf("Days in month year %s: %d%n", currentYearMonth,
				currentYearMonth.lengthOfMonth());
		YearMonth creditCardExpiry = YearMonth.of(2018, Month.FEBRUARY);
		System.out.printf("Your credit card expires on %s %n",
				creditCardExpiry);

		// 示例14 如何在Java 8中检查闰年
		if (today.isLeapYear())
		{
			System.out.println("This year is Leap year");
		}
		else
		{
			System.out.println("2014 is not a Leap year");
		}

		// 示例15 两个日期之间包含多少天，多少个月
		LocalDate java8Release = LocalDate.of(2014, Month.MARCH, 14);
		Period periodToNextJavaRelease = Period.between(today, java8Release);
		System.out.println("Months left between today and Java 8 release : "
				+ periodToNextJavaRelease.getMonths());

		// 示例16 带时区偏移量的日期与时间
		LocalDateTime datetime = LocalDateTime.of(2014, Month.JANUARY, 14, 19,
				30);
		ZoneOffset offset = ZoneOffset.of("+05:30");
		OffsetDateTime date = OffsetDateTime.of(datetime, offset);
		System.out.println(
				"Date and Time with timezone offset in Java : " + date);

		// 示例17 在Java 8中如何获取当前时间戳
		Instant timestamp = Instant.now();
		System.out.println("What is value of this instant " + timestamp);

		// 示例18 如何在Java 8中使用预定义的格式器来对日期进行解析/格式化
		String dayAfterTommorrow = "20140116";
		LocalDate formatted = LocalDate.parse(dayAfterTommorrow,
				DateTimeFormatter.BASIC_ISO_DATE);
		System.out.printf("Date generated from String %s is %s %n",
				dayAfterTommorrow, formatted);

		// 示例19 如何在Java中使用自定义的格式器来解析日期
		String goodFriday = "十一月 18 2014";
		try
		{
			DateTimeFormatter formatter = DateTimeFormatter
					.ofPattern("MMM dd yyyy");
			LocalDate holiday = LocalDate.parse(goodFriday, formatter);
			System.out.printf("Successfully parsed String %s, date is %s%n",
					goodFriday, holiday);
		}
		catch (DateTimeParseException ex)
		{
			System.out.printf("%s is not parsable!%n", goodFriday);
			ex.printStackTrace();
		}

		// 示例20 如何在Java 8中对日期进行格式化，转换成字符串
		LocalDateTime arrivalDate = LocalDateTime.now();
		try
		{
			DateTimeFormatter format = DateTimeFormatter
					.ofPattern("MMM dd yyyy hh:mm a");
			String landing = arrivalDate.format(format);
			System.out.printf("Arriving at : %s %n", landing);
		}
		catch (DateTimeException ex)
		{
			System.out.printf("%s can't be formatted!%n", arrivalDate);
			ex.printStackTrace();
		}

		//
	}

}
