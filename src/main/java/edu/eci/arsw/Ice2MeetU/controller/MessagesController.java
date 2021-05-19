package edu.eci.arsw.Ice2MeetU.controller;

import edu.eci.arsw.Ice2MeetU.persistence.exceptions.CommandMessagesException;
import edu.eci.arsw.Ice2MeetU.services.CommandMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * The type Messages controller.
 */
@RestController
@RequestMapping("/messages")
@CrossOrigin(origins = "*")
public class MessagesController {

    /**
     * The Command messages.
     */
    @Autowired
    CommandMessageService commandMessages;

    /**
     * Gets message by command and language.
     *
     * @param command  the command
     * @param language the language
     * @return the message by command and language
     */
// <editor-fold defaultstate="collapsed" desc="Attributes">
    @RequestMapping(value="/command/{command}/language/{language}",method= RequestMethod.GET)
    public ResponseEntity<?> getMessageByCommandAndLanguage(@PathVariable String command, @PathVariable String language) {

        try {
            String message = commandMessages.getMessageByCommandAndLanguage(command,language);
            return new ResponseEntity<>(message, HttpStatus.ACCEPTED);
        } catch (CommandMessagesException e) {
            return new ResponseEntity<>("Command Not Found: " +e.getMessage(), HttpStatus.NOT_FOUND);
        }

    }
    // </editor-fold>
}
