package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_DESCRIPTION;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PLACE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TIME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TITLE;

import seedu.address.commons.util.ToStringBuilder;
import seedu.address.logic.Messages;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.meeting.Meeting;
import seedu.address.ui.AppState;

/**
 * Add a meeting to NoteNote.
 */
public class AddMeetingCommand extends Command {

    public static final String COMMAND_WORD = "add";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Adds a meeting to the address book. "
            + "Parameters: "
            + PREFIX_TITLE + " TITLE "
            + PREFIX_TIME + " TIME "
            + PREFIX_PLACE + " PLACE "
            + PREFIX_DESCRIPTION + " DESCRIPTION\n"
            + "Example: " + COMMAND_WORD + " "
            + PREFIX_TITLE + " Project Discussion "
            + PREFIX_TIME + " 03/10/2023 15:00 "
            + PREFIX_PLACE + " Terrace "
            + PREFIX_DESCRIPTION + " Discussing milestones";

    public static final String MESSAGE_SUCCESS = "New meeting added: %1$s";

    public static final String MESSAGE_DUPLICATE_MEETING = "This meeting already exists in the address book";

    private final Meeting toAdd;

    /**
     * Creates an AddMeetingCommand to add the specified {@code Meeting}
     */
    public AddMeetingCommand(Meeting meeting) {
        requireNonNull(meeting);
        toAdd = meeting;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        if (model.hasMeeting(toAdd)) {
            throw new CommandException(MESSAGE_DUPLICATE_MEETING);
        }
        model.addMeeting(toAdd);

        AppState appState = AppState.getInstance();
        appState.setMeeting(toAdd);

        return new CommandResult(String.format(MESSAGE_SUCCESS, Messages.formatMeeting(toAdd)));
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof AddMeetingCommand)) {
            return false;
        }

        AddMeetingCommand otherAddCommand = (AddMeetingCommand) other;
        boolean titleEquals = toAdd.getTitle().equals(otherAddCommand.toAdd.getTitle());
        boolean timeEquals = toAdd.getTime().equals(otherAddCommand.toAdd.getTime());
        boolean placeEquals = toAdd.getPlace().equals(otherAddCommand.toAdd.getPlace());
        boolean descriptionEquals = toAdd.getDescription().equals(otherAddCommand.toAdd.getDescription());

        return titleEquals && timeEquals && placeEquals && descriptionEquals;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("toAdd", toAdd)
                .toString();
    }
}
