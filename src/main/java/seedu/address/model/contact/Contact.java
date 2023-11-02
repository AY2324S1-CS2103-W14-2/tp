package seedu.address.model.contact;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import seedu.address.commons.util.ToStringBuilder;
import seedu.address.model.note.Note;
import seedu.address.model.tag.Tag;

/**
 * Represents a Contact in the address book.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class Contact {

    // Identity fields
    private final Name name;
    private final Phone phone;
    private final Email email;

    // Data fields
    private final Address address;
    private final Set<Tag> tags = new HashSet<>();
    private final Set<Note> notes = new HashSet<>();

    /**
     * Every field must be present and not null.
     */
    public Contact(Name name, Phone phone, Email email, Address address, Set<Tag> tags, Set<Note> notes) {
        requireAllNonNull(name, phone, email, address, tags, notes);
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.tags.addAll(tags);
        this.notes.addAll(notes);
    }

    public Name getName() {
        return name;
    }

    public String getNameString() {
        return name.toString();
    }

    public Phone getPhone() {
        return phone;
    }

    public Email getEmail() {
        return email;
    }

    public Address getAddress() {
        return address;
    }

    /**
     * Returns an immutable tag set, which throws {@code UnsupportedOperationException}
     * if modification is attempted.
     */
    public Set<Tag> getTags() {
        return Collections.unmodifiableSet(tags);
    }

    public String getTagString() {
        StringBuilder sb = new StringBuilder();
        Set<Tag> setTags = getTags();
        for (Tag tags : setTags) {
            sb.append(tags.toString() + " ");
        }
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1);
        } else {
            return "";
        }
        return sb.toString();
    }

    public Set<Note> getNotes() {
        return Collections.unmodifiableSet(notes);
    }

    public String getNoteString() {
        StringBuilder sb = new StringBuilder();
        Set<Note> setNotes = getNotes();
        for (Note notes : setNotes) {
            sb.append(notes.toString() + " #" + notes.getNoteID() + "\n");
        }
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1);
        } else {
            return "";
        }
        return sb.toString();
    }

    /**
     * Returns true if both contacts have the same name.
     * This defines a weaker notion of equality between two contacts.
     */
    public boolean isSameContact(Contact otherContact) {
        if (otherContact == this) {
            return true;
        }

        return otherContact != null
            && otherContact.getName().equals(getName());
    }

    /**
     * Returns true if both contacts have the same identity and data fields.
     * This defines a stronger notion of equality between two contacts.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof Contact)) {
            return false;
        }

        Contact otherContact = (Contact) other;
        return name.equals(otherContact.name)
            && phone.equals(otherContact.phone)
            && email.equals(otherContact.email)
            && address.equals(otherContact.address)
            && tags.equals(otherContact.tags)
            && notes.equals(otherContact.notes);
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(name, phone, email, address, tags, notes);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
            .add("name", name)
            .add("phone", phone)
            .add("email", email)
            .add("address", address)
            .add("tags", tags)
            .add("notes", notes)
            .toString();
    }

}
