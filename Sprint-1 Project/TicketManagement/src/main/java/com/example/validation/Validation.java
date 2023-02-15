package com.example.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.example.entity.Ticket;
import com.example.exception.InvalidTicketException;

//validation class
public class Validation {
	public static final String PHONE_REGEX = "^[0-9]{10}$";
	public static final String DATE_REGEX = "^\\d{4}-\\d{2}-\\d{2}$"; /*
																		 * This regular expression matches a string that
																		 * represents a date in the format of
																		 * "YYYY-MM-DD", where:
																		 * 
																		 * ^ and $ denote the beginning and end of the
																		 * string, respectively. \d represents any
																		 * digit. {4} indicates that the preceding
																		 * pattern (i.e., \d) must be repeated exactly
																		 * four times. represents the literal character
																		 * "-". {2} indicates that the preceding pattern
																		 * (i.e., \d) must be repeated exactly two
																		 * times.
																		 * 
																		 * Therefore, this regex matches strings that
																		 * represent a valid date in the format of
																		 * "YYYY-MM-DD", where YYYY is a four-digit
																		 * year, MM is a two-digit month (with a leading
																		 * zero, if necessary), and DD is a two-digit
																		 * day (with a leading zero, if necessary).
																		 * Examples of valid matches include
																		 * "2022-03-01", "1999-12-31", and "2023-02-15".
																		 */

	public static void validateTicket(Ticket ticket) throws InvalidTicketException {
		if (!isValidField(String.valueOf(ticket.getPhone()), PHONE_REGEX)) {
			throw new InvalidTicketException("Invalid phone number");
		}

		if (!isValidField(ticket.getBooking_date(), DATE_REGEX)) {
			throw new InvalidTicketException("Invalid booking date");
		}

		if (isFieldTooLong(ticket.getName()) || isFieldTooLong(ticket.getState()) || isFieldTooLong(ticket.getTrain())
				|| isFieldTooLong(ticket.getS_point()) || isFieldTooLong(ticket.getE_point())) {
			throw new InvalidTicketException("Some fields are too long (maximum length: 20)");
		}
	}

	private static boolean isValidField(String field, String regex) {
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(field);
		return matcher.matches();
	}

	private static boolean isFieldTooLong(String field) {
		return field != null && field.length() > 20;
	}
}