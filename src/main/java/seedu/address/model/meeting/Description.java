package seedu.address.model.meeting;

import static java.util.Objects.requireNonNull;

/**
 * Represents a Meeting's description in NoteNote.
 * Guarantees: immutable;
 */
public class Description {

    public static final String MESSAGE_CONSTRAINTS =
            "Descriptions can be any character including empty string and newline";

    public final String fullDescription;

    /**
     * Constructs a {@code Description}.
     *
     * @param description A valid meeting description.
     */
    public Description(String description) {
        requireNonNull(description);
        fullDescription = description;
    }

    public String toString() {
        return fullDescription;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof Description)) {
            return false;
        }

        Description otherDescription = (Description) other;
        return fullDescription.equals(otherDescription.fullDescription);
    }

    @Override
    public int hashCode() {
        return fullDescription.hashCode();
    }
}
