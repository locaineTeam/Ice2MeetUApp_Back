package edu.eci.arsw.Ice2MeetU.services;

import edu.eci.arsw.Ice2MeetU.persistence.exceptions.CommandMessagesException;
import org.springframework.stereotype.Service;

/**
 * The interface Command message service.
 */
@Service
public interface CommandMessageService {

    /**
     * Gets message by command and language.
     *
     * @param command  the command
     * @param language the language
     * @return the message by command and language
     * @throws CommandMessagesException the command messages exception
     */
    public String getMessageByCommandAndLanguage(String command, String language) throws CommandMessagesException;
}
