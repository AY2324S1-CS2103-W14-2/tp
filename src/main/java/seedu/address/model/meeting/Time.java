package seedu.address.model.meeting;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;

/**
 * Represents a Meeting's time in NoteNote.
 * Guarantees: immutable; is valid as declared in {@link #isValidTime(String)}
 */
public class Time {

    public static final String MESSAGE_CONSTRAINTS =
        "Time should match the exact format of dd/MM/yyyy HH:mm and be a valid datetime";

    public static final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern("dd/MM/uuuu HH:mm").withResolverStyle(ResolverStyle.STRICT);

    public final LocalDateTime value;

    /**
     * Constructs a {@code Time}.
     *
     * @param time A valid meeting time String.
     */
    public Time(String time) {
        requireNonNull(time);
        checkArgument(isValidTime(time), MESSAGE_CONSTRAINTS);
        value = LocalDateTime.parse(time, FORMATTER);
    }

    /**
     * Constructs a {@code Time}.
     *
     * @param time A valid meeting time LocalDateTime.
     */
    public Time(LocalDateTime time) {
        requireNonNull(time);
        value = time;
    }

    /**
     * Returns true if a given string is a valid time.
     */
    public static boolean isValidTime(String test) {
        try {
            LocalDateTime parsedDateTime = LocalDateTime.parse(test, FORMATTER);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    @Override
    public String toString() {
        return value.format(FORMATTER);
    }

    /**
     * Converts time String to a time LocalDateTime.
     *
     * @param timeStr A valid meeting time.
     */
    public static Time fromString(String timeStr) {
        LocalDateTime parsedDateTime = LocalDateTime.parse(timeStr, FORMATTER);
        return new Time(parsedDateTime);
    }

    public LocalDateTime getValue() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof Time)) {
            return false;
        }

        Time otherTime = (Time) other;
        return value.equals(otherTime.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
