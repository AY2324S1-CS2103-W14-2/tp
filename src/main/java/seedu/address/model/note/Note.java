package seedu.address.model.note;

import static java.util.Objects.requireNonNull;

/**
 * Represents a Contact's note in the address book.
 * Guarantees: immutable; is always valid
 */
public class Note {
    private static int noteCount = 1;
    public final String note;
    public final int noteID;

    /**
     * Constructs a {@code Note}.
     *
     * @param note A valid note.
     */
    public Note(String note) {
        requireNonNull(note);
        this.note = note;
        this.noteID = noteCount++;
    }

    public int getNoteID() {
        return noteID;
    }
    @Override
    public String toString() {
        return note;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Note // instanceof handles nulls
                && note.equals(((Note) other).note)); // state check
    }

    @Override
    public int hashCode() {
        return note.hashCode();
    }
}
