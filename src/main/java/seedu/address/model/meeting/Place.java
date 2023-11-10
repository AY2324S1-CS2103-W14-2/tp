package seedu.address.model.meeting;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a Meeting's place in NoteNote.
 * Guarantees: immutable; is valid as declared in {@link #isValidPlace(String)}
 */
public class Place {

    public static final String MESSAGE_CONSTRAINTS =
            "Places should only contain alphanumeric characters and spaces, and it should not be blank";

    public static final String VALIDATION_REGEX = "[\\p{Alnum}][\\p{Alnum} ]*";

    public final String fullPlace;

    /**
     * Constructs a {@code Place}.
     *
     * @param place A valid place.
     */
    public Place(String place) {
        requireNonNull(place);
        checkArgument(isValidPlace(place), MESSAGE_CONSTRAINTS);
        fullPlace = place;
    }

    /**
     * Returns true if a given string is a valid place.
     */
    public static boolean isValidPlace(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return fullPlace;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof Place)) {
            return false;
        }

        Place otherPlace = (Place) other;
        return fullPlace.equals(otherPlace.fullPlace);
    }

    @Override
    public int hashCode() {
        return fullPlace.hashCode();
    }
}
