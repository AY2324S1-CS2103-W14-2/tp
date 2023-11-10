# User Guide

NoteNote is a desktop meeting note-taking application that allows users to efficiently record notes for their contact.
NoteNote provide tools for organizing and categorizing contacts in a systematic and easy-to-navigate structure.

## Table of Contents
- [Mode](#mode)
- [Contact Management](#contact-management)
    - [Create New Contact](#create-new-contact)
    - [View a Contact](#view-a-contact)
    - [List All Contacts](#list-all-contacts)
    - [Delete a Contact](#delete-a-contact)
- [Meeting Management](#meeting-management)
    - [Create a New Meeting](#create-a-new-meeting)
    - [View a Meeting](#view-a-meeting)
    - [List All Meetings](#list-all-meetings)
    - [Delete a Meeting](#delete-a-meeting)
    - [Edit a Meeting](#edit-a-meeting)
    - [Add Contact to Meeting](#add-contact-to-meeting)
    - [Delete Contact from Meeting](#delete-contact-from-meeting)
- [Note-Taking](#note-taking)
    - [Add Notes to a Contact or Meeting](#add-notes-to-a-contact-or-meeting)
    - [Delete Notes from a Contact or Meeting](#delete-notes-from-a-contact-or-meeting)
- [Miscellaneous](#miscellaneous)
    - [View List of Available Commands](#view-list-of-available-commands)
- [Known Issues](#known-issues)
---

### Mode

- **What it does**: Toggles the mode of the application between `contacts` and `meetings`. The application defaults to
  the "contacts" mode. The mode of the application determines the context in which the following commands are executed
  upon for example performing an `add` command in `contacts` mode will add a contact while using an `add` command in `meetings` mode will add a meeting.
  The following commands are affected by the mode of the application:
    1. `add`
    2. `view`
    3. `edit` 
    4. `delete`
    5. `addnote`
    6. `deletenote`
    7. `list`

- **Command Format**: `mode`

- **Expected Outputs**:
    - “Application mode set: [CURRENT_MODE].”

---

## Contact Management:

### Create New Contact

- **What it does**: Adds a new contact to the list when in the `contacts` mode. Users are considered the same if they have the same name (case-sensitive).

- **Command Format**: `add n/CONTACT_NAME p/PHONE_NUMBER e/EMAIL_ADDRESS a/RESIDENTIAL_ADDRESS [t/TAGS]`

- **Example**: `add n/Sarah Woo p/82775346 e/sarah.woo@gmail.com a/Blk227 Sims Drive`

- **Acceptable Values**:
    - CONTACT_NAME: String, alphanumeric values and at least 2 characters long. Case-sensitive.
    - PHONE_NUMBER: Integers, at least 3 digits long.
    - EMAIL_ADDRESS: String, any valid email address.
    - RESIDENTIAL_ADDRESS: String, any value.
    - TAGS: String, alphanumeric values.

- **Expected Outputs**:
    - Success: "Successfully added [CONTACT_NAME];Phone:[PHONE_NUMBER];Email:[EMAIL_ADDRESS];Address:[RESIDENTIAL_ADDRESS];Tags:[TAGS]."
    - Failure:
        - If the CONTACT_NAME already exists: `This contact already exists in the address book`
        - If invalid command format: `Invalid command format!
          add: Adds a contact to the address book. Parameters: n/ NAME p/ PHONE e/ EMAIL a/ ADDRESS [t/ TAG]...
          Example: add n/ John Doe p/ 98765432 e/ johnd@example.com a/ 311, Clementi Ave 2, #02-25 t/ friends t/ owesMoney`
        - If multiple values specified for a parameter: `Multiple values specified for the following single-valued field(s): [Parameters]`
        - If unacceptable parameter values: Appropriate error message returned.

---

### View a Contact

- **What it does**: Displays details of a specific contact when in the `contacts` mode.

- **Command Format**: `view CONTACT_ID`

- **Example**: `view 1`

- **Acceptable Values**:
    - CONTACT_ID: Positive integer. Must be a value that exists in the contact list.

- **Expected Outputs**:
    - Success: "Showing Contact Note: [CONTACT_NAME];Phone:[PHONE_NUMBER];Email:[EMAIL_ADDRESS];Address:[RESIDENTIAL_ADDRESS];Tags:[TAGS]."
    - Failure:
        - If the positive CONTACT_ID does not exist: `The contact index provided is invalid`
        - If invalid command format: `Invalid command format!
          view: Shows the details of the contact identified by its id in the displayed contact list.
          Parameters: CONTACT_ID (must be a positive integer)
          Example: view 1`

---

### List All Contacts

- **What it does**: Shows all contacts in the list when in the `contacts` mode. All fields after list are optional
  arguments. If no valid parameter provided, list all contacts.

- **Command Format**: `list [n/NAME] [p/PHONE] [e/EMAIL] [a/ADDRESS] [t/TAG] [note/NOTE]`

- **Expected Outputs**:
    - Success: `Listed all contacts.`

---

### Editing A Contact

- **What it does**: Edits an existing person in the address book when in the `contacts` mode.

- **Command Format**: `edit id/CONTACT_ID [n/CONTACT_NAME] [p/PHONE_NUMBER] [e/EMAIL_ADDRESS] [a/RESIDENTIAL_ADDRESS] [t/TAGS]`

- **Example**: `edit id/3 p/90649923`
- 
- **Acceptable Values**:
    - CONTACT_ID: Positive integer. Must be a value that exists in the contact list.
    - CONTACT_NAME: String, alphanumeric values and at least 2 characters long. Case-sensitive.
    - PHONE_NUMBER: Integers, at least 3 digits long.
    - EMAIL_ADDRESS: String, any valid email address.
    - RESIDENTIAL_ADDRESS: String, any value.
    - TAGS: String, alphanumeric values.
 
- **Expected Outputs**:
  - Success: "Edited Contact: [CONTACT_NAME];Phone:[PHONE_NUMBER];Email:[EMAIL_ADDRESS];Address:[RESIDENTIAL_ADDRESS];Tags:[TAGS]."
  - Failure:
      - If no field to edit is specified: `At least one field to edit must be provided.`
      - If the CONTACT_ID does not exist: `The contact index provided is invalid`
      - If multiple values specified for a parameter: `Multiple values specified for the following single-valued field(s): [Parameters]`
      - If unacceptable parameter values: Appropriate error message returned.
    
---

### Delete a Contact

- **What it does**: Removes a contact based on the given ID when in the `contacts` mode.

- **Command Format**: `delete CONTACT_ID`

- **Example**: `delete 3`

- **Acceptable Values**:
    - CONTACT_ID: Positive integer. Must be a value that exists in the contact list.

- **Expected Outputs**:
    - Success: "Deleted Contact: [CONTACT_NAME];Phone:[PHONE_NUMBER];Email:[EMAIL_ADDRESS];Address:[RESIDENTIAL_ADDRESS];Tags:[TAGS]."
    - Failure:
        - If the CONTACT_ID does not exist: `The contact index provided is invalid`
        - If the command is invalid: `Invalid command format!
          delete: Deletes the contact identified by the index number used in the displayed contact list.
          Parameters: INDEX (must be a positive integer)
          Example: delete 1`

---

## Meeting Management:

### Create a New Meeting

- **What it does**: Creates a new meeting when in the `meetings` mode.

- **Command Format**: `add m/MEETING_NAME t/TIME p/LOCATION d/DESCRIPTION`

- **Example**: `add m/ Project Discussion t/ 03/10/2023 15:00 p/ Terrace d/ Discussing mileston`

- **Acceptable Values**:
    - MEETING_NAME: String, alphanumeric values and at least 1 character long.
    - TIME: Follow the `DD/MM/YYYY HH:MM` format
    - LOCATION: String, alphanumeric values and at least 1 character long.
    - DESCRIPTION: String, any value.

- **Expected Outputs**:
    - Success: "New meeting added: [MEETING_NAME];Time:[TIME];Place:[LOCATION];Description:[DESCRIPTION]"
    - Failure:
        - If the MEETING_NAME already exists: `Meeting already exists.`
        - If invalid command format: `Invalid command format!
          add: Adds a meeting to the address book. Parameters: m/ TITLE t/ TIME p/ PLACE d/ DESCRIPTION
          Example: add m/ Project Discussion t/ 03/10/2023 15:00 p/ Terrace d/ Discussing milestones`
        - If multiple values specified for a parameter: `Multiple values specified for the following single-valued field(s): [Parameters]`
        - If unacceptable parameter values: Appropriate error message returned.

---

### View a Meeting

- **What it does**: Displays details of a specific meeting when in the `meetings` mode.

- **Command Format**: `view MEETING_ID`

- **Example**: `view 1`

- **Acceptable Values**:
    - MEETING_ID: Positive integer. Must be a value that exists in the meeting list.

- **Expected Outputs**:
    - Success: "Showing Meeting: [MEETING_NAME];Time:[TIME];Place:[LOCATION];Description:[DESCRIPTION]"
    - Failure:
        - If the MEETING_ID does not exist: `The meeting index provided is invalid`
        - If the command is invalid: `Invalid command format!
          view: Shows the details of the meeting identified by its id in the displayed meeting list.
          Parameters: INDEX (must be a positive integer)
          Example: view 1`

---

### List All Meetings

- **What it does**: Shows a list of all meetings when in the `meetings` mode. All arguments after `list` are optional arguments. Other commands which use index will be affected by the updated indexes shown on the GUI.
  If no valid parameter provided, list all meetings.
- **Command Format**: `list [m/TITLE] [t/TIME] [p/PLACE] [d/DESCRIPTION] [note/NOTE]`

- **Expected Outputs**:
    - Success: `%d meetings Listed!`

### Delete a Meeting

- **What it does**: Cancels a meeting based on the given ID when in the "meetings" mode.

- **Command Format**: `delete MEETING_ID`

- **Example**: `delete 1`

- **Acceptable Values**:
    - MEETING_ID: Positive integer. Must be a value that exists in the meeting list.
- **Expected Outputs**:
    - Success: "Successfully deleted [MEETING_NAME]."
    - Failure:
        - If the MEETING_ID does not exist: `The meeting index provided is invalid`
        - If the MEETING_ID is not provided OR If invalid command format: `Invalid command format`

---

### Edit A Meeting

- **What it does** Edits the details of an existing meeting in the address book when in the `meetings` mode.

- **Command Format**: `edit id/MEETING_ID [m/MEETING_NAME] [t/TIME] [p/LOCATION] [d/DESCRIPTION]`

- **Example**: `edit id/1 p/COM3`

- **Acceptable Values**:
    - MEETING_ID: Positive integer. Must be a value that exists in the meeting list.
    - MEETING_NAME: String, alphanumeric values and at least 1 character long.
    - TIME: Follow the `DD/MM/YYYY HH:MM` format
    - LOCATION: String, alphanumeric values and at least 1 character long.
    - DESCRIPTION: String, any value.

- **Expected Outputs**:
    - Success: "Edited Meeting [MEETING_NAME];Time:[TIME];Place:[LOCATION];Description:[DESCRIPTION]"
    - Failure:
        - If the MEETING_ID does not exist: `The meeting index provided is invalid`
        - If invalid command format: `Invalid command format!
          edit: Edits the details of the meeting identified by the index number used in the displayed meeting list. Existing values will be overwritten by the input values.
          Parameters: INDEX (must be a positive integer) [m/ TITLE] [t/ TIME] [p/ PLACE] [d/ DESCRIPTION]...
          Example: edit 1 p/ Zoom d/ Discuss Project Details`
        - If no parameters provided: `At least one field to edit must be provided.`
        - If multiple values specified for a parameter: `Multiple values specified for the following single-valued field(s): [Parameters]`
        - If unacceptable parameter values: Appropriate error message returned.

---

### Add Contact to Meeting

- **What it does**: Adds a contact to an existing meeting as a participant when in the `meetings` mode.
  No duplicate meetings are allowed and meetings are considered to be the same if they have the same name.

- **Command Format**: `addcontact n/CONTACT_NAME m/MEETING_NAME`

- **Example**: `addcontact n/Sarah Woo m/Project Discussion`

- **Acceptable Values**:
    - MEETING_NAME: String, must exist in meeting list. Case-sensitive.
    - CONTACT_NAME: String, must exist in contact list. Case-sensitive.

- **Expected Outputs**:
    - Success: "Added contact '[CONTACT_NAME]' to Meeting '[MEETING_NAME]'."
    - Failure:
        - If the MEETING_NAME does not exist: `The meeting specified is not created`
        - If the CONTACT_NAME does not exist: `The person specified is not created`
        - If the CONTACT_NAME is already in the existing meeting: `This contact already exists in the meeting`
        - If invalid command format: `Invalid command format!
          add contact to meeting: Adds a contact to an existing meeting. Parameters: n/CONTACT_NAME m/MEETING_NAME Example: addcontact n/Sarah Woo m/Project Discussion`

---

### Delete Contact from Meeting

- **What it does**: Removes a contact from an existing meeting when in the `meetings` mode.

- **Command Format**: `deletecontact n/CONTACT_NAME m/MEETING_NAME`

- **Example**: `deletecontact n/Sarah Woo m/Project Discussion`

- **Acceptable Values**:
    - MEETING_NAME: String, at least 2 characters long. Case sensitive.
    - CONTACT_NAME: String, at least 2 characters long. Case sensitive.

- **Expected Outputs**:
    - Success: "Removed contact '[CONTACT_NAME]' from Meeting '[MEETING_NAME]'."
    - Failure:
        - If the MEETING_NAME does not exist: `The meeting specified is not created`
        - If the CONTACT_NAME does not exist or isn't a part of the specified
          meeting: `The person specified is not created`
        - If invalid command format: `Invalid command format!
          deletecontact : Removes a contact from an existing meeting. Parameters: n/CONTACT_NAME m/MEETING_NAME Example: deletecontact n/Sarah Woo m/Project Discussion`

---

## Note-Taking:

### Add Notes to a Contact or Meeting

- **What it does**: Associates notes with a specific contact or meeting

- **Command Format**:
    - For Contacts when in "Contacts" mode: `addnote id/CONTACT_ID note/NOTES`
    - For Meetings when in "Meetings" mode: `addnote id/MEETING_ID note/NOTES`

- **Examples**:
    - `addnote id/5 note/Has a dog named Benny`
    - `addnote id/1 note/Agenda: Discuss Q2 results`

- **Acceptable Values**:
    - CONTACT_ID: Non-negative integer within range of Contact indexes.
    - MEETING_ID: Non-negative integer within range of Meeting indexes.
    - NOTES: String, at least 1 character long.

- **Expected Outputs**:
    - Success:
        - "Successfully added note to Contact: [Details of CONTACT]."
        - "Successfully added note to Meeting: [Details of MEETING]."
    - Failure:
        - If the CONTACT_ID or CONTACT_NAME does not exist: `The contact index provided is invalid`
        - If the MEETING_ID or MEETING_NAME does not exist: `The meeting index provided is invalid`
        - If the NOTES already exists for a given contact/meeting: `Error: the note already exists.`
        - If the NOTES aren't provided OR If invalid command format: `Invalid command format!
          addnote: Add notes to contact Parameters: id/CONTACT_ID_or_CONTACT_NAME note/NOTES Example: addnote id/5 note/ Has a dog named Benny`

---

### Delete Notes from a Contact or Meeting

- **What it does**: Removes specified notes from a contact or meeting.

- **Command Format**:
    - For Contacts when in "Contacts" mode: `deletenote id/CONTACT_ID noteid/NOTE_ID`
    - For Meetings when in "Meetings" mode: `deletenote id/MEETING_ID noteid/NOTE_ID`

- **Examples**:
    - `deletenote id/5 noteid/2`

- **Acceptable Values**:
    - CONTACT_ID: Non-negative integer within range of Contact indexes.
    - MEETING_ID: Non-negative integer within range of Meeting indexes.
    - NOTE_ID: Non-negative integer within range of noteIDs. ID of the note as displayed in the notes list of a contact or meeting.

- **Expected Outputs**:
    - Success:
        - "Removed note from Contact: [Details of CONTACT]."
        - "Removed note from Meeting: [Details of MEETING]."
    - Failure:
        - If the CONTACT_ID does not exist: `The contact index provided is invalid`
        - If the MEETING_ID does not exist: `The meeting index provided is invalid`
        - If no note exists for the specified note index in the contact or meeting: `Failed to remove note from Meeting: {Meeting Details}`
        - If invalid command format: `Invalid command format!
          deletenote: Remove notes from contact Parameters: id/CONTACT_ID_or_CONTACT_NAME index/INDEX Example: deletenote id/5 noteid/1`
---

## Miscellaneous:

### View List of Available Commands

- **What it does**: Displays a list of available commands for the user.

- **Command Format**: `help`

- **Expected Outputs**:
    - Success: `Opened help window.` Displays a pop-up window with a link to the user guide.

---

### Clear AddressBook

- **What it does**: Clears all contacts and meetings from memory in the entire address book.

- **Command Format**: `clear`

- **Expected Outputs**:
    - Success: `Address book has been cleared!`

---

### Exit Command

- **What it does**: Close the application window.

- **Command Format**: `exit`

- **Expected Outputs**:
    - Success: The window is closed and the program stops running.

## Known Issues

- Newly added contacts/meetings are not automatically selected without scrolling down when there are several contacts/meetings already existing. However when adding a new contact the result box is updated for visual feedback.
- Some users reported that the scrollbar of the contact/meeting list disappears when the screen size is too small.
