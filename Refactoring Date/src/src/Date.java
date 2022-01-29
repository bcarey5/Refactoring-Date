package src;

import java.util.Scanner;

public class Date {
	private String month;
	private int day;
	private int year; // a four digit number.

	public Date() {
		month = "January";
		day = 1;
		year = 1000;
	}

	public Date(int monthInt, int day, int year) {
		setDate(monthInt, day, year);
	}

	public Date(String monthString, int day, int year) {
		setDate(monthString, day, year);
	}

	public Date(int year) {
		setDate(1, 1, year);
	}

	public Date(Date aDate) {
		if (aDate == null)// Not a real date.
		{
			System.out.println("Fatal Error.");
			System.exit(0);
		}

		month = aDate.month;
		day = aDate.day;
		year = aDate.year;
	}

	public void setDate(int monthInt, int day, int year) {
		if (dateOK(monthInt, day, year)) {
			this.month = monthString(monthInt);
			this.day = day;
			this.year = year;
		} else {
			System.out.println("Fatal Error");
			System.exit(0);
		}
	}

	public void setDate(String monthString, int day, int year) {
		if (dateOK(monthString, day, year)) {
			this.month = monthString;
			this.day = day;
			this.year = year;
		} else {
			System.out.println("Fatal Error");
			System.exit(0);
		}
	}

	public void setDate(int year) {
		setDate(1, 1, year);
	}

	public void setYear(int year) {
		if ((year < 1000) || (year > 9999)) {
			System.out.println("Fatal Error");
			System.exit(0);
		} else
			this.year = year;
	}

	public void setMonth(int monthNumber) {
		if ((monthNumber <= 0) || (monthNumber > 12)) {
			System.out.println("Fatal Error");
			System.exit(0);
		} else
			month = monthString(monthNumber);
	}

	public void setDay(int day) {
		if ((day <= 0) || (day > 31)) {
			System.out.println("Fatal Error");
			System.exit(0);
		} else
			this.day = day;
	}

	public int getMonth() {
//		if (month.equals("January"))
//			return 1;
//		else if (month.equals("February"))
//			return 2;
//		else if (month.equalsIgnoreCase("March"))
//			return 3;
//		else if (month.equalsIgnoreCase("April"))
//			return 4;
//		else if (month.equalsIgnoreCase("May"))
//			return 5;
//		else if (month.equals("June"))
//			return 6;
//		else if (month.equalsIgnoreCase("July"))
//			return 7;
//		else if (month.equalsIgnoreCase("August"))
//			return 8;
//		else if (month.equalsIgnoreCase("September"))
//			return 9;
//		else if (month.equalsIgnoreCase("October"))
//			return 10;
//		else if (month.equals("November"))
//			return 11;
//		else if (month.equals("December"))
//			return 12;
//		else {
//			System.out.println("Fatal Error");
//			System.exit(0);
//			return 0; // Needed to keep the compiler happy
//		}
		int returnValue;
		switch (month) {
		case "January" -> returnValue = 1;
		case "February" -> returnValue = 2;
		case "March" -> returnValue = 3;
		case "April" -> returnValue = 4;
		case "May" -> returnValue = 5;
		case "June" -> returnValue = 6;
		case "July" -> returnValue = 7;
		case "August" -> returnValue = 8;
		case "September" -> returnValue = 9;
		case "October" -> returnValue = 10;
		case "November" -> returnValue = 11;
		case "December" -> returnValue = 12;
		default -> {
			System.out.println("Fatal Error");
			System.exit(0);
			return 0; // Needed to keep the compiler happy
		}
		}
		return returnValue;
	}

	public int getDay() {
		return day;
	}

	public int getYear() {
		return year;
	}

	public String toString() {
		return (month + " " + day + ", " + year);
	}

	public boolean equals(Date otherDate) {
		return ((month.equals(otherDate.month)) && (day == otherDate.day) && (year == otherDate.year));
	}

	public boolean precedes(Date otherDate) {
		return ((year < otherDate.year) || (year == otherDate.year && getMonth() < otherDate.getMonth())
				|| (year == otherDate.year && month.equals(otherDate.month) && day < otherDate.day));
	}

	public void readInput() {
		boolean tryAgain = true;
		Scanner keyboard = new Scanner(System.in);
		while (tryAgain) {
			System.out.println("Enter month, day, and year.");
			System.out.println("Do not use a comma.");
			var monthInput = keyboard.next();
			var dayInput = keyboard.nextInt();
			var yearInput = keyboard.nextInt();
			if (dateOK(monthInput, dayInput, yearInput)) {
				setDate(monthInput, dayInput, yearInput);
				tryAgain = false;
			} else
				System.out.println("Illegal date. Reenter input.");
		}
	}

	private boolean dateOK(int monthInt, int dayInt, int yearInt) {
		return ((monthInt >= 1) && (monthInt <= 12) && (dayInt >= 1) && (dayInt <= 31) && (yearInt >= 1000)
				&& (yearInt <= 9999));
	}

	private boolean dateOK(String monthString, int dayInt, int yearInt) {
		return (monthOK(monthString) && (dayInt >= 1) && (dayInt <= 31) && (yearInt >= 1000) && (yearInt <= 9999));
	}

	private boolean monthOK(String month) {
//		return (month.equals("January") || month.equals("February") || month.equals("March") || month.equals("April")
//				|| month.equals("May") || month.equals("June") || month.equals("July") || month.equals("August")
//				|| month.equals("September") || month.equals("October") || month.equals("November")
//				|| month.equals("December"));
		boolean returnValue = false;
		switch (month) {
		case "January" -> returnValue = true;
		case "February" -> returnValue = true;
		case "March" -> returnValue = true;
		case "April" -> returnValue = true;
		case "May" -> returnValue = true;
		case "June" -> returnValue = true;
		case "July" -> returnValue = true;
		case "August" -> returnValue = true;
		case "September" -> returnValue = true;
		case "October" -> returnValue = true;
		case "November" -> returnValue = true;
		case "December" -> returnValue = true;
		}
		return returnValue;
	}

	private String monthString(int monthNumber) {
//		switch (monthNumber) {
//		case 1:
//			return "January";
//		case 2:
//			return "February";
//		case 3:
//			return "March";
//		case 4:
//			return "April";
//		case 5:
//			return "May";
//		case 6:
//			return "June";
//		case 7:
//			return "July";
//		case 8:
//			return "August";
//		case 9:
//			return "September";
//		case 10:
//			return "October";
//		case 11:
//			return "November";
//		case 12:
//			return "December";
//		default:
//			System.out.println("Fatal Error");
//			System.exit(0);
//			return "Error"; // to keep the compiler happy
//		}
		String returnValue;
		switch (monthNumber) {
		case 1 -> returnValue = "January";
		case 2 -> returnValue = "February";
		case 3 -> returnValue = "March";
		case 4 -> returnValue = "April";
		case 5 -> returnValue = "May";
		case 6 -> returnValue = "June";
		case 7 -> returnValue = "July";
		case 8 -> returnValue = "August";
		case 9 -> returnValue = "September";
		case 10 -> returnValue = "October";
		case 11 -> returnValue = "November";
		case 12 -> returnValue = "December";
		default -> {
			System.out.println("Fatal Error");
			System.exit(0);
			return "Error"; // Needed to keep the compiler happy
		}
		}
		return returnValue;
	}
}
