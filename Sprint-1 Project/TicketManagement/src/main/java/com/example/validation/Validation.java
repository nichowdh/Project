package com.example.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.example.entity.Ticket;
import com.example.exception.InvalidTicketException;

public class Validation {
    public static final String PHONE_REGEX = "^[0-9]{10}$";
    public static final String DATE_REGEX = "^\\d{4}-\\d{2}-\\d{2}$";

    public static void validateTicket(Ticket ticket) throws InvalidTicketException {
        if (!isValidField(String.valueOf(ticket.getPhone()), PHONE_REGEX)) {
            throw new InvalidTicketException("Invalid phone number");
        }

        if (!isValidField(ticket.getBooking_date(), DATE_REGEX)) {
            throw new InvalidTicketException("Invalid booking date");
        }

        if (isFieldTooLong(ticket.getName()) || isFieldTooLong(ticket.getState())
                || isFieldTooLong(ticket.getTrain()) || isFieldTooLong(ticket.getS_point())
                || isFieldTooLong(ticket.getE_point())) {
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