package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_INDEX;

import java.util.NoSuchElementException;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.ViewContactCommand;
import seedu.address.logic.parser.exceptions.ParseException;


/**
 * Parses input arguments and creates a new ViewContactCommand object
 */
public class ViewContactCommandParser implements Parser<ViewContactCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the ViewContactCommand
     * and returns a ViewContactCommand object for execution.
     *
     * @throws ParseException if the user input does not conform the expected format
     */
    public ViewContactCommand parse(String args) throws ParseException {
        ArgumentMultimap argMultimap = ArgumentTokenizer.tokenize(args, PREFIX_INDEX);
        Index index;
        try {
            index = Index.fromOneBased(Integer.parseInt(argMultimap.getValue(PREFIX_INDEX).get()));
        } catch (NoSuchElementException e) {
            throw new ParseException(
            String.format(MESSAGE_INVALID_COMMAND_FORMAT, ViewContactCommand.MESSAGE_USAGE), e);
        }
        return new ViewContactCommand(index);
    }
}
