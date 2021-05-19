package edu.eci.arsw.Ice2MeetU.entities;

import edu.eci.arsw.Ice2MeetU.persistence.exceptions.CommandMessagesException;

import java.util.HashMap;

public class CommandMessages {
    private HashMap<String,Messages> messages;

    public String getMessageByCommandAndLanguage(String command, String language) throws CommandMessagesException {
        if(!messages.containsKey(command)) throw new CommandMessagesException(CommandMessagesException.COMMAND_NO_FOUND);
        String message = messages.get(command).getMessageByLanguage(language);
        if(!message.equals("")) throw new CommandMessagesException(CommandMessagesException.LANGUAGE_NO_FOUND,language);
        return message;
    }

}
