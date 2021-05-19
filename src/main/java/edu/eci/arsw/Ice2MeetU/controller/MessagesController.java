package edu.eci.arsw.Ice2MeetU.controller;

import edu.eci.arsw.Ice2MeetU.entities.CommandMessages;
import edu.eci.arsw.Ice2MeetU.persistence.exceptions.CommandMessagesException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/messages")
@CrossOrigin(origins = "*")
public class MessagesController {

    // <editor-fold defaultstate="collapsed" desc="Attributes">
    @RequestMapping(value="/command/{command}/language/{language}",method= RequestMethod.GET)
    public ResponseEntity<?> getMessageByCommandAndLanguage(@PathVariable String command, @PathVariable String language) {
        CommandMessages commandMessages = new CommandMessages();
        try {
            String message = commandMessages.getMessageByCommandAndLanguage(command,language);
            return new ResponseEntity<>(message, HttpStatus.ACCEPTED);
        } catch (CommandMessagesException e) {
            e.printStackTrace();
            return new ResponseEntity<>("Command Not Found", HttpStatus.NOT_FOUND);
        }

    }
    // </editor-fold>
}
