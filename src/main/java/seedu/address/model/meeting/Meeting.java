package seedu.address.model.meeting;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import seedu.address.commons.util.ToStringBuilder;
import seedu.address.model.contact.Contact;
import seedu.address.model.note.Note;

/**
 * Represents a Meeting in NoteNote.
 * Guarantees: details are present and not null, field values are validated.
 */
public class Meeting implements Comparable<Meeting> {

    private Title title;

    private Time time;

    private Place place;

    private Description description;
    private ArrayList<Note> notes = new ArrayList<>();
    private ArrayList<Contact> contacts = new ArrayList<>();

    /**
     * Every field must be present and not null.
     */
    public Meeting(Title title, Time time, Place place, Description description,
                   List<Note> notes, ArrayList<Contact> contacts) {
        requireAllNonNull(title, time, place, description, notes, contacts);
        this.title = title;
        this.time = time;
        this.place = place;
        this.description = description;
        this.notes.addAll(notes);
        this.contacts.addAll(contacts);
    }

    public Title getTitle() {
        return title;
    }

    public String getTitleString() {
        return title.toString();
    }

    public Time getTime() {
        return time;
    }

    public Place getPlace() {
        return place;
    }

    public Description getDescription() {
        return description;
    }

    public ArrayList<Note> getNotes() {
        return new ArrayList<>(Collections.unmodifiableList(notes));
    }

    public ArrayList<Contact> getContacts() {
        return new ArrayList<>(Collections.unmodifiableList(contacts));
    }

    /**
     * Returns the list of notes that belongs to this contact to be displayed
     *
     * @return String of the list of notes belonging to this contact
     */
    public String getNoteString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < notes.size(); i++) {
            int index = i + 1;
            sb.append(index + ". " + notes.get(i).toString() + "\n");
        }
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1);
        } else {
            return "";
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("title", title)
                .add("time", time)
                .add("place", place)
                .add("description", description)
                .add("notes", notes)
                .add("contacts", contacts)
                .toString();
    }

    /**
     * Returns true if both contacts have the same name.
     * This defines a weaker notion of equality between two contacts.
     */
    public boolean isSameMeeting(Meeting otherMeeting) {
        if (otherMeeting == this) {
            return true;
        }

        return otherMeeting != null
                && otherMeeting.getTitle().equals(getTitle());
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof Meeting)) {
            return false;
        }

        Meeting otherMeeting = (Meeting) other;
        return title.equals(otherMeeting.title)
                && time.equals(otherMeeting.time)
                && place.equals(otherMeeting.place)
                && description.equals(otherMeeting.description)
                && notes.equals(otherMeeting.notes)
                && contacts.equals(otherMeeting.contacts);
    }

    @Override
    public int compareTo(Meeting other) {
        Time otherTime = other.time;
        if (time.getValue().isBefore(otherTime.getValue())) {
            return -1;
        } else if (time.getValue().isAfter(otherTime.getValue())) {
            return 1;
        }
        return 0;
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(title, time, place, description);
    }

}
